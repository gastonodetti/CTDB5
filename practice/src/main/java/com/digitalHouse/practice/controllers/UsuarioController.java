package com.digitalHouse.practice.controllers;

import com.digitalHouse.practice.models.Usuario;
import com.digitalHouse.practice.services.UsuarioService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import java.util.List;

@RestController
public class UsuarioController {

    private UsuarioService usuarioService = new UsuarioService();

    @GetMapping("/index")
    public List<Usuario> crearUsuario(){
        return usuarioService.crearUsuario();
    }

    @GetMapping("/nombre/{name}")
    public String hello(@PathVariable String name){
        return "Hello " + name + " welcome.";
    }

    @GetMapping(path = "/nombreCompleto/{name}/{lastname}/{age}")
    public String sayHello(@PathVariable String name,
                           @PathVariable String lastname,
                           @PathVariable String age) {
        return "Hola " + name + " " + lastname + " Edad: " + age;
    }


    @GetMapping(path = "/fechaNacimiento/{day}/{month}/{year}")
    public int edad(@PathVariable int day,
                           @PathVariable int month,
                           @PathVariable int year) throws ParseException {

        int edad = LocalDate.now().getYear() - year;

        return edad;
    }


}
