package C8A;

public class Cajero implements  InterfaceCajero{
    private AutenticationService autentication;
    private CuentaService cuenta;
    private CajaService caja;

    public Cajero(){
        this.autentication = new AutenticationService();
        this.cuenta = new CuentaService();
        this.caja = new CajaService();
    }

}
