package com.dh.clinica_odontologica.clinica_odontologica.controllers;

import com.dh.clinica_odontologica.clinica_odontologica.dto.TurnoDTO;
import com.dh.clinica_odontologica.clinica_odontologica.models.Turno;
import com.dh.clinica_odontologica.clinica_odontologica.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    TurnoService turnoService;

    @PostMapping
    public ResponseEntity<Turno> crear(@RequestBody TurnoDTO turno){
        return ResponseEntity.ok(turnoService.crearTurno(turno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscar(@PathVariable Long id){
        TurnoDTO turnoDTO = turnoService.buscarTurno(id);
        return ResponseEntity.ok(turnoDTO);
    }

    @PutMapping()
    public ResponseEntity<Turno> modificar(@RequestBody Turno turno) {
        ResponseEntity<Turno> response = null;
        if (turno.getId() != null && turnoService.buscarTurno(turno.getId()) != null)
            response = ResponseEntity.ok(turnoService.modificarTurno(turno));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (turnoService.buscarTurno(id) != null) {
            turnoService.eliminarTurno(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Turno eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
    @GetMapping()
    public ResponseEntity<Set<TurnoDTO>> buscarTodos(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }

}
