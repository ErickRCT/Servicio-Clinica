package com.clinica.turno.service;

import com.clinica.turno.dto.TurnoDto;
import com.clinica.turno.dto.PacienteDto;
import com.clinica.turno.entity.Turno;
import com.clinica.turno.repository.PacienteApi;
import com.clinica.turno.repository.TurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TurnoServiceImpl implements TurnoService{

    private PacienteApi pacienteApi;

    private TurnoRepository turnoRepository;

    private RestTemplate consumirApi;

    @Override
    public List<Turno> findAllTurnos() {
        return turnoRepository.findAll();
    }



    @Override
    public Turno findTurnoById(Long id) {
        return turnoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveTurno(TurnoDto turnoDto) {
        //buscar paciente en la API paciente
        PacienteDto paciente = this.obtenerPacientePorRut(turnoDto.getRut()); //buscar en la API
        String nombreApellidoPaciente = paciente.getNombre() + " " + paciente.getApellido();//lo que consumo el nombre y el apellido del paciente
        Turno turno = new Turno();
        turno.setFecha(turnoDto.getFecha());
        turno.setTratamiento(turnoDto.getTratamiento());
        turno.setNombreApellidoPaciente(nombreApellidoPaciente);

        turnoRepository.save(turno);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Turno updateTurno(Long id, Turno turno) {
        Turno turnoEditado = this.findTurnoById(id);
        if (turnoEditado != null) {
            turnoEditado.setFecha(turno.getFecha());
            turnoEditado.setTratamiento(turno.getTratamiento());
            turnoEditado.setNombreApellidoPaciente(turno.getNombreApellidoPaciente());
            turnoRepository.save(turnoEditado);
            return this.findTurnoById(id);
        } else {
            return null;
        }
    }

    @Override
    public PacienteDto obtenerPacientePorRut(String rut) {
        return pacienteApi.obtenerPacientePorRut(rut);
    }
}
