package C4S;

import com.dh.chainofresponsability.chain.*;

public class AnalistaCalidad {
    private ManejadorPadre inicial;

    public AnalistaCalidad() {
        //Creamos los eslabones de la cadena....
        this.inicial = new ControlLote();
        ManejadorPadre peso = new ControlPeso();
        ManejadorPadre envasado = new ControlEnvasado();

        //Luego los unimos.
        inicial.setSiguiente(peso);
        peso.setSiguiente(envasado);
    }

    protected void comprobar(Articulo articulo){
        System.out.println(inicial.comprobar(articulo));
    }
}
