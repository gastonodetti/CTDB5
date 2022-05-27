package presencial;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VacunatorioTest {
    @Test
    public void vacunarPersonaOkTest(){
        //dado
        Persona persona= new Persona("Rodolfo","Baspineiro","1234", LocalDate.of(2022,5,18),"Astrazeneca");
        Vacunatorio vacunatorio= new VacunatorioProxy();
        String respEsperada="Se ha registrado el DNI 1234 como persona vacunada con Astrazeneca";
        //cuando
        String respActual=vacunatorio.vacunar(persona);
        //entonces
        assertEquals(respEsperada,respActual);
    }
    @Test
    public void vacunarPersonaACasaTest(){
        //dado
        Persona persona= new Persona("Rodolfo","Baspineiro","1234", LocalDate.of(2022,6,18),"Astrazeneca");
        Vacunatorio vacunatorio= new VacunatorioProxy();
        String respEsperada="Vuelva cuando sea su turno. :D";
        //cuando
        String respActual=vacunatorio.vacunar(persona);
        //entonces
        assertEquals(respEsperada,respActual);
    }
}