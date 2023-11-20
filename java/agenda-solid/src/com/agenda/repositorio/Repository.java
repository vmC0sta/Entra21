package com.agenda.repositorio;

import com.agenda.dominio.Contato;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    T save(T t);
    List<T> findAll() throws SQLException;
    T findyById(Long id);
    void deleteById(Long id);
}
