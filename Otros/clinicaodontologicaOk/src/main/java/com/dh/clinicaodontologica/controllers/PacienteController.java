package com.dh.clinicaodontologica.controllers;

import com.dh.clinicaodontologica.models.Odontologo;
import com.dh.clinicaodontologica.models.Paciente;
import com.dh.clinicaodontologica.services.OdontologoService;
import com.dh.clinicaodontologica.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PacienteController {

    //@Autowired
    public PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/todos")
    public List<Paciente> getPacientes() {
        return pacienteService.getPacientes();
    }

    @GetMapping("/email")
    public String getPacienteByEmail(@RequestParam(name="email", required=false, defaultValue="juangonzalez1@yahoo.com") String email, Model model) {
        Paciente paciente = pacienteService.getPacienteByEmail(email);

        if (paciente == null) return null;

        model.addAttribute("name", paciente.getNombre());
        model.addAttribute("surname", paciente.getApellido());

        return "indexPaciente";
    }


}
