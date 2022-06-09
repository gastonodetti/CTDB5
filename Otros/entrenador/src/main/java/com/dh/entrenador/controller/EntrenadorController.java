package com.dh.entrenador.controller;

import com.dh.entrenador.model.Entrenador;
import com.dh.entrenador.service.IEntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EntrenadorController {

    private final IEntrenadorService entrenadorService;

    @Autowired
    public EntrenadorController(IEntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping("/entrenador")
    public List<Entrenador> getEntrenador() {
        return entrenadorService.listaEntrenador();
    }
}
