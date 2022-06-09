package com.dh.paciente;

import com.dh.paciente.Dominio.Domicilio;
import com.dh.paciente.Dominio.Paciente;
import com.dh.paciente.Servicios.PacienteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController

public class PacienteApplication {



	public static void main(String[] args) {
		SpringApplication.run(PacienteApplication.class, args);

		//instancio pacientes y domicilio
		Domicilio p1Dom = new Domicilio("calle 1","4000", "cba", "cba");
		Paciente p1 = new Paciente(1,"lopez","juan", "lj@gmail.com","123", "9/6",
				p1Dom);
		Paciente p2 = new Paciente(1,"fernandez","beto", "fb@gmail.com","664", "9/6",
				p1Dom);


		ArrayList<Paciente> lista = new ArrayList<>();
		lista.add(p1);
		lista.add(p2);

		PacienteService pacienteService = new PacienteService();
		pacienteService.listarPacientes(lista);
	}


	@GetMapping
	public String holaPAciente(){
		return "Mostrar pacientes";
	}


}

