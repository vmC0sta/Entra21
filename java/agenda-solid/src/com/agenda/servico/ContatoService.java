package com.agenda.servico;

import com.agenda.dominio.Contato;
import com.agenda.repositorio.ContatoRepositoryImpl;

import java.util.List;

public class ContatoService implements Service<Contato>{
    private ContatoRepositoryImpl contatoRepositoryImpl;
    public ContatoService(ContatoRepositoryImpl contatoRepository){
        this.contatoRepositoryImpl = contatoRepository;
    }

    @Override
    public List<Contato> listarTodos() {
        return contatoRepositoryImpl.findAll();
    }

    @Override
    public Contato listarPorId(Long id) {
        return contatoRepositoryImpl.findyById(id);
    }

    @Override
    public Contato salvar(Contato contato) {
        return contatoRepositoryImpl.save(contato);
    }

    @Override
    public void excluir(Long id) {
        contatoRepositoryImpl.deleteById(id);
    }
}
