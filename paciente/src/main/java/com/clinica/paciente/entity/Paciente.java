package com.clinica.paciente.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;
    private String rut;
    private String nombre;
    private String apellido;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    private String telefono;
}
