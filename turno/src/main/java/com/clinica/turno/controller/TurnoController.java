package com.clinica.turno.controller;

import com.clinica.turno.dto.TurnoDto;
import com.clinica.turno.entity.Turno;
import com.clinica.turno.service.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turno")
@AllArgsConstructor
public class TurnoController {

    private TurnoService turnoService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearTurno(@RequestBody TurnoDto turnoDto) {

        turnoService.saveTurno(turnoDto);
        return ResponseEntity.ok().body("Turno creado correctamente");
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerTurno(@PathVariable Long id) {
        Turno turno = turnoService.findTurnoById(id);
        if (turno == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turno no encontrado");
        } else {
            return ResponseEntity.ok(turno);
        }
    }

    @GetMapping("/obtenerTodo")
    public ResponseEntity<?> obtenerTurnos() {
        List<Turno> turnos = turnoService.findAllTurnos();
        if (turnos == null || turnos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hay turnos para mostrar");
        } else {
            return ResponseEntity.ok(turnos);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) {
        turnoService.deleteTurno(id);
        return ResponseEntity.ok().body("Turno eliminado correctamente");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarTurno(@PathVariable Long id, @RequestBody Turno turno) {
        Turno turnoEditado = turnoService.updateTurno(id, turno);
        if (turnoEditado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turno no encontrado");
        } else {
            return ResponseEntity.ok(turnoEditado);
        }
    }
}
