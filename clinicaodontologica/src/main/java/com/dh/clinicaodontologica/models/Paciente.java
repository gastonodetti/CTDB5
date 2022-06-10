package com.dh.clinicaodontologica.models;

public class Paciente {

    private int id;
    private String name;
    private String surname;
    private String dni;
    private String email;
    private String fechaIngreso;

    // Constructor
    public Paciente(int id, String name, String surname, String dni, String email, String fechaIngreso) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.email = email;
        this.fechaIngreso = fechaIngreso;
    }

    // Getters & setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return name;
    }

    public String getApellido() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public void setPellido(String pellido) {
        this.surname = pellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}