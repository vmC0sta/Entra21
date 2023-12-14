package com.example.agendaSpring.entidades;

import com.example.agendaSpring.Enum.Status;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_compromisso")
public class Compromisso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String descricao;
    @Temporal(TemporalType.DATE)
    @Column
    private Date data;
    @Temporal(TemporalType.TIME)
    @Column
    private Time hora;
    @ManyToOne
    private Local local;
    @ManyToMany
    @JoinTable(
            name = "compromisso_contato",
            joinColumns = @JoinColumn(name = "compromisso_id"),
            inverseJoinColumns = @JoinColumn(name = "contato_id")
    )
    private Set<Contato> contatos = new HashSet<>();

    private Status status = Status.ABERTO;

    public Compromisso() {
    }

    public Compromisso(Long id, String descricao, Date data, Time hora, Local local, Set<Contato> contatos, Status status) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.local = local;
        this.contatos = contatos;
        this.status = status;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Set<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(Set<Contato> contatos) {
        this.contatos = contatos;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Compromisso{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", hora=" + hora +
                ", local=" + local +
                ", contatos=" + contatos +
                ", status=" + status +
                '}';
    }
}
