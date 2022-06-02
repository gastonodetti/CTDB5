package Clinica.Daos;

import Clinica.DAO;
import Clinica.clases.Paciente;

public class PacienteDAOH2 implements DAO<Paciente> {

    @Override
    public Paciente guardar(Paciente paciente) {
        return paciente;
    }

    @Override
    public Paciente buscar(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente eliminar(Paciente paciente) { return null;}

    @Override
    public Paciente modificar(Paciente paciente, String nuevoValor) {
        return null;
    }


}
