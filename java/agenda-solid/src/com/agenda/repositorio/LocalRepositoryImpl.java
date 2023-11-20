package com.agenda.repositorio;

import com.agenda.dominio.Local;
import com.agenda.persistencia.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocalRepositoryImpl implements Repository<Local> {
    private DBConnection dbConnection;

    public LocalRepositoryImpl(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public Local save(Local local) {
        try (
                Connection connection = dbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ag_local (descricao) VALUES (?)")
        ) {
            preparedStatement.setString(1, local.getDescricao());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar local", e);
        }
        return local;
    }

    @Override
    public List<Local> findAll(){
        try (
                Connection connection = dbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ag_local");
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            List<Local> locais = new ArrayList<>();
            while (resultSet.next()) {
                Local local = new Local();
                local.setDescricao(resultSet.getString("descricao"));
                locais.add(local);
            }
            return locais;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao exibir todos os locais", e);
        }
    }

    @Override
    public Local findyById(Long id) {
        try (
                Connection connection = dbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ag_local WHERE id = ?")
        ) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    Local local = new Local();
                    local.setId(resultSet.getLong("id"));
                    local.setDescricao(resultSet.getString("descricao"));
                    return local;
                }
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao exibir local");
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try(
                Connection connection = dbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ag_local WHERE id = ?")
                ){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Erro ao excluir local",e);
        }
    }
}
