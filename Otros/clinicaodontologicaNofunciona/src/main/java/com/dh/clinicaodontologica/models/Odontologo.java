package com.dh.clinicaodontologica.models;

public class Odontologo {

    private int id;
    private String name;
    private String surname;
    private String matricula;

    public Odontologo(int id, String name, String surname, String matricula) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

