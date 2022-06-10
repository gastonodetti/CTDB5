package com.dh.clinicaodontologica.dao;

import com.dh.clinicaodontologica.models.Odontologo;
import com.dh.clinicaodontologica.models.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente, String>{

    private Connection connection;

    public PacienteDaoH2() {
        limpiar();
        Odontologo odontologo1 = new Odontologo(1,"Nombre1", "Apellido1", "Matricula1");
        Odontologo odontologo2 = new Odontologo(2,"Nombre2", "Apellido2", "Matricula2");
        Odontologo odontologo3 = new Odontologo(3,"Nombre3", "Apellido3", "Matricula3");
        Odontologo odontologo4 = new Odontologo(4,"Nombre4", "Apellido4", "Matricula4");
        Paciente paciente1 = new Paciente(1,"Nombre1","Apellido1","25423184", "juangonzalez1@yahoo.com", "14/03/2022", odontologo1);
        Paciente paciente2 = new Paciente(2,"Nombre2","Apellido2","25423184", "juangonzalez2@yahoo.com", "14/03/2022", odontologo2);
        Paciente paciente3 = new Paciente(3,"Nombre3","Apellido3","25423184", "juangonzalez3@yahoo.com", "14/03/2022", odontologo3);
        Paciente paciente4 = new Paciente(4,"Nombre4","Apellido4","25423184", "juangonzalez4@yahoo.com", "14/03/2022", odontologo4);
        for (Paciente paciente: Arrays.asList(paciente1,paciente2,paciente3,paciente4)) {
            insertar(paciente);
        }
    }

    @Override
    public List<Paciente> listar() {
        connection = null;
        List<Paciente> pacientes = new ArrayList<>();
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PACIENTE");
            while (resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                String nombre = resultSet.getString("NOMBRE");
                String apellido = resultSet.getString("APELLIDO");
                String dni = resultSet.getString("DNI");
                String email = resultSet.getString("EMAIL");
                String fechaIngreso = resultSet.getString("FECHA_INGRESO");
                Integer odontologoId = resultSet.getInt("ODONTOLOGO_ID");

                OdontologoDaoH2 odontologoDaoH2 = new OdontologoDaoH2();
                Odontologo odontologo = odontologoDaoH2.buscar(odontologoId);

                pacientes.add(new Paciente(id,nombre,apellido,dni,email,fechaIngreso,odontologo));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    @Override
    public Paciente buscar(String key) {
        connection = null;
        Paciente paciente = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PACIENTE WHERE EMAIL = ? LIMIT 1");
            preparedStatement.setString(1,key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                String nombre = resultSet.getString("NOMBRE");
                String apellido = resultSet.getString("APELLIDO");
                String dni = resultSet.getString("DNI");
                String email = resultSet.getString("EMAIL");
                String fechaIngreso = resultSet.getString("FECHA_INGRESO");
                Integer odontologoId = resultSet.getInt("ODONTOLOGO_ID");

                OdontologoDaoH2 odontologoDaoH2 = new OdontologoDaoH2();
                Odontologo odontologo = odontologoDaoH2.buscar(odontologoId);

                paciente = new Paciente(id,nombre,apellido,dni,email,fechaIngreso,odontologo);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public void limpiar() {
        connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("TRUNCATE TABLE PACIENTE");
            preparedStatement.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertar(Paciente paciente){
        connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PACIENTE (ID , NOMBRE , APELLIDO , DNI, EMAIL, FECHA_INGRESO, ODONTOLOGO_ID) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,paciente.getId());
            preparedStatement.setString(2, paciente.getNombre());
            preparedStatement.setString(3, paciente.getApellido());
            preparedStatement.setString(4, paciente.getDni());
            preparedStatement.setString(5, paciente.getEmail());
            preparedStatement.setString(6, paciente.getFechaIngreso());
            preparedStatement.setInt(7, paciente.getOdontologo().getId());
            preparedStatement.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        // return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        return DriverManager.getConnection("jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'src/create.sql'", "sa", "");
    }

}
