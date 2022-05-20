package C4S;

public class Main {
    public static void main(String[] args) {
        Articulo art1 = new Articulo("art1", 1001, 1201, "sano");

        AnalistaCalidad analista = new AnalistaCalidad();

        analista.comprobar(art1);
        
    }
}
