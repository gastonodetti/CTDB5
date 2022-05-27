package presencial;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellido;
    private String DNI;
    private LocalDate fechaAsignada;
    private String nombreVacuna;

    public Persona(String nombre, String apellido, String DNI, LocalDate fechaAsignada, String nombreVacuna) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.fechaAsignada = fechaAsignada;
        this.nombreVacuna = nombreVacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public LocalDate getFechaAsignada() {
        return fechaAsignada;
    }

    public void setFechaAsignada(LocalDate fechaAsignada) {
        this.fechaAsignada = fechaAsignada;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }
}
