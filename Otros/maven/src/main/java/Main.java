

public class Main {
        public static void main(String[] args) {
            /*Guardamos el objeto en un archivo*/
            FileOutputStream fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(persona);

            /*Recuperamos el objeto en un archivo*/
            FileInputStream fi = new FileInputStream("OutputFile.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);

            System.out.println(ois.readObject());
            dos.close();
        }

}
