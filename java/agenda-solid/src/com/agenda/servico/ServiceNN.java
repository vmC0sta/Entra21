package com.agenda.servico;

public interface ServiceNN<T> extends Service<T>{
    void associarEntidades(Long idCompromisso, Long idContato);
    void excluirAssociate(Long idCompromisso, Long idContato);
}
