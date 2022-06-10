package com.dh.paciente.Modelo;

public class Paciente {
    private int id;
    private String surname;
    private String name;
    private String email;
    private String dni;
    private String fechaIngreso;


    public Paciente(int id, String surname, String name, String email, String dni, String fechaIngreso) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
    }

    public String getApellido() {
        return surname;
    }

    public String getNombre() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
