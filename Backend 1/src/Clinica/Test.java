package Clinica;

import Clinica.Daos.DomicilioDAOH2;
import Clinica.Services.DomicilioService;
import Clinica.clases.Domicilio;

public class Test {
    public static void main(String[] args) {

        Domicilio domicilio1 = new Domicilio(1,"a", "a" ,"a", "a");
        Domicilio domicilio2 = new Domicilio(2,"b", "b" ,"b", "b");

        DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();

        try {
            DomicilioService domicilioService = new DomicilioService(domicilioDAOH2);

            //domicilioService.guardar(domicilio1);
            //domicilioService.guardar(domicilio2);
            //domicilioService.buscar(domicilio1);
            //domicilioService.eliminar(domicilio2);
            //domicilioService.buscar(domicilio2);
            //domicilioService.modificar(domicilio1,"calle definitiva");
            //domicilioService.buscar(domicilio1);
            //domicilioService.buscar(domicilio2);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
