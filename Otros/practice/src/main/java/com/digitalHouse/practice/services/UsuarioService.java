package com.digitalHouse.practice.services;

import com.digitalHouse.practice.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    public List<Usuario> crearUsuario(){
        List<Usuario> lista = new ArrayList<>();
        Usuario usuario = new Usuario("Gaston", 27);
        Usuario usuario1 = new Usuario("Jaz", 24);

        lista.add(usuario);
        lista.add(usuario1);

        return lista;
    }
}
