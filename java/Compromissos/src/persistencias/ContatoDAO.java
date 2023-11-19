package persistencias;

import conexao.ConexaoDB;
import entidades.Contato;
import generic.Generic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static conexao.ConexaoDB.*;

public class ContatoDAO implements Generic<Contato> {

    List<Contato> listaContato = new ArrayList<>();

    @Override
    public void inserir(Contato contato) {
        Connection conexao = ConexaoDB.getConexao();
        String sql = "INSERT INTO ag_contato (NOME, EMAIL, TELEFONE) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getEmail());
            statement.setString(3, contato.getTelefone());
            statement.executeUpdate();

            // Obtém o ID gerado automaticamente
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idGerado = generatedKeys.getInt(1);
                    contato.setId(idGerado);

                    // Adiciona o novo contato à lista local
                    listaContato.add(contato);

                    System.out.println("Contato adicionado à agenda com ID: " + idGerado);

                    // Atualiza a lista local após a inserção
                    atualizarDados();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoDB.closeConexao();
        }
    }


    @Override
    public void getById(int id) {
        for (Contato contato : listaContato) {
            if (contato.getId() == id) {
                System.out.println(contato.toString());
            }
        }
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

    public void atualizarDados() {
        Connection connection = ConexaoDB.getConexao();
        String sql = "SELECT * FROM ag_contato";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listaContato.add(new Contato(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            ConexaoDB.closeConexao();
        }
    }

}

