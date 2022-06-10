package com.dh.clinicaodontologica.controllers;

import com.dh.clinicaodontologica.models.Paciente;
import com.dh.clinicaodontologica.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PacienteController {

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Autowired
    public PacienteService pacienteService;

    @GetMapping("/todos")
    public String getPacientes(Model model) {

        List<Paciente> pacientes = pacienteService.getPacientes();

        if (pacientes == null) return "No hay pacientes";

        model.addAttribute("pacientes", pacientes);

        return "todos";

    }

    @GetMapping("/email")
    public String getPacienteByEmail(@RequestParam(name="name", required=false, defaultValue="juangonzalez2@yahoo.com") String email, Model model) {
        Paciente paciente = pacienteService.getPacienteByEmail(email);

        if (paciente == null) return "No se encontró paciente con ese mail";

        model.addAttribute("name", paciente.getNombre());
        model.addAttribute("surname", paciente.getApellido());

        return "index";
    }
}


