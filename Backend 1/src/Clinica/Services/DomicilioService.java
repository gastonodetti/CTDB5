package Clinica.Services;

import Clinica.DAO;
import Clinica.clases.Domicilio;

import java.sql.SQLException;

public class DomicilioService {

    private static DAO<Domicilio> domicilioDAO;

    public DomicilioService(DAO<Domicilio> domicilioDAO){
        this.domicilioDAO = domicilioDAO;
    }

    public Domicilio guardar(Domicilio domicilio) throws SQLException {
        return domicilioDAO.guardar(domicilio);
    }

    public Domicilio buscar(Domicilio domicilio) throws SQLException {
        return domicilioDAO.buscar(domicilio);
    }
    public Domicilio eliminar(Domicilio domicilio) throws SQLException {
        return domicilioDAO.eliminar(domicilio);
    }
    public Domicilio modificar(Domicilio domicilio, String nuevoValor ) throws  SQLException{
        return domicilioDAO.modificar(domicilio, nuevoValor);
    }



}
