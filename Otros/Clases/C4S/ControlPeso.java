package C4S;

public class ControlPeso extends ManejadorPadre {
    @Override
    public String comprobar(Articulo articulo) {
        if (articulo.getPeso() >= 1200 && articulo.getPeso() <= 1300){
            return this.getSiguiente().comprobar(articulo);
        }else {return "";}
    }
}
