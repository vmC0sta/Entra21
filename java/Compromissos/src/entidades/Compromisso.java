package entidades;

import java.time.LocalDate;

public class Compromisso {

    private int id;
    private String descricao;
    private Local local;
    private LocalDate data;

    public Compromisso() {
        //
    }

    public Compromisso(int id, String descricao, Local local, LocalDate data) {
        this.id = id;
        this.descricao = descricao;
        this.local = local;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Compromisso{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", local=" + local +
                ", data=" + data +
                '}';
    }
}
