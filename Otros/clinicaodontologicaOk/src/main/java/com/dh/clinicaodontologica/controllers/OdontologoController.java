package com.dh.clinicaodontologica.controllers;

import com.dh.clinicaodontologica.models.Odontologo;
import com.dh.clinicaodontologica.services.OdontologoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OdontologoController {


    //@Autowired
    public OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping("/odontologo/todos")
    public List<Odontologo> getOdontologos() {
        return odontologoService.getOdontologos();
    }

    @GetMapping("/odontologo/{id}")
    public String getOdontologoByEmail(@PathVariable(name="id") int id, Model model) {
        Odontologo odontologo = odontologoService.getOdontologoById(id);

        if (odontologo == null) return null;

        model.addAttribute("matricula", odontologo.getMatricula());

        return "indexOdontologo";
    }
    
}
