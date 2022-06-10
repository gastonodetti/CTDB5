package C13S_Odontologo;

import static org.junit.Assert.assertEquals;

public class Test extends Odontologo{
    public static void main(String[] args) throws Exception {

        String Resultado = "ok";

        assertEquals(Odontologo.listarUsuarios(Odontologo.obtenerConexion()),Resultado);
    }
}
