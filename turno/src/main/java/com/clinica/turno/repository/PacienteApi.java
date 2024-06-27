package com.clinica.turno.repository;

import com.clinica.turno.dto.PacienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pacienteApi",url = "http://localhost:9001/paciente/obtenerPorRut")
public interface PacienteApi {

    @GetMapping("/{rut}")
    PacienteDto obtenerPacientePorRut(@PathVariable("rut") String rut);

}
