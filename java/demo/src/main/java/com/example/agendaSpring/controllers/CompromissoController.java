package com.example.agendaSpring.controllers;

import com.example.agendaSpring.Enum.Status;
import com.example.agendaSpring.entidades.Compromisso;
import com.example.agendaSpring.entidades.Contato;
import com.example.agendaSpring.services.CompromissoService;
import com.example.agendaSpring.services.ContatoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compromissos")
public class CompromissoController implements Controller<Compromisso> {
    CompromissoService compromissoService;
    ContatoService contatoService;

    public CompromissoController(CompromissoService compromissoService, ContatoService contatoService) {
        this.compromissoService = compromissoService;
        this.contatoService = contatoService;
    }

    @Override
    @PostMapping("/cadastrar")
    public ResponseEntity<Compromisso> salvar(@RequestBody Compromisso compromisso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(compromissoService.salvar(compromisso));
    }

    @Override
    @GetMapping("/consultar")
    public ResponseEntity<List<Compromisso>> consultar() {
        return ResponseEntity.status(HttpStatus.OK).body(compromissoService.consultar());
    }


    @Override
    @GetMapping("/consultar/{id}")
    public ResponseEntity<Object> consultar(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(compromissoService.consultar(id));
    }

    @Override
    @PutMapping("/alterar/{id}")
    public ResponseEntity<Object> alterar(@PathVariable("id") Long id, @RequestBody Compromisso compromisso) {
        return ResponseEntity.status(HttpStatus.OK).body(compromissoService.alterar(id, compromisso));
    }

    @Override
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
        compromissoService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/contato")
    public ResponseEntity<List<Compromisso>> getAllByContato(@RequestParam("contato") Long id){
        Contato contato =  contatoService.consultar(id);
        return ResponseEntity.status(HttpStatus.OK).body(compromissoService.consultarPorContato(contato));
    }

    @PutMapping("/atualizarStatus/{id}")
    public ResponseEntity<Object> atualizarStatus(@PathVariable("id") Long id, @RequestBody Compromisso compromisso){
        return ResponseEntity.status(HttpStatus.OK).body(compromissoService.atualizarStatus(id,compromisso.getStatus()));
    }

    @GetMapping("/intervalo-data")
    public ResponseEntity<List<Compromisso>> getAllByIntervaloData(
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date dataInicio,
            @RequestParam  @DateTimeFormat(pattern = "dd-MM-yyyy") Date dataFim){
        return ResponseEntity.status(HttpStatus.OK).body(compromissoService.consultarPorIntervaloDeData(dataInicio, dataFim));
    }

}
