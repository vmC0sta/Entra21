package classes;
import utils.Conexao;

import java.sql.*;

public class Jdbc {
    public static void main(String[] args) {

//       if(Conexao.getConnection() != null) {
//           System.out.println("conectado");
//       }
//        salvar();
        consultar();

    }

    static void consultar(){
        Connection con = Conexao.getConnection();
        String sql = "SELECT * FROM AG_CONTATO";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("id") + "\t" + rs.getString("nome") + "\t" + rs.getString("email") + "\t" + rs.getString("telefone"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

//    SQL INJECTION
    static void salvar(){
        Connection con = Conexao.getConnection();
        String sql = "INSERT INTO AG_CONTATO(nome,email,telefone)values(?,?,?)";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1,"Joãozinho");
            stm.setString(2,"joaozinho@gmail.com");
            stm.setString(3,"(47) 99607-5616");
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            Conexao.fecharConexao();
        }
    }

}