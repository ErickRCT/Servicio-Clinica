package com.clinica.paciente.service;

import com.clinica.paciente.entity.Paciente;
import com.clinica.paciente.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    private PacienteRepository pacienteRepository;

    @Override
    public void createPaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    @Override
    public List<Paciente> findAllPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente findPacienteById(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public Paciente findPacienteByRut(String rut) {
        return pacienteRepository.findByRut(rut);
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente updatePaciente(Long id, Paciente paciente) {
        Paciente pacienteOriginal = this.findPacienteById(id);
        if (pacienteOriginal != null) {
            pacienteOriginal.setNombre(paciente.getNombre());
            pacienteOriginal.setApellido(paciente.getApellido());
            pacienteOriginal.setRut(paciente.getRut());
            pacienteOriginal.setTelefono(paciente.getTelefono());
            pacienteOriginal.setFechaNacimiento(paciente.getFechaNacimiento());
            pacienteRepository.save(pacienteOriginal);
            return this.findPacienteById(id);
        } else {
            return null;
        }
    }
}
