package com.dh.clinica_odontologica.clinica_odontologica.services;


import com.dh.clinica_odontologica.clinica_odontologica.dto.OdontologoDTO;
import com.dh.clinica_odontologica.clinica_odontologica.dto.PacienteDTO;
import com.dh.clinica_odontologica.clinica_odontologica.dto.TurnoDTO;
import com.dh.clinica_odontologica.clinica_odontologica.models.Odontologo;
import com.dh.clinica_odontologica.clinica_odontologica.models.Paciente;
import com.dh.clinica_odontologica.clinica_odontologica.models.Turno;
import com.dh.clinica_odontologica.clinica_odontologica.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService {
    @Autowired
    private ITurnoRepository turnoRepository;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    @Autowired
    ObjectMapper mapper;


    public Turno crearTurno(TurnoDTO nuevoTurnoDTO) {
        PacienteDTO pacienteDTO = pacienteService.buscarPaciente(nuevoTurnoDTO.getPacienteId());
        Paciente paciente = mapper.convertValue(pacienteDTO,Paciente.class);
        OdontologoDTO odontologoDTO = odontologoService.buscarOdontologo(nuevoTurnoDTO.getOdontologoId());
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);

        Turno turno = new Turno(paciente, odontologo, nuevoTurnoDTO.getDate());
        turnoRepository.save(turno);
        return turno;
    }

    public TurnoDTO buscarTurno(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent()){
            turnoDTO = mapper.convertValue(turno,TurnoDTO.class);
            turnoDTO.setOdontologoId(turno.get().getOdontologo().getId());
            turnoDTO.setPacienteId(turno.get().getPaciente().getId());
        }
        return turnoDTO;    }

    public Turno modificarTurno(Turno turno) {
        turnoRepository.save(turno);
        return turno;
    }

    public void eliminarTurno(Long id) {
turnoRepository.deleteById(id);
    }

    public Set<TurnoDTO> listarTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for (Turno turno: turnos){
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnosDTO;
    }
}
