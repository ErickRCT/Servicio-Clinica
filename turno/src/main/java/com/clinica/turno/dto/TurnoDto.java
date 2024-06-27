package com.clinica.turno.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnoDto {
    private LocalDate fecha;
    private String tratamiento;
    private String rut;

}
