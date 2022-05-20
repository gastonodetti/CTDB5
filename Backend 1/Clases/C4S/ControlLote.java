package C4S;

public class ControlLote extends ManejadorPadre{

    @Override
    public String comprobar(Articulo articulo) {
       if (articulo.getLote() >= 1000 && articulo.getLote() <= 2000){
           return this.getSiguiente().comprobar(articulo);
       } else {return "";}
    }


}
