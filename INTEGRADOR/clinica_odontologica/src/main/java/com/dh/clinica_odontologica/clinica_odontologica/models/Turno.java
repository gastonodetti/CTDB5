package com.dh.clinica_odontologica.clinica_odontologica.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "turnos")
@Getter
@Setter
public class Turno {

    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

    private LocalDateTime date = LocalDateTime.now();

    public Turno(){}
    public Turno(Paciente paciente, Odontologo odontologo, LocalDateTime date) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.date = date;
    }
}
