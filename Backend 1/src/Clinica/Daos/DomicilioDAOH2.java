package Clinica.Daos;

import Clinica.DAO;
import Clinica.clases.Domicilio;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.plaf.nimbus.State;
import java.io.File;
import java.sql.*;

public class DomicilioDAOH2 implements DAO<Domicilio> {
    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS DOMICILIOS" +
            "(ID INT NOT NULL," +
            "CALLE varchar(200) NOT NULL," +
            "NUMERO varchar(10) NOT NULL," +
            "LOCALIDAD varchar(50) NOT NULL ," +
            "PROVINCIA varchar(50))";
    private static final String SQL_INSERT = "INSERT INTO DOMICILIOS (ID, CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?,?,?,?,?)";

    private static Logger logger;

    public DomicilioDAOH2(){
        File log4jProperties = new File("src/Config/log4j.properties");
        PropertyConfigurator.configure(log4jProperties.getAbsolutePath());
        logger = Logger.getLogger(DomicilioDAOH2.class); //creo logger y le paso la clase como parametro
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) throws SQLException {

        Connection conexion = null ; //declaro esta variable en null para poder cerrar la BD con el finally despues

        try {

            conexion = obtenerConexion(); //creo una conexion nueva
            Statement statement = conexion.createStatement(); //esto permite ejecutar los queries en sql

            System.out.println(" 1 ======================================================");
            logger.info("Creo tabla");
            statement.execute(SQL_CREATE_TABLE); //ejecuto el querie creado antes usando execute que no devuelve nada


            System.out.println(" 2 ======================================================");
            logger.info("inserto registro");

            PreparedStatement preparedStatement = conexion.prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1,domicilio.getDomicilioId());
            preparedStatement.setString(2,domicilio.getCalle());
            preparedStatement.setString(3,domicilio.getNumero());
            preparedStatement.setString(4,domicilio.getLocalidad());
            preparedStatement.setString(5,domicilio.getProvincia());
            preparedStatement.execute();

            logger.info("muestro tabla");
            mostrarDomicilios(conexion);

        } catch (Exception e){
            conexion.rollback();
            System.out.printf("Error, vuelva a realizar la operacion");
        } finally {
            conexion.close(); //cierro la conexion de la base de datos
        }

        return domicilio;
    }

    @Override
    public Domicilio buscar(int id) throws SQLException{

        Connection conexion = null ; //declaro esta variable en null para poder cerrar la BD con el finally despues

        try {
            System.out.println(" ============================= busco registro =============================");
            logger.info("conexion a base de datos");
            conexion = obtenerConexion(); //creo una conexion nueva
            Statement statement = conexion.createStatement(); //esto permite ejecutar los queries en sql

            logger.info("buscando registro");
            String buscarPorId = "SELECT * FROM DOMICILIOS WHERE ID = ?"; //hago la querie
            PreparedStatement preparedStatement = conexion.prepareStatement(buscarPorId);
            preparedStatement.setInt(1,id);
            ResultSet resultadoQuerie = statement.executeQuery(buscarPorId);
            System.out.println(resultadoQuerie);



        } catch (Exception e){
            conexion.rollback();
            System.out.printf("Error, vuelva a realizar la operacion");
        } finally {
            conexion.close(); //cierro la conexion de la base de datos
        }

        return null;
    }

    @Override
    public Domicilio eliminar(int id) {
        return null;
    }

    @Override
    public Domicilio modificar(int id) {
        return null;
    }

    public static Connection obtenerConexion() throws Exception{ //este metodo me conecta a la base de datos
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", ""); //datos de la base de datos h2
    }

    public static void mostrarDomicilios(Connection conexion)throws SQLException {
        String seleccionarTodo = "SELECT * FROM DOMICILIOS"; //hago la querie
        Statement statement = conexion.createStatement(); //creo el statement
        ResultSet resultadoQuerie = statement.executeQuery(seleccionarTodo); //ejecuto la querie con execute querie que devuelve un resultSet
        while (resultadoQuerie.next()){
            System.out.println(" | id: " + resultadoQuerie.getString(1) +
                    " | calle: " + resultadoQuerie.getString(2) +
                    " | numero: " + resultadoQuerie.getString(3) +
                    " | localidad: " + resultadoQuerie.getString(4) +
                    " | provincia: " + resultadoQuerie.getString(5));
        }

    }
}
