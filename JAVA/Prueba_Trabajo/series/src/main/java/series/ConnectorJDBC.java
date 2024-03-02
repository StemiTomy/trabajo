package series;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorJDBC {
    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String HOST = "localhost";
    private static final String DB = "series_swing";
    private static final int PORT = 3306;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "796824ste";

    private String driverClassName = DRIVER_CLASS_NAME; // deprecated: "com.mysql.jdbc.Driver";
    private static ConnectorJDBC connectorJDBC = null;

    private ConnectorJDBC() {
        // lo hace automatico
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DB + "?user=" + USERNAME + "&password=" + PASSWORD);
        // TODO: parametrizar
        //conn = DriverManager.getConnection(ConfigurationOrber.getInstance().getUrlOrber() ,
        //								   ConfigurationOrber.getInstance().getUserBd(), 
        //								   ConfigurationOrber.getInstance().getPwd());
        return conn;
    }

    public static ConnectorJDBC getInstance() {
        if (connectorJDBC == null) {
        	connectorJDBC = new ConnectorJDBC();
        }
        return connectorJDBC;
    }
}
