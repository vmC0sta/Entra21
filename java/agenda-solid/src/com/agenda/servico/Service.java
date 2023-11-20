package com.agenda.servico;

import com.agenda.repositorio.Repository;

import java.sql.SQLException;
import java.util.List;

public interface Service <T>{

    List<T> listarTodos() throws SQLException;
    T listarPorId(Long id);
    T salvar(T t);
    void excluir(Long id);

}
