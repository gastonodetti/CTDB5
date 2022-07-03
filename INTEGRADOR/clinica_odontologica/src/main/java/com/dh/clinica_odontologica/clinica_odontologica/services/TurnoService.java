package com.dh.clinica_odontologica.clinica_odontologica.services;

import com.dh.clinica_odontologica.clinica_odontologica.dto.OdontologoDTO;
import com.dh.clinica_odontologica.clinica_odontologica.dto.TurnoDTO;
import com.dh.clinica_odontologica.clinica_odontologica.models.Odontologo;
import com.dh.clinica_odontologica.clinica_odontologica.models.Turno;
import com.dh.clinica_odontologica.clinica_odontologica.repository.IOdontologoRepository;
import com.dh.clinica_odontologica.clinica_odontologica.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService{
    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarTurno(TurnoDTO turnoDTO){
        Turno nuevoTurno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(nuevoTurno);
    }

    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
    guardarTurno(turnoDTO);
    }

    @Override
    public TurnoDTO buscarTurno(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent()){
            turnoDTO = mapper.convertValue(turno,TurnoDTO.class);
        }
        return turnoDTO;    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
    }

    @Override
    public void eliminarTurno(Long id) {
turnoRepository.deleteById(id);
    }

    @Override
    public Set<TurnoDTO> listarTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for (Turno turno: turnos){
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnosDTO;
    }
}
