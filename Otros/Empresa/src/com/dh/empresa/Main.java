package com.dh.empresa;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Empresa empresa = new Empresa("Digital House", "123456-89");

        Empleado empleado1 = new Empleado("Pablo", "Roca", "AS123", 10000.0);
        Empleado empleado2 = new Empleado("Tomas", "Correa", "AD234", 10500.0);
        Empleado empleado3 = new Empleado("Eugenia", "Guatelli", "PO123", 15000.0);
        Empleado empleado4 = new Empleado("Mariela", "Vallejos", "TU909", 10040.0);

        empresa.agregarEmpleado(empleado1);
        empresa.agregarEmpleado(empleado2);
        empresa.agregarEmpleado(empleado3);
        empresa.agregarEmpleado(empleado4);

        try {
            FileOutputStream fos = new FileOutputStream("Empresa.txt");
            ObjectOutputStream objectEmpresa = new ObjectOutputStream(fos);

            objectEmpresa.writeObject(empresa);

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Empresa empresaRecuperada;
        try {
            FileInputStream fis = new FileInputStream("Empresa.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fis);

            empresaRecuperada = (Empresa) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Empleado empleado : empresaRecuperada.getEmpleados()) {
            System.out.println(empleado);
        }

    }
}
