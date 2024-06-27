package com.clinica.paciente.repository;

import com.clinica.paciente.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("SELECT p FROM Paciente p WHERE p.rut = :rut")
    Paciente findByRut(@Param("rut") String rut);
}
