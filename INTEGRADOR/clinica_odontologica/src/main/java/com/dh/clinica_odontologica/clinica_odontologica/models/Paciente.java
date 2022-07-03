package com.dh.clinica_odontologica.clinica_odontologica.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pacientes")
@Getter @Setter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;
    private Domicilio domicilio;
    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();

}
