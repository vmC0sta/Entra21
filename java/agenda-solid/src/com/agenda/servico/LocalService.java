package com.agenda.servico;

import com.agenda.dominio.Local;
import com.agenda.repositorio.LocalRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class LocalService implements Service<Local>{
    private LocalRepositoryImpl localRepositoryImpl;

    public LocalService(LocalRepositoryImpl localRepositoryImpl){
        this.localRepositoryImpl = localRepositoryImpl;
    }

    @Override
    public List<Local> listarTodos(){
        return localRepositoryImpl.findAll();
    }

    @Override
    public Local listarPorId(Long id) {
        return localRepositoryImpl.findyById(id);
    }

    @Override
    public Local salvar(Local local) {
        return localRepositoryImpl.save(local);
    }

    @Override
    public void excluir(Long id) {
        localRepositoryImpl.deleteById(id);
    }
}
