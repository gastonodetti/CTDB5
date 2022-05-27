package C3S;

public class Afiliado extends Vendedor{
    public Afiliado() {
        super();
    }

    @Override
    public void vender() {
        setPuntaje(getPuntaje() + 15);
    }


}
