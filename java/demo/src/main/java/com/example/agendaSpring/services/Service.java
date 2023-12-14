package com.example.agendaSpring.services;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Service<T> {

    public T salvar(T t);

    public List<T>  consultar();

    public T consultar(Long id);

    public T alterar(Long id, T t);

    public void excluir(Long id);

}
