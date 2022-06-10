package C3S;

public class Main {
    public static void main(String[] args) {

        Vendedor thiago2 = new Empleado(2);

        thiago2.vender();
        System.out.println(thiago2.getPuntaje());
        System.out.println(thiago2.mostrarCategoria());

    }
}
