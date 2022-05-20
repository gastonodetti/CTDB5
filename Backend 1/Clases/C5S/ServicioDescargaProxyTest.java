package C5S;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioDescargaProxyTest {

    @Test
    void descargarOk() {

        Usuario usuarioPremium = new Usuario(10, "Premium");

        ServicioDescargaProxy servicioProxy = new ServicioDescargaProxy();
        String respuestaEsperada = "Usuario aceptado!";

        assertEquals(servicioProxy.descargar(usuarioPremium),respuestaEsperada);
    }
    @Test
    void descargarMal() {

        Usuario usuarioBase = new Usuario(10, "Base");

        ServicioDescargaProxy servicioProxy = new ServicioDescargaProxy();
        String respuestaEsperada = "flaco flashaste confianza, no estas pagando nada :@";

        assertEquals(servicioProxy.descargar(usuarioBase),respuestaEsperada);
    }
}
