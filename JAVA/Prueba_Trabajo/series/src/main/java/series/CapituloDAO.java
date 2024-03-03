package series;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CapituloDAO {
    private Connection connection = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultSet = null;

    //protected String SQL_INSERT= "INSERT INTO capitulo (titulo, duracionMins, sinopsis) VALUES ( ?, ?, ? )";
    //protected String SQL_UPDATE ="UPDATE serie SET  titulo = ?, anyoInicio = ?, sinopsis = ? WHERE (id = ?)";
    //protected String SQL_DELETE = "DELETE FROM serie WHERE (id = ? )";
    //protected String SQL_ALL = "SELECT * FROM serie";
    protected String SQL_SELECT_ID = "SELECT * FROM capitulo WHERE temporada_id = ?";

    public CapituloDAO() {}

    private Connection getConnection() throws SQLException {
        Connection conn = ConnectorJDBC.getInstance().getConnection();
        return conn;
    }

    public ArrayList<CapituloDTO> getCapitulosByTemporadaId(int temporadaId) {
        ArrayList<CapituloDTO> results = new ArrayList <CapituloDTO> ();
        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL_SELECT_ID);
            ptmt.setInt(1, temporadaId); // ejecutar el id de la sql
            resultSet = ptmt.executeQuery();
            System.out.println("Dentrod e capituloDAO: el valor de resulteSet es de " + resultSet.toString());
            while (resultSet.next()) {
                CapituloDTO dto = new CapituloDTO();
                dto.setId(resultSet.getInt("id"));
                dto.setTitulo(resultSet.getString("titulo"));
                dto.setDuracionMins(resultSet.getInt("duracionMins"));
                dto.setSinopsis(resultSet.getString("sinopsis"));
                results.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("CapituloDAO Mensaje de error: " + e.getMessage());
            System.out.println("CapituloDAO Código de estado SQL: " + e.getSQLState());
            System.out.println("CapituloDAO Código de error: " + e.getErrorCode());
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
