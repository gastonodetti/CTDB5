package C4S;

public class ControlEnvasado extends ManejadorPadre {
    @Override
    public String comprobar(Articulo articulo) {
        if (articulo.getEnvasado().equals("sano") || articulo.getEnvasado().equals("casi sano")){
            return "Aceptado";
        }else {return "No aceptado";}
    }
}
