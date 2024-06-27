package com.clinica.turno.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurno;
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;
    private String tratamiento;
    private String nombreApellidoPaciente;
}
