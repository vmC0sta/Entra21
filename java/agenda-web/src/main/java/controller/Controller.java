package controller;

import java.util.List;

public interface Controller <T> {
    boolean salvar(T t);
    List<T> exibirTodos();
    T exibir(Long id);
    void editar(Long id);
    void excluir(Long id);
}
