import java.io.*;
import java.util.List;
import java.util.ArrayList;


    public class Main {
        public static void main(String[] args) {
            List<Contacto> contactos = new ArrayList<>();

            Contacto floki = new Contacto("Floki", "email1", "1234");
            Contacto diego = new Contacto("Diego", "el10", "4567");

            contactos.add(floki);
            contactos.add(diego);

            try {
                FileOutputStream fileOutputStream = new FileOutputStream("Contactos.txt");
                ObjectOutputStream objContacto = new ObjectOutputStream(fileOutputStream);
                objContacto.writeObject(contactos);


            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

            List<Contacto> contactosLista = new ArrayList<>();
            try {
                FileInputStream fileInputStream = new FileInputStream("Contactos.txt");
                ObjectInputStream objContacto = new ObjectInputStream(fileInputStream);
                contactosLista = (ArrayList) objContacto.readObject();

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }

            for (Contacto contacto: contactosLista) {
                System.out.println("Nombre: " + contacto.getNombre() + "Email: " + contacto.getEmail()
                + "Telefono:" + contacto.getTelefono());
            }
        }
    }

