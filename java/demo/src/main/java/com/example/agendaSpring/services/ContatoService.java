package com.example.agendaSpring.services;

import com.example.agendaSpring.entidades.Contato;
import com.example.agendaSpring.exceptions.ValidaCampoExistente;
import com.example.agendaSpring.exceptions.RecursoNaoEncontrado;
import com.example.agendaSpring.exceptions.ValidaCampos;
import com.example.agendaSpring.repositories.ContatoRepository;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ContatoService implements Service<Contato> {
    ContatoRepository contatoRepository;
    ModelMapper modelMapper;
    public ContatoService(ContatoRepository contatoRepository, ModelMapper modelMapper) {
        this.contatoRepository = contatoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Contato salvar(Contato contato) {
            validaCampos(contato);
            return contatoRepository.save(contato);
    }

    @Override
    public List<Contato> consultar() {
        return contatoRepository.findAll();
    }

    @Override
    public Contato consultar(Long id) {
        Optional<Contato> optionalContato = contatoRepository.findById(id);
        Contato contato = optionalContato.orElseThrow(() -> new RecursoNaoEncontrado("Contato não encontrado."));
        return contato;
    }

    @Override
    public Contato alterar(Long id, Contato contato) {
        Contato contatoExistente = consultar(id);
        validaCampos(contato);
        contato.setId(contatoExistente.getId());
        modelMapper.map(contato, contatoExistente);
        return contatoRepository.save(contatoExistente);
    }

    @Override
    public void excluir(Long id) {
        Contato contato = consultar(id);
        contatoRepository.delete(contato);
    }

    private void validaCampos(Contato contato) {
        if (contato.getNome() == null || contato.getNome().isEmpty()) {
            throw new ValidaCampos("O nome deve ser informado");
        }
        if (contato.getEmail() == null || contato.getEmail().isEmpty()) {
            throw new ValidaCampos("O email deve ser informado");
        }
        if (contato.getFone() == null || contato.getFone().isEmpty()) {
            throw new ValidaCampos("O fone deve ser informado");
        }
        if (contatoRepository.existsByNome(contato.getNome())){
            throw new ValidaCampoExistente("O nome já existe");
        }
        if (contatoRepository.existsByEmail(contato.getEmail())){
            throw new ValidaCampoExistente("O email já existe");
        }
        if (contatoRepository.existsByFone(contato.getFone())){
            throw new ValidaCampoExistente("O fone já existe");
        }
    }

}
