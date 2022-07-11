package com.dh.clinica_odontologica.clinica_odontologica.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
public class PacienteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
}
