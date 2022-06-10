package com.dh.clinicaodontologica.services;

import com.dh.clinicaodontologica.dao.PacienteDaoH2;
import com.dh.clinicaodontologica.models.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {

    private PacienteDaoH2 pacienteDaoH2;

    public PacienteService() {
        this.pacienteDaoH2 = new PacienteDaoH2();
    }

    public List<Paciente> getPacientes() {
        return pacienteDaoH2.listar();
    }

    public Paciente getPacienteByEmail(String email) {
        return pacienteDaoH2.buscar(email);
    }


}
