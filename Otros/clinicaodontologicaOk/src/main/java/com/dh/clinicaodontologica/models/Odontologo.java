package com.dh.clinicaodontologica.models;

public class Odontologo {

    private int id;
    private String nombre;
    private String apellido;
    private String matricula;

    public Odontologo(int id, String nombre, String apellido, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMatricula() {
        return matricula;
    }
}
