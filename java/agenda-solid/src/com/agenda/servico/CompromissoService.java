package com.agenda.servico;

import com.agenda.dominio.Compromisso;
import com.agenda.repositorio.CompromissoRepositoyImpl;

import java.sql.SQLException;
import java.util.List;

public class CompromissoService implements ServiceNN<Compromisso>{
    private CompromissoRepositoyImpl compromissoRepositoy;
    public CompromissoService(CompromissoRepositoyImpl compromissoRepositoy){
        this.compromissoRepositoy = compromissoRepositoy;
    }
    @Override
    public List<Compromisso> listarTodos() throws SQLException {
        return compromissoRepositoy.findAll();
    }

    @Override
    public Compromisso listarPorId(Long id) throws SQLException {
        return  compromissoRepositoy.findyById(id);
    }

    @Override
    public Compromisso salvar(Compromisso compromisso) {
        return compromissoRepositoy.save(compromisso);
    }
    @Override
    public void excluir(Long id) {
        compromissoRepositoy.deleteById(id);
    }

    @Override
    public void associarEntidades(Long idCompromisso,Long idContato) {
        compromissoRepositoy.associate(idCompromisso,idContato);
    }

    @Override
    public void excluirAssociate(Long idCompromisso, Long idContato) {
        compromissoRepositoy.deleteAssociate(idCompromisso,idContato);
    }
}
