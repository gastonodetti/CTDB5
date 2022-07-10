package com.dh.clinica_odontologica.clinica_odontologica.controllers;

import com.dh.clinica_odontologica.clinica_odontologica.dto.PacienteDTO;
import com.dh.clinica_odontologica.clinica_odontologica.models.Paciente;
import com.dh.clinica_odontologica.clinica_odontologica.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> crear(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.crearPaciente(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscar(@PathVariable Long id){
        PacienteDTO pacienteDTO = pacienteService.buscarPaciente(id);
        return ResponseEntity.ok(pacienteDTO);
    }

    @PutMapping()
    public ResponseEntity<Paciente> modificar(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;
        if (paciente.getId() != null && pacienteService.buscarPaciente(paciente.getId()) != null)
            response = ResponseEntity.ok(pacienteService.modificarPaciente(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (pacienteService.buscarPaciente(id) != null) {
            pacienteService.eliminarPaciente(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Paciente eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
    @GetMapping()
    public ResponseEntity<Set<PacienteDTO>> buscarTodos(){
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }

}
