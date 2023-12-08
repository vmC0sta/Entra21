package controller;

import model.Contato;

import java.util.List;

public class ContatoController implements Controller<Contato>{
    @Override
    public boolean salvar(Contato contato) {
        return false;
    }

    @Override
    public List<Contato> exibirTodos() {
        return null;
    }

    @Override
    public Contato exibir(Long id) {
        return null;
    }

    @Override
    public void editar(Long id) {
    }

    @Override
    public void excluir(Long id) {

    }
}
