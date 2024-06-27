package com.clinica.paciente.controller;

import com.clinica.paciente.entity.Paciente;
import com.clinica.paciente.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@AllArgsConstructor
public class PacienteController {

    private PacienteService pacienteService;

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Paciente paciente) {
        pacienteService.createPaciente(paciente);
        return ResponseEntity.ok().body("Paciente creado correctamente");
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtener(@PathVariable Long id) {

        Paciente paciente = pacienteService.findPacienteById(id);
        if (paciente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente no encontrado");
        } else {
            return ResponseEntity.ok().body(paciente);
        }
    }

    @GetMapping("/obtenerPorRut/{rut}")
    public ResponseEntity<?> obtenerPorRut(@PathVariable String rut) {
        Paciente paciente = pacienteService.findPacienteByRut(rut);
        if (paciente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente no encontrado");
        } else {
            return ResponseEntity.ok().body(paciente);
        }

    }

    @GetMapping("/obtenerTodo")
    public ResponseEntity<?> obtenerTodo() {
        List<Paciente> pacientes = pacienteService.findAllPacientes();
        if (pacientes.isEmpty() || pacientes == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hay pacientes para mostrar");
        } else {
            return ResponseEntity.ok().body(pacientes);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
        return ResponseEntity.ok().body("Paciente eliminado correctamente");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar(@RequestBody Paciente paciente,
                                           @PathVariable Long id) {
        Paciente pacienteEditado = pacienteService.findPacienteById(id);
        if (pacienteEditado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente no encontrado");
        } else {
            return ResponseEntity.ok().body(pacienteEditado);
        }
    }
}
