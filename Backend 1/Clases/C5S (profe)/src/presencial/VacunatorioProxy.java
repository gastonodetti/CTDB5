package presencial;

import java.time.LocalDate;

public class VacunatorioProxy implements Vacunatorio{
    private VacunatorioService vacunatorioReal;
    @Override
    public String vacunar(Persona persona) {
        //control de fecha
        LocalDate hoy=LocalDate.now();
        String mensaje="Vuelva cuando sea su turno. :D";
        if (hoy.isAfter(persona.getFechaAsignada())){
            //la persona tiene que pasar por el servicio
            vacunatorioReal= new VacunatorioService();
            mensaje=vacunatorioReal.vacunar(persona);
        }
        return mensaje;
    }
}
