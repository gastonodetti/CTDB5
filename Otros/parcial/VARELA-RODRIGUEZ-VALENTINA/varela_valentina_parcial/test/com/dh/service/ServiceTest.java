package com.dh.service;

import com.dh.model.Odontologo;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ServiceTest {

    private Service service;

    @BeforeEach
    public void reset() throws Exception {
        service = new Service();
    }

    @BeforeAll
    public static void init() {
        PropertyConfigurator.configure("log4j.properties");
    }

    @Test
    public void test01DarDeAltaConTodosLosDatos() {
        Odontologo odontologo = new Odontologo("John", "Doe", "666666");
        String respuestaEsperada = "El odontologo " + odontologo + " fue dado de alta con éxito";

        String respuestaObtenida = service.darDeAltaOdontologo("John", "Doe", "666666");

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void test02NoSePuedeDarDeAltaSiAlgunCampoEsNull() {
        String respuestaEsperada = "No se pudo dar de alta el odontologo";

        String respuestaObtenida = service.darDeAltaOdontologo(null, "Doe", "666666");

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void test03ConsultarPorIDExistente() {
        Odontologo odontologoExistente = new Odontologo("1", "Pepe", "Pepardo", "123456");
        String respuestaEsperada = "El odontologo con ID: 1 es " + odontologoExistente;

        String respuestaObtenida = service.buscarOdontologoPorId(1);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void test04ConsultarPorIDInexistente() {
        String respuestaEsperada = "Odontologo con ID: 1234 no encontrado";

        String respuestaObtenida = service.buscarOdontologoPorId(1234);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void test05NoSePuedeConsultarConsultarPorIDNull() {
        String respuestaEsperada = "Odontologo con ID: null no encontrado";

        String respuestaObtenida = service.buscarOdontologoPorId(null);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void test06ActualizarDatosExistente() {
        Odontologo odontologoActualizado = new Odontologo("2", "Pipo", "Piposo", "112233");
        String respuestaEsperada = "Los nuevos datos son:\n" + odontologoActualizado;

        String respuestaObtenida = service.actualizarOdontologo(2, "Pipo", "Piposo", "112233");

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void test07NoSePuedeActualizarDatosDeUnPacienteInexistenteEnBD() {
        String respuestaEsperada = "Odontologo con ID: 1111 no encontrado";

        String respuestaObtenida = service.buscarOdontologoPorId(1111);

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    public void test08ConsultarTodos() {
        String respuestaNoEsperada = "No hay odontologos";

        String respuestaObtenida = service.consultarTodos();

        assertNotEquals(respuestaNoEsperada, respuestaObtenida);
    }
}
