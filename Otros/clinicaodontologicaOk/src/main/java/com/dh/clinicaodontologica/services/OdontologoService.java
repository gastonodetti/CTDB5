package com.dh.clinicaodontologica.services;

import com.dh.clinicaodontologica.dao.OdontologoDaoH2;
import com.dh.clinicaodontologica.models.Odontologo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OdontologoService {

    private OdontologoDaoH2 odontologoDaoH2;

    public OdontologoService() {
        this.odontologoDaoH2 = new OdontologoDaoH2();
    }

    public List<Odontologo> getOdontologos() {
        return odontologoDaoH2.listar();
    }

    public Odontologo getOdontologoById(int id) {
        return odontologoDaoH2.buscar(id);
    }
}
