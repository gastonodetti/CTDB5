package Clinica.Daos;

import Clinica.DAO;
import Clinica.clases.Paciente;

public class PacienteDAOH2 implements DAO<Paciente> {

    @Override
    public Paciente guardar(Paciente paciente) {
        return paciente;
    }

    @Override
    public Paciente buscar(int id) {
        return null;
    }

    @Override
    public Paciente eliminar(int id) {
        return null;
    }

    @Override
    public Paciente modificar(int id) {
        return null;
    }


}
