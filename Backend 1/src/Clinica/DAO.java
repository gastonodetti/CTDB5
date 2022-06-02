package Clinica;
// consigna https://docs.google.com/document/d/17NcIvL_6OiLcW3pr44YZZxFRSwkc1c4jaZ6-Cm5GkZ4/edit
// video clase https://digitalhouse.zoom.us/rec/play/OZZacDYl_wQsy4ZFnE9lmi9SakC3ArP0LCzPujtzTPcfsbKWF8a4WNCtTDhtr3W2U9oQ5OZKDxyclSbV.y4qqthMMmQftYqZf?startTime=1653952474000&_x_zm_rtaid=f9hqk19BRJGwCkncuz9AfQ.1654117260477.a1efe0e3215e500221510248b6b159fc&_x_zm_rhtaid=56

import java.sql.SQLException;

public interface DAO<T>{
    public T guardar (T t) throws SQLException;
    public T buscar (int id) throws SQLException;
    public T eliminar (int id)throws SQLException;
    public T modificar (int id) throws SQLException;

}
