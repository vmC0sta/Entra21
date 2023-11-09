package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static java.sql.Connection connection = null;

    public static Connection getConnection() {
        connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/produtos", "root", "duda2404");
            System.out.println("Conectado ao banco de dados");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
