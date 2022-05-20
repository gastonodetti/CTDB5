package C3S;

public abstract class Vendedor {
    private int puntaje;
    private String categoria;
    public abstract void vender();

    public Vendedor() {
        this.puntaje = 0;
        this.categoria = "sin asignar";
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String mostrarCategoria(){
        calcularPuntaje();
        recategorizar();
        return getCategoria();
    }

    public int calcularPuntaje(){
        return this.getPuntaje();
    };
    public void recategorizar(){

        if(this.getPuntaje() < 20 ){
            setCategoria("novato");
        } else if (this.getPuntaje() >= 20 && this.getPuntaje() < 30 ){
            setCategoria("aprendiz");
        } else if (this.getPuntaje() >= 31 && this.getPuntaje() < 40 ){
            setCategoria("bueno");
        }else if (this.getPuntaje() > 40){
            setCategoria("maestro");
        }

    };

}
