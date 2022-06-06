package Interface;

import java.sql.SQLException;

public interface IDAO<Odontologo> {
    public Odontologo registrarOdontologo(Odontologo odontologo) throws SQLException;
    public String listarOdontologos() throws SQLException;

}
