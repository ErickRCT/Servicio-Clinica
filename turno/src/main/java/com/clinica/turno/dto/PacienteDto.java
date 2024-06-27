package com.clinica.turno.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDto {
    private Long idPaciente;
    private String rut;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String telefono;
}
