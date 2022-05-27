package C8A;

public interface InterfaceCajero {
    public default void RetirarDinero(Client client){
        AutenticationService.validarUsuarioYContrasena(client);
        CuentaService.validarCuenta(client);
        CajaService.entregarDinero(client);
    }
}
