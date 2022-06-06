package DAO_Entity;

import Entity.Odontologo;
import Interface.IDAO;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.io.File;
import java.sql.*;

import java.sql.SQLException;

public class OdontologoDAO implements IDAO<Odontologo> {

    private static Logger logger;

    //QUERIES SQL DEFINIDAS ==============================================================

    private static final String SQL_CREAR_TABLA = "CREATE TABLE IF NOT EXISTS ODONTOLOGOS " +
            "(MATRICULA varchar(20)," +
            "NOMBRE varchar(50)," +
            "APELLIDO varchar(50))";

    private static final String SQL_INSERTAR_REGISTRO = "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)";
    private  static final String SQL_LISTAR_ODONTOLOGOS = "SELECT * FROM ODONTOLOGOS";

    //=====================================================================================

    //CONSTRUCTOR DE LA CLASE Y PROPERTIES LOG4J ==========================================

    public OdontologoDAO(){
            File log4jProperties = new File("src/Config/log4j.properties");
            PropertyConfigurator.configure(log4jProperties.getAbsolutePath());
            logger = Logger.getLogger(OdontologoDAO.class);
    }

    //GENERACION DE CONEXION CON BASE DE DATOS H2 =========================================
    public static Connection obtenerConexion() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test;", "sa", "");
    }

    //METODOS =============================================================================

    public Odontologo registrarOdontologo(Odontologo odontologo) throws SQLException {

        Connection conexion = null ;

        try {

            logger.info("Creando tabla ODONTOLOGOS (si es que no existe)...");
            conexion = obtenerConexion();
            Statement statement = conexion.createStatement();
            //statement.execute(SQL_CREAR_TABLA);

            logger.info("Insertando un nuevo registro...");
            PreparedStatement preparedStatement = conexion.prepareStatement(SQL_INSERTAR_REGISTRO);
            preparedStatement.setString(1,odontologo.getMatricula());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3,odontologo.getApellido());
            preparedStatement.execute();
            logger.info("Registro insertado exitosamente");


        } catch (Exception e){
            logger.info("Ha ocurrido un error");
            e.printStackTrace();
            conexion.rollback();

        } finally {
            conexion.close();
        }
        return odontologo;
    }


    public String listarOdontologos() throws SQLException {

        Connection conexion = null;

        try {
            conexion = obtenerConexion();
            Statement statement = conexion.createStatement();

            logger.info("Listando odontologos de la base de datos...");
            ResultSet listadoCompleto = statement.executeQuery(SQL_LISTAR_ODONTOLOGOS);
            while (listadoCompleto.next()) {
                System.out.println(" | Nombre: " + listadoCompleto.getString(1) +
                        " | Apellido: " + listadoCompleto.getString(2) +
                        " | Matricula: " + listadoCompleto.getString(3));
            }
            logger.info("Listado exitoso.");

        }
        catch (Exception e) {
            logger.info("Ha ocurrido un error");
            e.printStackTrace();
            conexion.rollback();
        }

        finally { conexion.close(); }

        return "Listado exitoso.";
    }

}
