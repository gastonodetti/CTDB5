package com.dh.clinica_odontologica.clinica_odontologica.dto;

import com.dh.clinica_odontologica.clinica_odontologica.models.Odontologo;
import com.dh.clinica_odontologica.clinica_odontologica.models.Paciente;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Data
public class TurnoDTO {
    private Long id;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDateTime date;
}
