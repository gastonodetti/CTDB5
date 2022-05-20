package C8A;

public class Test {
    public static void main(String[] args) {
        Client cliente1 = new Client(1234, "password");
        Cajero cajero1 = new Cajero();

        cajero1.RetirarDinero(cliente1);
    }
}
