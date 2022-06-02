package Clinica;

import Clinica.Daos.DomicilioDAOH2;
import Clinica.Services.DomicilioService;
import Clinica.clases.Domicilio;

public class Test {
    public static void main(String[] args) {

        Domicilio domicilio1 = new Domicilio(1,"a", "a" ,"a", "a");

        DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();

        try {
            DomicilioService domicilioService = new DomicilioService(domicilioDAOH2);
            Domicilio intertar =  domicilioService.guardar(domicilio1);
            Domicilio buscar = domicilioService.buscar(domicilio1.getDomicilioId());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
