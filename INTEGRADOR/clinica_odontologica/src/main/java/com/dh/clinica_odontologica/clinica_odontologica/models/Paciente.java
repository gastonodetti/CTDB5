package com.dh.clinica_odontologica.clinica_odontologica.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pacientes")
@Getter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Setter
    private String nombre;
    @Setter
    private String apellido;
    @Setter
    private String dni;
    @Setter
    private LocalDateTime fechaIngreso = LocalDateTime.now();

    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="domicilio_id")
    private Domicilio domicilio;
    @Setter
    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();

    public Paciente() {}
    public Paciente(String nombre, String apellido, String dni, LocalDateTime fechaIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }
}
