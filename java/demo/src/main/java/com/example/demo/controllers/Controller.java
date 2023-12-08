package com.example.demo.controllers;

import com.example.demo.entidades.Contato;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface Controller<T> {

        public ResponseEntity<T> salvar(T t);

        public ResponseEntity<List<T>> consultar();

        public ResponseEntity<Object> consultar(Long id);

        public ResponseEntity<Object> alterar(Long id, T t);

        public ResponseEntity<Object> excluir(Long id);

}
