package com.dh.clinica_odontologica.clinica_odontologica.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
public class DomicilioDTO {

    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}
