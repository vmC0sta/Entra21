package com.agenda.servico;

import com.agenda.repositorio.Repository;

import java.util.List;

public interface Service <T>{

    List<T> listarTodos();
    T listarPorId(Long id);
    T salvar(T t);
    void excluir(Long id);

}
