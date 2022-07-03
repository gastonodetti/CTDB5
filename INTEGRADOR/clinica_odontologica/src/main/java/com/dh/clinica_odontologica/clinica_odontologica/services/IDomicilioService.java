package com.dh.clinica_odontologica.clinica_odontologica.services;

import com.dh.clinica_odontologica.clinica_odontologica.dto.DomicilioDTO;
import com.dh.clinica_odontologica.clinica_odontologica.dto.PacienteDTO;

import java.util.Set;

public interface IDomicilioService {
    void crearDomicilio(DomicilioDTO domicilioDTO);
    DomicilioDTO buscarDomicilio(Long id);
    void modificarDomicilio(DomicilioDTO domicilioDTO);
    void eliminarDomicilio(Long id);
}
