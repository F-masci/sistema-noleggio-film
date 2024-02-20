package it.bd.sistema.noleggio.factory;

import it.bd.sistema.noleggio.model.RoleType;
import it.bd.sistema.noleggio.view.GenericView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private final static String PROPERTIES_FILE = "/db.properties";
    private static Connection connection;
    private final static Properties properties = new Properties();;


    private ConnectionFactory() {}

    static {
        try (InputStream input = ConnectionFactory.class.getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(input);

            String url = properties.getProperty("connection.url");
            String username = properties.getProperty("login.user");
            String password = properties.getProperty("login.password");

            connection = DriverManager.getConnection(url, username, password);
        } catch (IOException | SQLException e) {
            GenericView.showErrorMessage(e);
            System.exit(-1);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void changeRole(RoleType role) {
        try {

            connection.close();

            String url = properties.getProperty("connection.url");
            String username = properties.getProperty(role.getConnectionRole() + ".user");
            String password = properties.getProperty(role.getConnectionRole() + ".password");

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            GenericView.showErrorMessage(e);
            System.exit(-1);
        }
    }

}
