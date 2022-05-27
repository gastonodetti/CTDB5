package C7A;

public class Test {

    public static void main(String[] args) {

        Cancion cancion1 = new CancionFactory().obtenerCancion("Arround the world");
        cancion1.setArtista("RHCP");
        cancion1.setGenero("Rock");
        Cancion cancion2 = new CancionFactory().obtenerCancion("We will rock you");
        cancion2.setArtista("Queen");
        cancion2.setGenero("Rock");



    }
}
