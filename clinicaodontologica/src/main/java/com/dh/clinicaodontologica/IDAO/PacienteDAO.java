package com.dh.clinicaodontologica.IDAO;
import com.dh.clinicaodontologica.models.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PacienteDAO implements IDao<Paciente>{

    private static final String SQL_CREAR_TABLA = "CREATE TABLE IF NOT EXISTS PACIENTES " +
            "(ID int(10), " +
            "NOMBRE varchar(200)," +
            "APELLIDO varchar(200)," +
            "DNI varchar(20)," +
            "EMAIL varchar(200),"+
            "FECHA_INGRESO varchar(50))";

    private static final String SQL_INSERTAR_REGISTRO = "INSERT INTO PACIENTES (ID, NOMBRE, APELLIDO," +
            "DNI,EMAIL,FECHA_INGRESO) VALUES (?,?,?,?,?,?)";

    @Override
    public Paciente guardarPaciente(Paciente paciente) throws SQLException {

        Connection connection = null;
        try {
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREAR_TABLA);

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERTAR_REGISTRO);
            preparedStatement.setInt(1,paciente.getId());
            preparedStatement.setString(2,paciente.getNombre());
            preparedStatement.setString(3,paciente.getApellido());
            preparedStatement.setString(4,"dni generico");
            preparedStatement.setString(5,paciente.getEmail());
            preparedStatement.setString(6,"9/6");
        }
        catch (Exception e){
            e.printStackTrace();
            connection.rollback();
        }
        finally {
            connection.close();
        }
        return paciente;
    }
}
