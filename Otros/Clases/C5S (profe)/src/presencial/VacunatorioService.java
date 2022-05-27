package presencial;

public class VacunatorioService implements Vacunatorio{
    @Override
    public String vacunar(Persona persona) {
        System.out.println("Recibiendo a "+persona.getNombre());
        System.out.println("Verificando la información recibida");
        return "Se ha registrado el DNI "+persona.getDNI()
                +" como persona vacunada con "+persona.getNombreVacuna();
    }
}
