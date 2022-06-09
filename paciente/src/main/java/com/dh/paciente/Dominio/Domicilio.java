package com.dh.paciente.Dominio;

public class Domicilio {
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    public Domicilio(String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
