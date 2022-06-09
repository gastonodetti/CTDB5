package com.dh.paciente.Servicios;

import com.dh.paciente.Dominio.Paciente;

import java.util.List;

public class PacienteService {
    public List<Paciente> listarPacientes(List<Paciente> paciente){



        for (int i = 0 ; i < paciente.size() ; i ++){
            System.out.println("Nombre: " + paciente + " | " + "Apellido: " +  paciente);
        }
        return paciente;
    }
}
