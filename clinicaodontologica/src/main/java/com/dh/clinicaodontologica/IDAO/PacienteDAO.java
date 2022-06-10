package com.dh.clinicaodontologica.IDAO;
import com.dh.clinicaodontologica.models.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacienteDAO implements IDao<Paciente, String>{

    private Connection connection;

    public PacienteDAO(){
        Paciente paciente1 = new Paciente(1,"peter", "parker","4050","pp@gmail.com", "10/6");
        Paciente paciente2 = new Paciente(2,"peter1", "parker1","40501","pp1@gmail.com", "10/6");
        Paciente paciente3 = new Paciente(3,"peter2", "parker2","40502","pp2@gmail.com", "10/6");

        for (Paciente paciente: Arrays.asList(paciente1,paciente2,paciente3)) {
            insertar(paciente);
        }
    }
    @Override
    public List<Paciente> listar() {

        connection = null;

        List<Paciente> pacientes = new ArrayList<>();

        try {
            connection = 
        }
    }

    @Override
    public Paciente buscar(String key) {
        return null;
    }

    @Override
    public void limpiar() {

    }
}
