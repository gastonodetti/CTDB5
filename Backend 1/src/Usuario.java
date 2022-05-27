import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.sql.*;
import java.util.logging.Logger;

public class Usuario {
    private static final Logger logger = Logger.getLogger(Usuario.class);
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS USUARIOS; CREATE TABLE USUARIOS "
        + "(ID INT PRIMARY KEY, PRIMER_NOMBRE varchar(150) NOT NULL, APELLIDO varchar(150) NOT NULL, EDAD INT)";

    private static final String SQL_INSERT = "INSERT INTO USUARIOS (ID, PRIMER_NOMBRE, APELLIDO) "
        + "VALUES (1, 'Ignacio', 'Pantalone')";

    private static final String SQL_INSERT1 = "INSERT INTO USUARIOS (ID, PRIMER_NOMBRE, APELLIDO, EDAD) "
            + "VALUES (2, 'Cristian', 'Rivas', 35)";

    private static final String SQL_INSERT2 = "INSERT INTO USUARIOS (ID, PRIMER_NOMBRE, APELLIDO, EDAD) "
            + "VALUES (3, 'Gabriela', 'Rico', 25)";

    private static final String SQL_DELETE = "DELETE FROM USUARIOS WHERE PRIMER_NOMBRE LIKE '%gnac%'";

    public static void main(String[] args) throws Exception {
        File log4jProperties = new File("src/config/log4j.properties");
        PropertyConfigurator.configure(log4jProperties.getAbsolutePath());
        Logger logger = Logger.getLogger(Usuario.class);

        Connection conexion = null;
        try {
            conexion = obtenerConexion();
            Statement statement = conexion.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            Statement statement1 = conexion.createStatement();
            statement1.execute(SQL_INSERT);

            Statement statement2 = conexion.createStatement();
            statement2.execute(SQL_INSERT1);

            Statement statement3 = conexion.createStatement();
            statement3.execute(SQL_INSERT2);

            listarUsuario(conexion);

            logger.info("=============================================");

            Statement deleteStatement = conexion.createStatement();
            int fieldsDeleted = deleteStatement.executeUpdate(SQL_DELETE);

            logger.info("Row deleted = " + fieldsDeleted);
            listarUsuario(conexion);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.close();
        }
    }

    private static void listarUsuario(Connection conexion) throws SQLException {
        String sql = "SELECT * FROM USUARIOS";
        Statement statement = conexion.createStatement();
        ResultSet listaUsuarios = statement.executeQuery(sql);

        while (listaUsuarios.next()) {
            System.out.println(listaUsuarios.getString(2) + " " + listaUsuarios.getString(3));
        }
    }

    public static Connection obtenerConexion() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/usuarios", "root", "toor");
    }
}
