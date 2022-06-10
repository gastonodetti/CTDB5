package com.dh.empresa;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {
    private ArrayList<Empleado> empleados;
    private String razonSocial;
    private String cuit;

    public Empresa(String razonSocial, String cuit) {
        this.empleados = new ArrayList<>();
        this.razonSocial = razonSocial;
        this.cuit = cuit;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
}
