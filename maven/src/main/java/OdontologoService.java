import java.sql.SQLException;

public class OdontologoService {

    private static IDAO<Odontologo> odontologoIDAO;

    public OdontologoService(IDAO<Odontologo> odontologoIDAO){
        this.odontologoIDAO = odontologoIDAO;
    }
    public Odontologo registrarOdontologo(Odontologo odontologo) throws SQLException {
        return odontologoIDAO.registrarOdontologo(odontologo);
    }

    public String listarOdontologos() throws SQLException {
        return odontologoIDAO.listarOdontologos();
    }
}
