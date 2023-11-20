package com.agenda.repositorio;

import com.agenda.dominio.Contato;
import com.agenda.persistencia.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoRepositoryImpl implements Repository<Contato> {
    private DBConnection dbConnection;

    public ContatoRepositoryImpl(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public Contato save(Contato contato) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ag_contato (nome,email,telefone) VALUES (?,?,?)")) {
            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setString(2, contato.getEmail());
            preparedStatement.setString(3, contato.getTelefone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar contato", e);
        }
        ;
        return contato;
    }

    @Override
    public List<Contato> findAll() {
        try (
                Connection connection = dbConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM ag_contato");
                ResultSet resultSet = statement.executeQuery()
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
            throw new RuntimeException("Erro ao buscar todos os contatos", e);
        }
    }

    @Override
    public Contato findyById(Long id) {
        try (
                Connection connection = dbConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM ag_contato WHERE id = ?")
        ) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Contato contato = new Contato();
                    contato.setId(resultSet.getLong("id"));
                    contato.setNome(resultSet.getString("nome"));
                    contato.setEmail(resultSet.getString("email"));
                    contato.setTelefone(resultSet.getString("telefone"));
                    return contato;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public void deleteById(Long id) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ag_contato WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar contato", e);
        }
    }
}
