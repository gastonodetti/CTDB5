package C3S;

public class Empleado extends Vendedor{
    private int aniosAntiguedad;

    public Empleado(int aniosAntiguedad) {
        super();
        this.aniosAntiguedad = aniosAntiguedad;
    }

    public void conseguirAfiliado(){
        setPuntaje(getPuntaje() + 10);
    }

    @Override
    public void vender() {
        setPuntaje(getPuntaje() + 5);
    }

}
