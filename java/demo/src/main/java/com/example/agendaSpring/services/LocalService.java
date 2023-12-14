package com.example.agendaSpring.services;

import com.example.agendaSpring.entidades.Local;
import com.example.agendaSpring.exceptions.RecursoNaoEncontrado;
import com.example.agendaSpring.exceptions.ValidaCampos;
import com.example.agendaSpring.repositories.LocalRepository;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class LocalService implements Service<Local> {

    LocalRepository localRepository;
    ModelMapper modelMapper;

    public LocalService(LocalRepository localRepository, ModelMapper modelMapper) {
        this.localRepository = localRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Local salvar(Local local) {
        validaCampos(local);
        return localRepository.save(local);
    }

    @Override
    public List<Local> consultar() {
        return localRepository.findAll();
    }

    @Override
    public Local consultar(Long id) {
        Optional<Local> optionalLocal = localRepository.findById(id);
        Local local = optionalLocal.orElseThrow(() -> new RecursoNaoEncontrado("O local não foi encontrado"));
        return local;
    }

    @Override
    public Local alterar(Long id, Local local) {
        Local localExistente = consultar(id);
        local.setId(localExistente.getId());
        modelMapper.map(local,localExistente);
        return localRepository.save(localExistente);
    }

    @Override
    public void excluir(Long id) {
        Local local = consultar(id);
        localRepository.delete(local);
    }

    private void validaCampos(Local local) {
        if (local.getNome() == null || local.getNome().isEmpty()) {
            throw new ValidaCampos("O nome deve ser informado");
        }
        if (local.getRua() == null || local.getRua().isEmpty()) {
            throw new ValidaCampos("A rua deve ser informada");
        }
        if (local.getNumero() == null || local.getNumero().isEmpty()) {
            throw new ValidaCampos("O número deve ser informado");
        }
        if (local.getBairro() == null || local.getBairro().isEmpty()){
            throw new ValidaCampos(("O bairro deve ser informado"));
        }
        if (local.getCidade() == null || local.getCidade().isEmpty()){
            throw new ValidaCampos("A cidade deve ser informada");
        }
        if (local.getEstado() == null || local.getEstado().isEmpty()){
            throw new ValidaCampos("O estado deve ser informado");
        }
        if (local.getCep() == null || local.getCep().isEmpty()){
            throw new ValidaCampos("O CEP deve ser informado");
        }
    }

}
