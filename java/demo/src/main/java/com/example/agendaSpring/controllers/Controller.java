package com.example.agendaSpring.controllers;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Controller<T> {

        public ResponseEntity<T> salvar(T t);

        public ResponseEntity<List<T>> consultar();

        public ResponseEntity<Object> consultar(Long id);

        public ResponseEntity<Object> alterar(Long id, T t);

        public ResponseEntity<Object> excluir(Long id);

}
