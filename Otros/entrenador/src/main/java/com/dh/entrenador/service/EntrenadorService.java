package com.dh.entrenador.service;

import com.dh.entrenador.model.Entrenador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EntrenadorService implements IEntrenadorService {

    @Override
    public List<Entrenador> listaEntrenador() {
        return Arrays.asList(new Entrenador("Pibe"), new Entrenador("Roman"));
    }
}
