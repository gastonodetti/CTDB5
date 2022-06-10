package C5S;

public class ServicioDescarga implements Descargar{

    @Override
    public String descargar(Usuario usuario) {
        System.out.println("Descargando cancion!");
        return "Descargando cancion!";
    }

}
