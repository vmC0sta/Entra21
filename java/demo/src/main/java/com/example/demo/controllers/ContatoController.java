package com.example.demo.controllers;

import com.example.demo.entidades.Contato;
import com.example.demo.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contatos")
public class ContatoController implements Controller<Contato> {

    @Autowired
    ContatoRepository contatoRepository;

    @PostMapping
    public ResponseEntity<Contato> salvar(@RequestBody Contato contato) {
        contatoRepository.save(contato);
        return ResponseEntity.status(HttpStatus.CREATED).body(contato);
    }

    @PutMapping("/{idcontato}")
    public ResponseEntity<Object> alterar(@PathVariable("idcontato") Long idcontato, @RequestBody Contato contato) {
        Optional<Contato> optionalContato = contatoRepository.findById(idcontato);
        try {
            Contato contatoX = optionalContato.get();
            contatoX.setNome(contato.getNome());
            contatoX.setEmail(contato.getEmail());
            contatoX.setFone(contato.getFone());
            contatoRepository.save(contatoX);
            return ResponseEntity.status(HttpStatus.OK).body(contatoX);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado");
        }
    }

    @GetMapping
    public ResponseEntity<List<Contato>> consultar() {
        return ResponseEntity.status(HttpStatus.OK).body(contatoRepository.findAll());
    }

    @GetMapping("/{idcontato}")
    public ResponseEntity<Object> consultar(@PathVariable("idcontato") Long idcontato) {
        Optional<Contato> optionalContato = contatoRepository.findById(idcontato);
        try {
            Contato contatoX = optionalContato.get();
            return ResponseEntity.status(HttpStatus.OK).body(contatoX);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado");
        }

    }

    @DeleteMapping("/{idcontato}")
    public ResponseEntity<Object> excluir(@PathVariable("idcontato") Long idcontato) {
        Optional<Contato> optionalContato = contatoRepository.findById(idcontato);
        try {
            Contato contatoX = optionalContato.get();
            contatoRepository.delete(contatoX);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

