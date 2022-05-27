package C7A;

import java.util.HashMap;

public class CancionFactory  {
    private static final HashMap<String, Cancion> cancionMap = new HashMap<>();

    public static Cancion obtenerCancion(String nombre) {
        Cancion cancion  = cancionMap.get(nombre);
        if(cancion == null) {
            cancion = new Cancion(nombre);
            cancionMap.put(nombre, cancion);
            System.out.println("Creando cancion llamada: " + nombre);
        } else {
            System.out.println("cancion ya creada!");
        }
        return cancion;
    }
}
