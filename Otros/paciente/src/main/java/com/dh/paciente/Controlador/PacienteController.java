package com.dh.paciente.Controlador;

import com.dh.paciente.Modelo.Paciente;
import com.dh.paciente.Servicios.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class PacienteController {

    @Autowired
    public PacienteService pacienteService;

    @GetMapping("/todos")
    public List<Paciente> getAll(){
        return pacienteService.listarPacientes();
    }

    @GetMapping("/email")
    public String getPacientByEmail(@RequestParam(name="name", required=false, defaultValue="juangonzalez2@yahoo.com") String email, Model model){
        Paciente paciente= pacienteService.getPacientePorEmail(email);

        if(paciente == null) return "no se encontro paciente con ese email";

        model.addAttribute("name", paciente.getNombre());
        model.addAttribute("surname", paciente.getApellido());

        return "index";
    }
}

