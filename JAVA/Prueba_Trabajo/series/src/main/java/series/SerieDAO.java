package series;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SerieDAO {
    private Connection connection = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultSet = null;

    //protected String namefile="com.vapf.bdjava.dao:calidadesDAO";

    protected String SQL_INSERT= "INSERT INTO serie (titulo, anyoInicio, sinopsis) VALUES ( ?, ?, ? )";
    protected String SQL_UPDATE ="UPDATE serie SET  titulo = ?, anyoInicio = ?, sinopsis = ? WHERE (id = ?)";
    protected String SQL_DELETE = "DELETE FROM serie WHERE (id = ? )";
    protected String SQL_ALL = "SELECT * FROM serie";

    public SerieDAO () {}

    private Connection getConnection() throws SQLException {
        Connection conn = ConnectorJDBC.getInstance().getConnection();
        return conn;
    }

    public int add(SerieDTO serieObject) {
        int success = 0;
        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL_INSERT);
            ptmt.setString(1, serieObject.getTitulo());
            ptmt.setDate(2, (java.sql.Date) serieObject.getAnoInicio());
            ptmt.setString(3, serieObject.getSinopsis());
            ptmt.executeUpdate();
            success = 1;
        } catch (SQLException e) {
            success = 0;
            System.out.println("Mensaje de error: " + e.getMessage());
            System.out.println("Código de estado SQL: " + e.getSQLState());
            System.out.println("Código de error: " + e.getErrorCode());
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

    public ArrayList<SerieDTO> getSeries() {
        ArrayList<SerieDTO> results = new ArrayList <SerieDTO> ();
        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL_ALL);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                SerieDTO dto = new SerieDTO();
                dto.setId(resultSet.getInt("id"));
                dto.setTitulo(resultSet.getString("titulo"));
                dto.setAnoInicio(resultSet.getDate("anyoInicio"));
                dto.setSinopsis(resultSet.getString("sinopsis"));

                // Aquí recuperas las temporadas asociadas a la serie
                int serieId = resultSet.getInt("id"); // Obtener el ID de la serie
                TemporadaDAO temporadaDAO = new TemporadaDAO();
                ArrayList<TemporadaDTO> temporadas = temporadaDAO.getTemporadasBySerieId(serieId);

                // Para cada temporada, obtener los capítulos asociados
                for (TemporadaDTO temporada : temporadas) {
                    CapituloDAO capituloDAO = new CapituloDAO();
                    ArrayList<CapituloDTO> capitulos = capituloDAO.getCapitulosByTemporadaId(temporada.getId());
                    temporada.setCapitulos(capitulos);
                }
                dto.setTemporadas(temporadas);

                results.add(dto);
            }
        } catch (SQLException e) {
            // TODO: handle exception
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

    public int update(SerieDTO serieObject){
        int success = 0;
        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL_UPDATE);
            ptmt.setString(1, serieObject.getTitulo());
            ptmt.setDate(2, (java.sql.Date) serieObject.getAnoInicio());
            ptmt.setString(3, serieObject.getSinopsis());
            ptmt.setInt(4, serieObject.getId());
            ptmt.executeUpdate();
            success = 1;
        } catch (SQLException e) {
            success = 0;
            System.out.println("Mensaje de error: " + e.getMessage());
            System.out.println("Código de estado SQL: " + e.getSQLState());
            System.out.println("Código de error: " + e.getErrorCode());
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

    public int delete(SerieDTO serieObject){
        int success = 0;
        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(SQL_DELETE);
            ptmt.setInt(1, serieObject.getId());
            ptmt.executeUpdate();
            success = 1;
        } catch (SQLException e) {
            success = 0;
            System.out.println("Mensaje de error: " + e.getMessage());
            System.out.println("Código de estado SQL: " + e.getSQLState());
            System.out.println("Código de error: " + e.getErrorCode());
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

}
