package com.dh.clinica_odontologica.clinica_odontologica.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
public class OdontologoDTO {

        private Long id;
        private String apellido;
        private String nombre;
        private String matricula;

        public OdontologoDTO(Long id, String apellido, String nombre, String matricula) {
                this.id = id;
                this.apellido = apellido;
                this.nombre = nombre;
                this.matricula = matricula;
        }
}
