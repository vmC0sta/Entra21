package dao;

import controller.Controller;
import model.Contato;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDao implements DAO<Contato> {
    DBConnection dbConnection;
    public ContatoDao(DBConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    @Override
    public boolean salvar(Contato contato) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ag_contato (nome,email,telefone) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setString(2, contato.getEmail());
            preparedStatement.setString(3, contato.getTelefone());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                contato.setId(generatedKeys.getLong(1));
                return true;
            } else {
                throw new SQLException("Falha ao obter o ID gerado para o Contato.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar contato", e);
        }
    }

    @Override
    public List<Contato> exibirTodos() {
        try(
                Connection connection = dbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ag_contatos");
                ResultSet resultSet = preparedStatement.executeQuery();
        ){
            List<Contato> contatos = new ArrayList<>();
            while (resultSet.next()){
                Contato contato = new Contato();
                contato.setId(resultSet.getLong("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setEmail(resultSet.getString("email"));
                contato.setTelefone(resultSet.getString("telefone"));
                contatos.add(contato);
            }
            return contatos;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao buscar todos os contatos",e);
        }
    }

    @Override
    public Contato exibir(Long id) {
        try(
            Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ag_contato WHERE id=?");
            ResultSet resultSet = preparedStatement.executeQuery();
        ){
            Contato contato = new Contato();
            if(resultSet.next()){
                contato.setId(resultSet.getLong("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setEmail(resultSet.getString("email"));
                contato.setTelefone(resultSet.getString("telefone"));
            }
            return contato;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao buscar contato", e);
        }
    }

    @Override
    public void editar(Long id) {

    }

    @Override
    public void excluir(Long id) {
        try(
                Connection connection = dbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ag_contato WHERE id=?")
                )
    }
}
