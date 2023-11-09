package utils;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static java.sql.Connection connection = null;

    public static java.sql.Connection getConnection() {
        connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "duda2404");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void fecharConexao() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
