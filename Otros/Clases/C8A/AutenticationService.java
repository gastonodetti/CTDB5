package C8A;

public class AutenticationService {

    public final static String validarUsuarioYContrasena(Client client){
        System.out.println("Validando usuario...");
        System.out.println("DNI: " + client.getDni() + " Contraseña: " + client.getPassword());
        return null;
    }
}
