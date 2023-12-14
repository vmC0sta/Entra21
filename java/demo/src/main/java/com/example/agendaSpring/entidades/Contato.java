package com.example.agendaSpring.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_contato")
public class Contato {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String nome;
    @Column(length = 100)
    private String email;
    @Column(length = 15)
    private String fone;

    @ManyToMany(mappedBy = "contatos")
    private List<Compromisso> compromissos;
    public Contato() {
    }
    public Contato(Long id, String nome, String email, String fone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.fone = fone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", fone='" + fone + '\'' +
                '}';
    }
}
