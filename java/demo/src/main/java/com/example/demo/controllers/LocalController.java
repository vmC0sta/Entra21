package com.example.demo.controllers;

import com.example.demo.entidades.Local;
import com.example.demo.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/locais")
public class LocalController implements Controller<Local> {

    @Autowired
    LocalRepository localRepository;

    @PostMapping
    @Override
    public ResponseEntity<Local> salvar(@RequestBody Local local) {
        localRepository.save(local);
        return ResponseEntity.status(HttpStatus.CREATED).body(local);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Local>> consultar() {
        return ResponseEntity.status(HttpStatus.OK).body(localRepository.findAll());
    }

    @GetMapping("/{idlocal}")
    @Override
    public ResponseEntity<Object> consultar(@PathVariable("idlocal") Long id) {
        Optional<Local> optionalLocal = localRepository.findById(id);
        try{
            Local localX = optionalLocal.get();
            return ResponseEntity.status(HttpStatus.OK).body(localX);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Local não encontrado");
        }
    }

    @PutMapping("/{idlocal}")
    @Override
    public ResponseEntity<Object> alterar(@PathVariable("idlocal") Long id,@RequestBody Local local) {
        Optional<Local> optionalLocal = localRepository.findById(id);
        try {
            Local localX = optionalLocal.get();
            localX.setNome(local.getNome());
            localX.setRua(local.getRua());
            localX.setNumero(local.getNumero());
            localX.setBairro(local.getBairro());
            localX.setCidade(local.getCidade());
            localX.setEstado(local.getEstado());
            localX.setCep(local.getCep());
            localRepository.save(localX);
            return ResponseEntity.status(HttpStatus.OK).body(localX);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Local não encontrado");
        }
    }

    @DeleteMapping("/{idlocal}")
    @Override
    public ResponseEntity<Object> excluir(@PathVariable("idlocal") Long id) {
        Optional<Local> optionalLocal = localRepository.findById(id);
        try{
            Local localX = optionalLocal.get();
            localRepository.delete(localX);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
