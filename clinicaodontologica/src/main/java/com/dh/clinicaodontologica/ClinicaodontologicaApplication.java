package com.dh.clinicaodontologica;

import com.dh.clinicaodontologica.IDAO.PacienteDAO;
import com.dh.clinicaodontologica.models.Paciente;
import com.dh.clinicaodontologica.services.PacienteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class ClinicaodontologicaApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(ClinicaodontologicaApplication.class, args);

		/*
		Paciente paciente = new Paciente(1,"gaston", "odetti", "3950","g@.com","9/6");
		PacienteDAO pacienteDAO = new PacienteDAO();
		PacienteService pacienteService = new PacienteService(pacienteDAO);

		pacienteService.guardarPaciente(paciente);
*/

	}

}
