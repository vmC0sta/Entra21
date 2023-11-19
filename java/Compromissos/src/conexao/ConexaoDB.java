package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static Connection connection = null;

    public static Connection getConexao(){
        connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","duda2404");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConexao(){
        try{
            connection.close();
        }catch (SQLException e){
            throw new  RuntimeException(e);
        }
    }

}
