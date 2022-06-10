package com.dh.clinicaodontologica.services;

import com.dh.clinicaodontologica.IDAO.IDao;
import com.dh.clinicaodontologica.models.Paciente;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {


    private List<Paciente> pacientes = new ArrayList<>();

    /*
    public PacienteService(List<Paciente> pacientes) {
        Paciente paciente1 = new Paciente(1,"Juan","Gonzalez","25423184", "juangonzalez1@yahoo.com", "14/03/2022");
        Paciente paciente2 = new Paciente(2,"Pepe","Gonzalez","25423184", "juangonzalez2@yahoo.com", "14/03/2022");
        Paciente paciente3 = new Paciente(3,"Mara","Gonzalez","25423184", "juangonzalez3@yahoo.com", "14/03/2022");
        Paciente paciente4 = new Paciente(4,"Dona","Gonzalez","25423184", "juangonzalez4@yahoo.com", "14/03/2022");
        this.pacientes.addAll(List.of(paciente1,paciente2,paciente3,paciente4));
    }*/

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public Paciente getPacienteByEmail(String email) {
        for (Paciente paciente: pacientes) {
            if (paciente.getEmail().equals(email)) {
                return paciente;
            }
        }
        return null;
    }

/*
    public PacienteService(IDao<Paciente> pacienteIDAO){
        this.pacienteIDAO = pacienteIDAO;
    }*/
    public Paciente guardarPaciente(Paciente paciente) throws SQLException {
        return null;
    }

}

