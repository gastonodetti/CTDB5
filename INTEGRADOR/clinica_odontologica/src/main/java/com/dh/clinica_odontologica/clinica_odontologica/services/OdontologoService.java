package com.dh.clinica_odontologica.clinica_odontologica.services;

import com.dh.clinica_odontologica.clinica_odontologica.dto.OdontologoDTO;
import com.dh.clinica_odontologica.clinica_odontologica.models.Odontologo;
import com.dh.clinica_odontologica.clinica_odontologica.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService {
    @Autowired
    private IOdontologoRepository odontologoRepository;
    @Autowired
    ObjectMapper mapper;


    public Odontologo crearOdontologo(Odontologo odontologo) {
        odontologoRepository.save(odontologo);
        return odontologo;
    }

    public OdontologoDTO buscarOdontologo(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        return odontologoDTO;

    }

    public Odontologo modificarOdontologo(Odontologo odontologo) {
        odontologoRepository.save(odontologo);
        return odontologo;
    }

    public void eliminarOdontologo(Long id) {
            odontologoRepository.deleteById(id);
    }

    public Set<OdontologoDTO> listarOdontologos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for (Odontologo odontologo: odontologos){
            OdontologoDTO odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
            odontologosDTO.add(odontologoDTO);
        }
        return odontologosDTO;
    }
}
