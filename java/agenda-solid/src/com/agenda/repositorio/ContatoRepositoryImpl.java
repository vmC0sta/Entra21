package com.agenda.repositorio;

import com.agenda.dominio.Contato;
import com.agenda.persistencia.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoRepositoryImpl implements Repository<Contato> {
    private DBConnection dbConnection;

    public ContatoRepositoryImpl(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    publ    ic Contato save(Contato contato) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ag_contato (nome,email,telefone) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setString(2, contato.getEmail());
            preparedStatement.setString(3, contato.getTelefone());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                contato.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("Falha ao obter o ID gerado para o Contato.");
            }
            return contato;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar contato", e);
        }
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
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Contato contato = new Contato();
                contato.setId(resultSet.getLong("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setEmail(resultSet.getString("email"));
                contato.setTelefone(resultSet.getString("telefone"));
                return contato;
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
