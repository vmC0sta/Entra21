package com.agenda.dominio;

public class Local {
    private Long id;
    private String descricao;
    public Local() {
    }
    public Local(String descricao) {
        this.descricao = descricao;
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
    @Override
    public String toString() {
        return "Local{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
