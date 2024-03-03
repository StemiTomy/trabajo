package series;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TemporadaDAO {
    private Connection connection = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultSet = null;

    //protected String namefile="com.vapf.bdjava.dao:calidadesDAO";

    protected String SQL_INSERT= "INSERT INTO temporada (fechaProduccion, fechaEstrenoMundial, serie_id) VALUES ( ?, ?, ? )";
    //protected String SQL_UPDATE ="UPDATE serie SET  titulo = ?, anyoInicio = ?, sinopsis = ? WHERE (id = ?)";
    //protected String SQL_DELETE = "DELETE FROM serie WHERE (id = ? )";
    //protected String SQL_ALL = "SELECT * FROM serie";
    protected String SQL_SELECT_ID = "SELECT * FROM temporada WHERE serie_id = ?";

    public TemporadaDAO() {}

    private Connection getConnection() throws SQLException {
        Connection conn = ConnectorJDBC.getInstance().getConnection();
        return conn;
    }

    public int add(TemporadaDTO temporadaObject) {
        int success = 0;
        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL_INSERT);
            ptmt.setDate(1, (java.sql.Date) temporadaObject.getFechaProduccion());
            ptmt.setDate(2, (java.sql.Date) temporadaObject.getFechaEstrenoMundial());
            ptmt.executeUpdate();
            success = 1;
        } catch (SQLException e) {
            success = 0;
            System.out.println("TemporadaDAO Mensaje de error: " + e.getMessage());
            System.out.println("TemporadaDAO Código de estado SQL: " + e.getSQLState());
            System.out.println("TemporadaDAO Código de error: " + e.getErrorCode());
        } catch (Exception e) {
            success = 0;
            // TODO: handle exception
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ptmt != null) {
                    ptmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                success = 0;
                // TODO: handle exception
            } catch (Exception e) {
                success = 0;
                // TODO: handle exception
            }
        }

        return success;
    }

    public ArrayList<TemporadaDTO> getTemporadasBySerieId(int serieId) {
        ArrayList<TemporadaDTO> results = new ArrayList <TemporadaDTO> ();
        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL_SELECT_ID);
            ptmt.setInt(1, serieId); // ejecutar el id de la sql
            resultSet = ptmt.executeQuery();
            System.out.println("Dentrod e temporadaDAO: el valor de resulteSet es de " + resultSet.toString());
            while (resultSet.next()) {
                TemporadaDTO dto = new TemporadaDTO();
                dto.setId(resultSet.getInt("id"));
                dto.setFechaProduccion(resultSet.getDate("fechaProduccion"));
                dto.setFechaEstrenoMundial(resultSet.getDate("fechaEstrenoMundial"));
                results.add(dto);
            }
            ptmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Mensaje de error: " + e.getMessage());
            System.out.println("Código de estado SQL: " + e.getSQLState());
            System.out.println("Código de error: " + e.getErrorCode());
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ptmt != null) {
                    ptmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // TODO: handle exception
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return results;
    }
}
