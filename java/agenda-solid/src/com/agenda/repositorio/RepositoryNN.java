package com.agenda.repositorio;

import com.agenda.dominio.Compromisso;

import java.util.List;

public interface RepositoryNN<T> extends Repository<T> {
    void associate(Long idA, Long idB);
    void deleteAssociate(Long idA, Long idB);

}
