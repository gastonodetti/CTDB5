package com.dh.clinica_odontologica.clinica_odontologica.services;

import com.dh.clinica_odontologica.clinica_odontologica.dto.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    void crearTurno(TurnoDTO turnoDTO);
    TurnoDTO buscarTurno(Long id);
    void modificarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Long id);
    Set<TurnoDTO> listarTurnos();
}
