package com.dh.clinicaodontologica.models;

public class Paciente {

    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String fechaIngreso;
    private Odontologo odontologo;

    // Constructor
    public Paciente(int id, String nombre, String apellido, String dni, String email, String fechaIngreso, Odontologo odontologo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.fechaIngreso = fechaIngreso;
        this.odontologo = odontologo;
    }

    // Getters & setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPellido(String pellido) {
        this.apellido = pellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }
}
