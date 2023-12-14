package com.example.agendaSpring.services;

import com.example.agendaSpring.Enum.Status;
import com.example.agendaSpring.entidades.Compromisso;
import com.example.agendaSpring.entidades.Contato;
import com.example.agendaSpring.exceptions.ValidaCampos;
import com.example.agendaSpring.repositories.CompromissoRepository;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
public class CompromissoService implements Service<Compromisso> {

    CompromissoRepository compromissoRepository;
    ModelMapper modelMapper;

    public CompromissoService(CompromissoRepository compromissoRepository, ModelMapper modelMapper) {
        this.compromissoRepository = compromissoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Compromisso salvar(Compromisso compromisso) {
        validaCampos(compromisso);
        return compromissoRepository.save(compromisso);
    }

    @Override
    public List<Compromisso> consultar() {
        return compromissoRepository.findAll();
    }

    @Override
    public Compromisso consultar(Long id) {
        Optional<Compromisso> optionalCompromisso =  compromissoRepository.findById(id);
        Compromisso compromisso = optionalCompromisso.orElseThrow(() -> new RuntimeException("O compromisso não foi encontrado"));
        return compromisso;
    }

    @Override
    public Compromisso alterar(Long id, Compromisso compromisso) {
        Compromisso compromissoExistente = consultar(id);
        validaCampos(compromisso);
        compromisso.setId(compromissoExistente.getId());
        modelMapper.map(compromisso,compromissoExistente);
        return compromissoRepository.save(compromissoExistente);
    }

    public Compromisso atualizarStatus(Long id, Status status) {
        Compromisso compromisso = compromissoRepository.findById(id).orElseThrow(() -> new RuntimeException("Entidade não encontrada com o ID: " + id));
        compromisso.setStatus(status);
        return compromissoRepository.save(compromisso);
    }

    public List<Compromisso> consultarPorContato(Contato contato){
        return compromissoRepository.findAllByContatos(contato);
    }

    @Override
    public void excluir(Long id) {
        Compromisso compromisso = consultar(id);
        compromissoRepository.delete(compromisso);
    }

    public List<Compromisso> consultarPorIntervaloDeData(Date dataInicio, Date dataFim){
        return compromissoRepository.findAllByEntreDatas(dataInicio,dataFim);
    }

    private void validaCampos(Compromisso compromisso) {
        if (compromisso.getDescricao() == null || compromisso.getDescricao().isEmpty()) {
            throw new ValidaCampos("A descrição deve ser informada");
        }
        if (compromisso.getData() == null || compromisso.getData().equals("")) {
            throw new ValidaCampos("A data deve ser informada");
        }
        if (compromisso.getHora() == null || compromisso.getHora().equals("")) {
            throw new ValidaCampos("A hora deve ser informada");
        }
        if (compromisso.getLocal() == null || compromisso.getLocal().equals("")){
            throw new ValidaCampos("O local deve ser informado");
        }
        if (compromisso.getContatos() == null || compromisso.getContatos().isEmpty()){
            throw new ValidaCampos("Um contato deve ser informado");
        }
        if (compromisso.getStatus() == null || compromisso.getStatus().equals("")){
            throw new  ValidaCampos("O status deve ser informado");
        }
    }
}
