package C7S;

import java.util.HashMap;

public class ArbolFactoryLightweight {

    private static final HashMap<String, Arbol> arbolMap = new HashMap<>();

    public static Arbol crearArbol(float alto, float ancho, String color, String tipo) {
        String key = "alto: " + alto + "ancho: " + ancho + "color: " + color + "tipo: " + tipo;
        Arbol arbol  = arbolMap.get(key);
        if(arbol == null) {
            arbol = new Arbol(alto, ancho, color, tipo);
            arbolMap.put(key, arbol);
            System.out.println("Creando arbol con caracteristicas: " + key);
        } else {
            System.out.println("el arbol ya existe");
        }
        return arbol;
    }

}
