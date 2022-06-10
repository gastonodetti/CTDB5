package com.dh.clinicaodontologica.services;

import com.dh.clinicaodontologica.models.Odontologo;
import com.dh.clinicaodontologica.models.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OdontologoService {

    private List<Odontologo> odontologos = new ArrayList<>();

    public OdontologoService(List<Odontologo> odontologos) {
        Odontologo odontologo1 = new Odontologo(1,"peter","parker","555");
        Odontologo odontologo2 = new Odontologo(2,"peter2","parker2","5552");

        this.odontologos.addAll(List.of(odontologo1,odontologo2));
    }

    public List<Odontologo> getOdontologos() {
        return odontologos;
    }

    public Odontologo getOdontologoPorMatricula(String matricula) {
        for (Odontologo odontologo: odontologos) {
            if (odontologo.getMatricula().equals(matricula)) {
                return odontologo;
            }
        }
        return null;
    }


}

