package com.dh.clinica_odontologica.clinica_odontologica.services;

import com.dh.clinica_odontologica.clinica_odontologica.dto.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {

    void crearOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO buscarOdontologo(Long id);
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Long id);
    Set<OdontologoDTO> listarOdontologos();

}
