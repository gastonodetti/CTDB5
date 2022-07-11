package com.dh.clinica_odontologica.clinica_odontologica.services;

import com.dh.clinica_odontologica.clinica_odontologica.dto.OdontologoDTO;
import com.dh.clinica_odontologica.clinica_odontologica.models.Odontologo;
import com.dh.clinica_odontologica.clinica_odontologica.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    OdontologoService odontologoService;
    private Odontologo odontologo;

    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    public void setup(){
        odontologo = new Odontologo();
        odontologo.setApellido("1");
        odontologo.setNombre("1");
        odontologo.setMatricula("1");
    }

    @Test
    void crearOdontologo() {
        Odontologo o = odontologoService.crearOdontologo(odontologo);
        assertTrue(odontologoService.buscarOdontologo(o.getId()) != null);
    }

    @Test
    void modificarOdontologo() {
        Odontologo original = odontologoService.crearOdontologo(odontologo);
        Odontologo modificado = odontologoService.crearOdontologo(odontologo);
        modificado.setNombre("Modificado");
        odontologoService.modificarOdontologo(modificado);

        OdontologoDTO originalBuscado = odontologoService.buscarOdontologo(original.getId());
        OdontologoDTO modificadoBuscado = odontologoService.buscarOdontologo(modificado.getId());

        assertNotEquals(originalBuscado,modificadoBuscado);
    }

    @Test
    void eliminarOdontologo() {
        Odontologo eliminado = odontologoService.crearOdontologo(odontologo);
        odontologoService.eliminarOdontologo(eliminado.getId());

        assertFalse(odontologoService.buscarOdontologo(eliminado.getId()) != null);
    }

    @Test
    void listarOdontologos() {
        Odontologo listado = odontologoService.crearOdontologo(odontologo);
        assertNotEquals(0, odontologoService.listarOdontologos().size());

    }
}