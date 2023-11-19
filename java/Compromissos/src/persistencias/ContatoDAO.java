package persistencias;

import conexao.ConexaoDB;
import entidades.Contato;
import generic.Generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static conexao.ConexaoDB.*;

public class ContatoDAO  implements Generic<Contato> {
    @Override
    public void inserir(Contato contato) {
        try (Connection conexao = getConexao()) {
            String sql = "INSERT INTO Contato (NOME, EMAIL, TELEFONE) VALUES (?, ?, ?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, contato.getNome());
                statement.setString(2, contato.getEmail());
                statement.setString(3, contato.getTelefone());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Contato getById(int id) {
        return null;
    }

    @Override
    public List<Contato> getAll() {
        return null;
    }

    @Override
    public void atualizar(Contato contato) {

    }

    @Override
    public void excluir(int id) {

    }
}
