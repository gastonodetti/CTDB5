package com.dh.paciente.Dominio;

public class Paciente {
    private int id;
    private String apellido;
    private String nombre;
    private String email;
    private String dni;
    private String fechaIngreso;

    private Domicilio domicilio;

    public Paciente(int id, String apellido, String nombre, String email, String dni, String fechaIngreso, Domicilio domicilio) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }
}
