package com.dh.clinica_odontologica.clinica_odontologica.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
}
