package com.dh.clinicaodontologica.IDAO;

import java.sql.SQLException;

public interface IDao<Paciente> {

    public Paciente guardarPaciente(Paciente paciente) throws SQLException;
    
}
