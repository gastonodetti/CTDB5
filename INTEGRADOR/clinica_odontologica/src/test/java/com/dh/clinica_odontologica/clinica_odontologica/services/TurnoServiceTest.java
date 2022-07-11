package com.dh.clinica_odontologica.clinica_odontologica.services;

import com.dh.clinica_odontologica.clinica_odontologica.dto.PacienteDTO;
import com.dh.clinica_odontologica.clinica_odontologica.dto.TurnoDTO;
import com.dh.clinica_odontologica.clinica_odontologica.models.Odontologo;
import com.dh.clinica_odontologica.clinica_odontologica.models.Paciente;
import com.dh.clinica_odontologica.clinica_odontologica.models.Turno;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceTest {
    @Autowired
    TurnoService turnoService;
    private Turno turno;
    private Odontologo odontologo;
    private Paciente paciente;

    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    public void setup(){
        //preparo paciente
        paciente = new Paciente();
        paciente.setApellido("paciente");
        paciente.setNombre("paciente");
        paciente.setDni("1");

        //preparo odontologo
        odontologo = new Odontologo();
        odontologo.setMatricula("1");
        odontologo.setApellido("odontologo");
        odontologo.setNombre("odontologo");

        //preparo turno
        turno = new Turno();
        turno.setOdontologo(odontologo);
        turno.setPaciente(paciente);
        turno.setDate(LocalDateTime.now());
    }
/*
    @Test
    void crearTurno() {
        Turno t = turnoService.crearTurno(turno);
        assertTrue(turnoService.buscarTurno(t.getId()) != null);
    }

    @Test
    void modificarTurno() {
        Turno original = turnoService.crearTurno(turno);
        Turno modificado = turnoService.crearTurno(turno);
        Odontologo nuevo = new Odontologo();
        nuevo.setNombre("distinto");
        modificado.setOdontologo(nuevo);
        turnoService.modificarTurno(modificado);

        TurnoDTO originalBuscado = turnoService.buscarTurno(original.getId());
        TurnoDTO modificadoBuscado = turnoService.buscarTurno(modificado.getId());

        assertNotEquals(originalBuscado,modificadoBuscado);
    }*/

    @Test
    void eliminarTurno() {
    }

    @Test
    void listarTurnos() {
        assertNotEquals(0, turnoService.listarTurnos().size());
    }
}