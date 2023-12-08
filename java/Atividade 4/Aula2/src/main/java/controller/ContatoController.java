package controller;

import model.Contato;
import persistencia.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoController implements Controller<Contato> {
    private MySQL mySQL;

    public boolean save(Contato contato) {
        try (
                Connection connection = MySQL.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ag_contato (nome,email,telefone) VALUES (?,?,?)")
        ) {
            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setString(2, contato.getEmail());
            preparedStatement.setString(3, contato.getTelefone());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar contato", e);
        }
    }

    @Override
    public List<Contato> findAll() throws SQLException {
        try (
                Connection connection = MySQL.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ag_contato");
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            List<Contato> contatos = new ArrayList<>();
            while (resultSet.next()) {
                Contato contato = new Contato();
                contato.setId(resultSet.getLong("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setEmail(resultSet.getString("email"));
                contato.setTelefone(resultSet.getString("telefone"));
                contatos.add(contato);
            }
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todos os contato", e);
        }
    }


    @Override
    public Contato findyById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

}
