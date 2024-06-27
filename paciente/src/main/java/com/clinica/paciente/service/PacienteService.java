package com.clinica.paciente.service;

import com.clinica.paciente.entity.Paciente;

import java.util.List;

public interface PacienteService {

    void createPaciente(Paciente paciente);

    List<Paciente> findAllPacientes();

    Paciente findPacienteById(Long id);

    Paciente findPacienteByRut(String rut);

    void deletePaciente(Long id);

    Paciente updatePaciente(Long id, Paciente paciente);
}
