package C5S;

public class Usuario {
    private int identificador;
    private String tipo;

    public Usuario(int identificador, String tipo) {
        this.identificador = identificador;
        this.tipo = tipo;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
