package com.dh.clinica_odontologica.clinica_odontologica.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "odontologos")
@Getter @Setter
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String apellido;
    private String nombre;
    private String matricula;
    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();

}
