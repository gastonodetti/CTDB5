package C1S;

public class EmpleadoContratado extends Empleado{

    private int pagoPorHora;
    private int horasTrabajadas;
    public EmpleadoContratado(String nombre, String apellido, String numeroDeCuenta, int pagoPorHora, int horasTrabajadas) {
        super(nombre, apellido, numeroDeCuenta);
        this.pagoPorHora = pagoPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public void calculo(){
        System.out.println("Calculando sueldo de " + getNombre() + ", empleado monotributista");
        int pagoFinal = this.pagoPorHora * this.horasTrabajadas;
        if (this.horasTrabajadas < 1) {
            System.err.println("La cantidad de horas no puede ser cero, vago!");
        }
        System.out.println("Tu pago por  " + this.horasTrabajadas + " horas trabajadas, es de " + pagoFinal);
    }

    @Override
    public void impresion(){
        System.out.println("Imprimiendo sueldo de " + getNombre() + ", empleado monotributista");
    }
}
