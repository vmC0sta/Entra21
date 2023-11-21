package com.agenda.repositorio;

import com.agenda.dominio.Compromisso;
import com.agenda.dominio.Contato;
import com.agenda.dominio.Local;
import com.agenda.persistencia.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompromissoRepositoyImpl implements RepositoryNN<Compromisso> {
    private DBConnection dbConnection;

    public CompromissoRepositoyImpl(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public Compromisso save(Compromisso compromisso) {
        try (
                Connection connection = dbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ag_compromisso (descricao,local) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, compromisso.getDescricao());
            preparedStatement.setLong(2, compromisso.getLocal().getId());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                compromisso.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("Falha ao obter o ID gerado para o Compromisso.");
            }
            return compromisso;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar compromisso", e);
        }
    }

    @Override
    public List<Compromisso> findAll() throws SQLException {
        try (
                Connection connection = dbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT " +
                                "   A.id AS compromisso_id, " +
                                "   A.descricao AS compromisso_descricao, " +
                                "   B.id AS local_id, " +
                                "   B.descricao AS local_descricao, " +
                                "   C.id AS contato_id, " +
                                "   C.nome AS contato_nome " +
                                "FROM ag_compromisso A " +
                                "INNER JOIN ag_local B ON A.local = B.id " +
                                "INNER JOIN ag_compromissocontato D ON A.id = D.compromisso " +
                                "INNER JOIN ag_contato C ON D.contato = C.id"
                );
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            List<Compromisso> compromissos = new ArrayList<>();
            Map<Long, Compromisso> compromissoMap = new HashMap<>();
            while (resultSet.next()) {
                Long compromissoId = resultSet.getLong("compromisso_id");

                if (!compromissoMap.containsKey(compromissoId)) {
                    Compromisso compromisso = new Compromisso();
                    compromisso.setId(compromissoId);
                    compromisso.setDescricao(resultSet.getString("compromisso_descricao"));

                    Local local = new Local();
                    local.setId(resultSet.getLong("local_id"));
                    local.setDescricao(resultSet.getString("local_descricao"));
                    compromisso.setLocal(local);

                    compromissos.add(compromisso);
                    compromissoMap.put(compromissoId, compromisso);
                }

                Contato contato = new Contato();
                contato.setId(resultSet.getLong("contato_id"));
                contato.setNome(resultSet.getString("contato_nome"));
                compromissoMap.get(compromissoId).getContatos().add(contato);
            }

            return compromissos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar compromissos", e);
        }
    }

    @Override
    public Compromisso findyById(Long id) throws SQLException {
        try (
                Connection connection = dbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT " +
                                "   A.id AS compromisso_id, " +
                                "   A.descricao AS compromisso_descricao, " +
                                "   B.id AS local_id, " +
                                "   B.descricao AS local_descricao, " +
                                "   C.id AS contato_id, " +
                                "   C.nome AS contato_nome " +
                                "FROM ag_compromisso A " +
                                "INNER JOIN ag_local B ON A.local = B.id " +
                                "INNER JOIN ag_compromissocontato D ON A.id = D.compromisso " +
                                "INNER JOIN ag_contato C ON D.contato = C.id " +
                                "WHERE A.id = ?"
                );
        ) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Compromisso compromisso = null;
            while (resultSet.next()) {
                if (compromisso == null) {
                    compromisso = new Compromisso();
                    compromisso.setId(resultSet.getLong("compromisso_id"));
                    compromisso.setDescricao(resultSet.getString("compromisso_descricao"));

                    Local local = new Local();
                    local.setId(resultSet.getLong("local_id"));
                    local.setDescricao(resultSet.getString("local_descricao"));
                    compromisso.setLocal(local);
                }

                Contato contato = new Contato();
                contato.setId(resultSet.getLong("contato_id"));
                contato.setNome(resultSet.getString("contato_nome"));
                compromisso.getContatos().add(contato);
            }
            return compromisso;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (
                Connection connection = dbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ag_compromisso WHERE id = ?")
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void associate(Long idCompromisso, Long idContato) {
        try (
                Connection connection = dbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ag_compromissocontato (compromisso,contato) VALUES (?,?)")
        ) {
            preparedStatement.setLong(1, idCompromisso);
            preparedStatement.setLong(2, idContato);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAssociate(Long idCompromisso, Long idContato) {
        try (
                Connection connection = dbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ag_compromissocontato WHERE compromisso = ? AND contato = ?");
        ) {
            preparedStatement.setLong(1, idCompromisso);
            preparedStatement.setLong(2, idContato);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
