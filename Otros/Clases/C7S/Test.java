package C7S;

public class Test {


    private static final String coloresDisponibles[] = {"rojo" , "verde"};

    public static void main(String[] args) {

       int contadorRojos = 0;
       int contadorVerdes = 0;

       for(int i = 0 ; i < 100 ; i++){
           Arbol arbol = new ArbolFactoryLightweight().crearArbol(1,1,obtenerColor(), "frutal");

           if(obtenerColor().equals("rojo")){
               contadorRojos+= 1;
           }
           if(obtenerColor().equals("verde")){
               contadorVerdes+= 1;
           }

           System.out.printf("rojos" + contadorRojos);
           System.out.printf("verdes" + contadorVerdes);

       }

    }

    private static String obtenerColor(){
        return coloresDisponibles[(int)(Math.random()*coloresDisponibles.length)];
    }


}
