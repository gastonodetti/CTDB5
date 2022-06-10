package com.dh.clinicaodontologica.dao;

import java.util.List;

public interface IDao<T,V> {

    List<T> listar();
    T buscar(V key);

    void limpiar();

}
