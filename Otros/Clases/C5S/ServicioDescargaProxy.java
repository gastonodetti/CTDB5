package C5S;

public class ServicioDescargaProxy implements Descargar {


    @Override
    public String descargar(Usuario usuario) {
        System.out.printf("Comprobando tipo de usuario...");
        if (usuario.getTipo().equals("Premium")){
            System.out.printf("Usuario aceptado!");
            return "Usuario aceptado!";
        } else {
            System.out.printf("flaco flashaste confianza, no estas pagando nada :@");
            return "flaco flashaste confianza, no estas pagando nada :@";
        }

    }
}
