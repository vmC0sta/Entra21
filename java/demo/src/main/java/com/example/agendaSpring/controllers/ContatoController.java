package com.example.agendaSpring.controllers;

import com.example.agendaSpring.entidades.Contato;
import com.example.agendaSpring.repositories.ContatoRepository;
import com.example.agendaSpring.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/contatos")
public class ContatoController implements Controller<Contato> {

    ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Contato> salvar(@RequestBody Contato contato) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.salvar(contato));
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Object> alterar(@PathVariable("id") Long id, @RequestBody Contato contato) {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.alterar(id,contato));
    }

    @GetMapping("/consultar")
    public ResponseEntity<List<Contato>> consultar() {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.consultar());
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<Object> consultar(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.consultar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
        contatoService.excluir(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

