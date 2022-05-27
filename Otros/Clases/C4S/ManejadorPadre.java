package C4S;

import com.dh.chainofresponsability.chain.Manejador;
import com.dh.chainofresponsability.model.Correo;

public abstract class ManejadorPadre {

    protected ManejadorPadre siguienteManejador;

    public ManejadorPadre getSiguiente() {
        return this.siguienteManejador;
    }
    public void setSiguiente(ManejadorPadre m) {
        this.siguienteManejador = m;
    }

    public abstract String comprobar(Articulo articulo);






}
