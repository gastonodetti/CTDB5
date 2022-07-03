package com.dh.clinica_odontologica.clinica_odontologica.services;

import com.dh.clinica_odontologica.clinica_odontologica.dto.PacienteDTO;

import java.util.Set;

public interface IPacienteService {
    void crearPaciente(PacienteDTO pacienteDTO);
    PacienteDTO buscarPaciente(Long id);
    void modificarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Long id);
    Set<PacienteDTO> listarPacientes();
}
