package com.dh.clinica_odontologica.clinica_odontologica.dto;

import lombok.Getter;
import lombok.Setter;
import com.dh.clinica_odontologica.clinica_odontologica.models.Odontologo;
import com.dh.clinica_odontologica.clinica_odontologica.models.Paciente;

import java.util.Date;

@Getter
@Setter
public class TurnoDTO {
    private Long id;
    private Paciente paciente;
    private Odontologo odontologo;
    private Date date;
}
