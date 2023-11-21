package com.agenda.dominio;

import java.util.ArrayList;
import java.util.List;

public class Compromisso {
    private Long id;
    private String descricao;
    Local local;
    List<Contato> contatos = new ArrayList<>();
    public Compromisso() {
    }
    public Compromisso(String descricao, Local local) {
        this.descricao = descricao;
        this.local = local;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
    @Override
    public String toString() {
        return "Compromisso{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", local=" + local +
                ", contatos=" + contatos +
                '}';
    }
}
