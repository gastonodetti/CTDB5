package com.dh.clinicaodontologica.dao;

import com.dh.clinicaodontologica.models.Odontologo;
import com.dh.clinicaodontologica.models.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo, Integer>{

    private Connection connection;

    public OdontologoDaoH2() {
        limpiar();
        Odontologo odontologo1 = new Odontologo(1,"Nombre1", "Apellido1", "Matricula1");
        Odontologo odontologo2 = new Odontologo(2,"Nombre2", "Apellido2", "Matricula2");
        Odontologo odontologo3 = new Odontologo(3,"Nombre3", "Apellido3", "Matricula3");
        Odontologo odontologo4 = new Odontologo(4,"Nombre4", "Apellido4", "Matricula4");
        for (Odontologo odontologo: Arrays.asList(odontologo1,odontologo2,odontologo3,odontologo4)) {
            insertar(odontologo);
        }
    }

    @Override
    public List<Odontologo> listar() {
        connection = null;
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ODONTOLOGO");
            while (resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                String nombre = resultSet.getString("NOMBRE");
                String apellido = resultSet.getString("APELLIDO");
                String matricula = resultSet.getString("MATRICULA");
                odontologos.add(new Odontologo(id,nombre,apellido,matricula));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return odontologos;
    }

    @Override
    public Odontologo buscar(Integer key) {
        connection = null;
        Odontologo odontologo = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGO WHERE ID = ?");
            preparedStatement.setInt(1,key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                String nombre = resultSet.getString("NOMBRE");
                String apellido = resultSet.getString("APELLIDO");
                String matricula = resultSet.getString("MATRICULA");
                odontologo = new Odontologo(id,nombre,apellido,matricula);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public void limpiar() {
        connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("TRUNCATE TABLE ODONTOLOGO");
            preparedStatement.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertar(Odontologo odontologo){
        connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGO (ID , NOMBRE , APELLIDO , MATRICULA) VALUES (?,?,?,?)");
            preparedStatement.setInt(1,odontologo.getId());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.setString(4, odontologo.getMatricula());
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
