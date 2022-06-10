package C1A;

public class Persona {
    public String Nombre;
    public String Apellido;
    public String Email;
    public int Edad;

    public void MostrarNombre(){
        System.out.println("Nombre: " + Nombre + " Apellido: " + Apellido);
    }

    public boolean EsMayor(){
        if (Edad >= 18){
            System.out.println("Si, es mayor");
            return true;
        } else {
            System.out.println("No, es menor de 18");
            return false;
        }
    }

    public Persona(String nombre, String apellido, String email, int edad) {
        Nombre = nombre;
        Apellido = apellido;
        Email = email;
        Edad = edad;
    }
}
