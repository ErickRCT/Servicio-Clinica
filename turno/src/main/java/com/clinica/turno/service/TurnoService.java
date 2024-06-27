package com.clinica.turno.service;

import com.clinica.turno.dto.PacienteDto;
import com.clinica.turno.dto.TurnoDto;
import com.clinica.turno.entity.Turno;

import java.time.LocalDate;
import java.util.List;

public interface TurnoService {

    List<Turno> findAllTurnos();

    Turno findTurnoById(Long id);

    void saveTurno(TurnoDto turnoDto);

    void deleteTurno(Long id);

    Turno updateTurno(Long id,Turno turno);

    PacienteDto obtenerPacientePorRut(String rut);
}
