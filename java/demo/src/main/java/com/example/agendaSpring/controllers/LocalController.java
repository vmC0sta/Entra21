package com.example.agendaSpring.controllers;

import com.example.agendaSpring.entidades.Local;
import com.example.agendaSpring.repositories.LocalRepository;
import com.example.agendaSpring.services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/locais")
public class LocalController implements Controller<Local> {

    LocalService localService;

    public LocalController(LocalService localService) {
        this.localService = localService;
    }

    @PostMapping("/cadastrar")
    @Override
    public ResponseEntity<Local> salvar(@RequestBody Local local) {
       return ResponseEntity.status(HttpStatus.CREATED).body(localService.salvar(local));
    }

    @GetMapping("/consultar")
    @Override
    public ResponseEntity<List<Local>> consultar() {
        return ResponseEntity.status(HttpStatus.OK).body(localService.consultar());
    }

    @GetMapping("/consultar/{id}")
    @Override
    public ResponseEntity<Object> consultar(@PathVariable("id") Long id) {
      return ResponseEntity.status(HttpStatus.OK).body(localService.consultar(id));
    }

    @PutMapping("/alterar/{id}")
    @Override
    public ResponseEntity<Object> alterar(@PathVariable("id") Long id,@RequestBody Local local) {
        return ResponseEntity.status(HttpStatus.OK).body(localService.alterar(id,local));
    }

    @DeleteMapping("/excluir/{id}")
    @Override
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
        localService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
