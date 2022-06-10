package C13S_Odontologo;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.io.File;
import java.sql.*;
//ver que esten estos 4 imports y las librerias instaladas (log4j, h2 y junit)

public class Odontologo {

    //paso 1 creo conexion
    public static Connection obtenerConexion() throws Exception{ //este metodo me conecta a la base de datos
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", ""); //datos de la base de datos h2
    }

    //paso 2 creo metodo main que va a ejecutar todo
    public static void main(String[] args) throws Exception{

        File log4jProperties = new File("src/Config/log4j.properties");
        PropertyConfigurator.configure(log4jProperties.getAbsolutePath());

        Logger logger = Logger.getLogger(Odontologo.class); //creo logger y le paso la clase como parametro

        Connection conexion = null ; //declaro esta variable en null para poder cerrar la BD con el finally despues

        try {
            conexion = obtenerConexion(); //creo una conexion nueva
            Statement statement = conexion.createStatement(); //esto permite ejecutar los queries en sql
            statement.execute(SQL_CREATE_TABLE); //ejecuto el querie creado antes usando execute que no devuelve nada

            Statement statement1 = conexion.createStatement();
            statement1.execute(SQL_INSERT1);

            System.out.println("======================================================");
            logger.info("Creo tabla e inserto un registro");
            listarUsuarios(conexion);


            Statement statement2 = conexion.createStatement();
            statement2.execute(SQL_UPDATE);

            System.out.println("======================================================");
            logger.info("Modifico el registro y lo muestro");
            listarUsuarios(conexion); //ejecuto el metodo declarado abajo que imprime por consola todos los registros
                                        //de la tabla


        } catch (Exception e){
            e.printStackTrace(); //imprimo por consola el error
        } finally {
            conexion.close(); //cierro la conexion de la base de datos
        }

    }

    //paso 3 creo queries que voy a ejecutar

        //creo tabla
        private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ODONTOLOGOS; CREATE TABLE ODONTOLOGOS " +
            "(NOMBRE varchar(30) NOT NULL ," +
            "APELLIDO varchar(30) NOT NULL," +
            "MATRICULA varchar(30) NOT NULL)";

        //inserto registros

        private static final String SQL_INSERT1 = "INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, MATRICULA) " +
                "VALUES ('GASTON', 'ODETTI', '39072144')";


        //elimino un registro
        private static final String SQL_UPDATE = "UPDATE ODONTOLOGOS SET MATRICULA = '1234' WHERE MATRICULA LIKE '39072144'";

    //paso 4 Creo metodo que liste usuarios
    public static String listarUsuarios(Connection conexion)throws SQLException {
        String seleccionarTodo = "SELECT * FROM ODONTOLOGOS"; //hago la querie
        Statement statement = conexion.createStatement(); //creo el statement
        ResultSet resultadoQuerie = statement.executeQuery(seleccionarTodo); //ejecuto la querie con execute querie que devuelve un resultSet

        while (resultadoQuerie.next()){
            System.out.println(" | Nombre: " + resultadoQuerie.getString(1) +
                    " | Apellido: " + resultadoQuerie.getString(2) +
                    " | Matricula: " + resultadoQuerie.getString(3));
        }
        return "ok";
    }
}
