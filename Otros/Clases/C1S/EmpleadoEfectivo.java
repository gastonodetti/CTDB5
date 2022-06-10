package C1S;

public class EmpleadoEfectivo extends Empleado{

    private int sueldoBasico;

    public EmpleadoEfectivo(String nombre, String apellido, String numeroDeCuenta, int sueldoBasico) {
        super(nombre, apellido, numeroDeCuenta);
        this.sueldoBasico = sueldoBasico;
    }

    @Override
    public void calculo(){
        System.out.println("Calculando sueldo de " + getNombre() + ", empleado efectivo");

    }
    @Override
    public void impresion(){
        System.out.println("Imprimiendo sueldo de " + getNombre() + ", empleado efectivo");

    }

}
