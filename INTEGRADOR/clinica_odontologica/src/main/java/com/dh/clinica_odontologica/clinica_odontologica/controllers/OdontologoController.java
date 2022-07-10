package com.dh.clinica_odontologica.clinica_odontologica.controllers;

import com.dh.clinica_odontologica.clinica_odontologica.dto.OdontologoDTO;
import com.dh.clinica_odontologica.clinica_odontologica.models.Odontologo;
import com.dh.clinica_odontologica.clinica_odontologica.services.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Odontologo> crearOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.crearOdontologo(odontologo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscarOdontologo(@PathVariable Long id){
        OdontologoDTO odontologoDTO = odontologoService.buscarOdontologo(id);
        return ResponseEntity.ok(odontologoDTO);
    }

    @PutMapping()
    public ResponseEntity<Odontologo> modificarOdontologo(@RequestBody Odontologo odontologo) {
        ResponseEntity<Odontologo> response = null;
        if (odontologo.getId() != null && odontologoService.buscarOdontologo(odontologo.getId()) != null)
            response = ResponseEntity.ok(odontologoService.modificarOdontologo(odontologo));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (odontologoService.buscarOdontologo(id) != null) {
            odontologoService.eliminarOdontologo(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Odontologo eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
    @GetMapping()
    public ResponseEntity<Set<OdontologoDTO>> buscarTodos(){
        return ResponseEntity.ok(odontologoService.listarOdontologos());
    }

}
