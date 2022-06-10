package C1S;

public abstract class Empleado {
    private String nombre;
    private String apellido;
    private String numeroDeCuenta;

    public Empleado(String nombre, String apellido, String numeroDeCuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getNombre(){
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

    public void liquidarSueldo(){
        calculo();
        impresion();
        deposito();
    }

    public abstract void calculo();
    public abstract void impresion();
    public void deposito(){
        System.out.println("Depositando sueldo");
    }




}
