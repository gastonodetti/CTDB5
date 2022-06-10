package com.dh.paciente.Servicios;

import com.dh.paciente.Modelo.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {

    public PacienteService(){
        Paciente paciente1 = new Paciente(1,"juan", "gonzalez" , "jg@gmail.com", "423184","9/6");
        Paciente paciente2 = new Paciente(2,"clark", "kent" , "ck@gmail.com", "10","9/6");
        Paciente paciente3 = new Paciente(3,"bruce", "wayne" , "bw@gmail.com", "20","9/6");

        this.pacientes.addAll(List.of(paciente1, paciente2, paciente3));

    }
    private List<Paciente> pacientes = new ArrayList<>();
    public List<Paciente> listarPacientes(){ return pacientes;}
    public Paciente getPacientePorEmail(String email){

        for (Paciente paciente : pacientes){
            if (paciente.getEmail().equals(email)){
                return paciente;
            }
        }
        return null;
    }


}
