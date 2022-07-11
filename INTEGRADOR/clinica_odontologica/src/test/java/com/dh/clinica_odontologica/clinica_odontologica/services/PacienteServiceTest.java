package com.dh.clinica_odontologica.clinica_odontologica.services;

import com.dh.clinica_odontologica.clinica_odontologica.dto.OdontologoDTO;
import com.dh.clinica_odontologica.clinica_odontologica.dto.PacienteDTO;
import com.dh.clinica_odontologica.clinica_odontologica.models.Odontologo;
import com.dh.clinica_odontologica.clinica_odontologica.models.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {
    @Autowired
    PacienteService pacienteService;
    private Paciente paciente;

    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    public void setup(){
        paciente = new Paciente();
        paciente.setApellido("1");
        paciente.setNombre("1");
        paciente.setDni("1");
    }
    @Test
    void crearPaciente() {
        Paciente p = pacienteService.crearPaciente(paciente);
        assertTrue(pacienteService.buscarPaciente(p.getId()) != null);
    }

    @Test
    void modificarPaciente() {
        Paciente original = pacienteService.crearPaciente(paciente);
        Paciente modificado = pacienteService.crearPaciente(paciente);
        modificado.setNombre("Modificado");
        pacienteService.modificarPaciente(modificado);

        PacienteDTO originalBuscado = pacienteService.buscarPaciente(original.getId());
        PacienteDTO modificadoBuscado = pacienteService.buscarPaciente(modificado.getId());

        assertNotEquals(originalBuscado,modificadoBuscado);

    }

    @Test
    void eliminarPaciente() {
        Paciente eliminado = pacienteService.crearPaciente(paciente);
        pacienteService.eliminarPaciente(eliminado.getId());

        assertFalse(pacienteService.buscarPaciente(eliminado.getId()) != null);
    }

    @Test
    void listarPacientes() {
        Paciente listado = pacienteService.crearPaciente(paciente);
        assertNotEquals(0, pacienteService.listarPacientes().size());
    }
}