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

    public Domicilio buscar(int id) throws SQLException {
        return domicilioDAO.buscar(id);
    }



}
