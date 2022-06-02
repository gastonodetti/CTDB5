package Clinica.Daos;

import Clinica.DAO;
import Clinica.clases.Domicilio;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.plaf.nimbus.State;
import java.io.File;
import java.sql.*;

public class DomicilioDAOH2 implements DAO<Domicilio> {

    // QUERIES DE BUSQUEDA
    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS DOMICILIOS" +
            "(ID INT NOT NULL," +
            "CALLE varchar(200) NOT NULL," +
            "NUMERO varchar(10) NOT NULL," +
            "LOCALIDAD varchar(50) NOT NULL ," +
            "PROVINCIA varchar(50))";
    private static final String SQL_INSERT = "INSERT INTO DOMICILIOS (ID, CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?,?,?,?,?)";
    private static final String SQL_BUSCAR = "SELECT * FROM DOMICILIOS WHERE ID=?";
    private static final String SQL_BORRAR = "DELETE FROM DOMICILIOS WHERE ID=?";
    private static final String SQL_MODIFICAR = "UPDATE DOMICILIOS SET CALLE=? WHERE ID=?";
    private static Logger logger;

    // CONSTRUCTOR DOMICILIO DAO
    public DomicilioDAOH2(){
        File log4jProperties = new File("src/Config/log4j.properties");
        PropertyConfigurator.configure(log4jProperties.getAbsolutePath());
        logger = Logger.getLogger(DomicilioDAOH2.class); //creo logger y le paso la clase como parametro
    }

    //METODOS DAO
    public Domicilio guardar(Domicilio domicilio) throws SQLException {

        Connection conexion = null ; //declaro esta variable en null para poder cerrar la BD con el finally despues

        try {
            logger.info("Creo tabla");
            conexion = obtenerConexion(); //creo una conexion nueva
            Statement statement = conexion.createStatement(); //esto permite ejecutar los queries en sql
            statement.execute(SQL_CREATE_TABLE); //ejecuto el querie creado antes usando execute que no devuelve nada


            logger.info("Inserto registro");

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
    public Domicilio buscar(Domicilio domicilio) throws SQLException{

        Connection conexion = null ; //declaro esta variable en null para poder cerrar la BD con el finally despues
        Domicilio domicilioEncontrado = null;

        try {
            logger.info("Busco registro ID = " + domicilio.getDomicilioId());
            conexion = obtenerConexion(); //creo una conexion nueva
            PreparedStatement preparedStatement = conexion.prepareStatement(SQL_BUSCAR);
            preparedStatement.setInt(1,domicilio.getDomicilioId());
            ResultSet resultadoQuerie = preparedStatement.executeQuery();


            while (resultadoQuerie.next()) {
                int idDomicilio = resultadoQuerie.getInt("ID");
                String calle = resultadoQuerie.getString("CALLE");
                String numero = resultadoQuerie.getString("NUMERO");
                String localidad = resultadoQuerie.getString("LOCALIDAD");
                String provincia = resultadoQuerie.getString("PROVINCIA");

                domicilioEncontrado = new Domicilio(idDomicilio, calle, numero, localidad, provincia);

                while (resultadoQuerie.next()){
                    System.out.println("RESULTADO:" +
                            " | id: " + resultadoQuerie.getString(1) +
                            " | calle: " + resultadoQuerie.getString(2) +
                            " | numero: " + resultadoQuerie.getString(3) +
                            " | localidad: " + resultadoQuerie.getString(4) +
                            " | provincia: " + resultadoQuerie.getString(5));
                }
            }



        } catch (Exception e){
            e.printStackTrace();
            logger.info("Error");
            conexion.rollback();

        } finally {
            conexion.close(); //cierro la conexion de la base de datos
        }

        return domicilioEncontrado;
    }
    public Domicilio eliminar(Domicilio domicilio) throws SQLException{

        Connection conexion = null ; //declaro esta variable en null para poder cerrar la BD con el finally despues

        try {
            logger.info("Borrando registro(s) ID = " + domicilio.getDomicilioId());
            conexion = obtenerConexion(); //creo una conexion nueva
            PreparedStatement preparedStatement = conexion.prepareStatement(SQL_BORRAR);
            preparedStatement.setInt(1,domicilio.getDomicilioId());
            preparedStatement.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
            conexion.rollback();

        } finally {
            conexion.close(); //cierro la conexion de la base de datos
        }
        return null;
    }
    public Domicilio modificar(Domicilio domicilio, String nuevoValor) throws SQLException{

        Connection conexion = null ; //declaro esta variable en null para poder cerrar la BD con el finally despues

        try {
            logger.info("Modifico domicilio ID = " + domicilio.getDomicilioId());
            conexion = obtenerConexion(); //creo una conexion nueva
            PreparedStatement preparedStatement = conexion.prepareStatement(SQL_MODIFICAR);
            //preparedStatement.setString(1, campo);
            preparedStatement.setString(1, nuevoValor);
            preparedStatement.setInt(2, domicilio.getDomicilioId());

            preparedStatement.executeUpdate();


        } catch (Exception e){
            e.printStackTrace();
            logger.info("Error");
            conexion.rollback();

        } finally {
            conexion.close(); //cierro la conexion de la base de datos
        }

        return domicilio;


    }

    //GENERACION DE CONEXION CON BASE DE DATOS H2
    public static Connection obtenerConexion() throws Exception{ //este metodo me conecta a la base de datos
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", ""); //datos de la base de datos h2
    }

    //MOSTRAR DOMICILIOS POR CONSOLA
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
