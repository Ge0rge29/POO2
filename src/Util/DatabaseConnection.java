package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties");
                Properties props = new Properties();
                props.load(input);

                String url = props.getProperty("url");
                String user = props.getProperty("username");
                String pass = props.getProperty("password");

                connection = DriverManager.getConnection(url, user, pass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

}
