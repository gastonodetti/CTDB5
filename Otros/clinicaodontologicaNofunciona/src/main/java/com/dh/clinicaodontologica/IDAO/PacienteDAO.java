package com.dh.clinicaodontologica.IDAO;
import com.dh.clinicaodontologica.models.Paciente;
import java.sql.*;
import java.util.List;

public class PacienteDAO implements IDao<Paciente, String>{




    private Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        // return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        return DriverManager.getConnection("jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'src/create.sql'", "sa", "");
    }

    @Override
    public List<Paciente> listar() {
        return null;
    }

    @Override
    public Paciente buscar(String key) {
        return null;
    }
}
