package com.dh.clinica_odontologica.clinica_odontologica.services;

import com.dh.clinica_odontologica.clinica_odontologica.dto.DomicilioDTO;
import com.dh.clinica_odontologica.clinica_odontologica.models.Domicilio;
import com.dh.clinica_odontologica.clinica_odontologica.repository.IDomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DomicilioService {

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;


    public Domicilio crearDomicilio(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
        return domicilio;
    }

    public DomicilioDTO buscarDomicilio(Long id) {
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;
        if(domicilio.isPresent()){
            domicilioDTO = mapper.convertValue(domicilio,DomicilioDTO.class);
        }
        return domicilioDTO;
    }

    public Domicilio modificarDomicilio(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
        return domicilio;
    }

    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }
}
