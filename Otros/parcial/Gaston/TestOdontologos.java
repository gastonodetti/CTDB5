import DAO_Entity.OdontologoDAO;
import Entity.Odontologo;
import Service.OdontologoService;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class TestOdontologos {

    @Test
    public void registrarOdontologoTest() throws SQLException {
        //dado
        Odontologo odontologo = new Odontologo("100", "Bruce", "Wayne");
        Odontologo odontologo1 = new Odontologo("200", "Clark", "Kent");
        OdontologoDAO odontologoDAO = new OdontologoDAO();
        OdontologoService odontologoService = new OdontologoService(odontologoDAO);
        Odontologo resultadoEsperado = odontologo;
        odontologoService.registrarOdontologo(odontologo1);

        //entonces
        assertEquals(resultadoEsperado, odontologoService.registrarOdontologo(odontologo));
    }

    @Test
    public void listarOdontologosTest() throws SQLException {

        //dado
        OdontologoDAO odontologoDAO = new OdontologoDAO();
        OdontologoService odontologoService = new OdontologoService(odontologoDAO);

        assertEquals("Listado exitoso.", odontologoService.listarOdontologos());

    }

}
