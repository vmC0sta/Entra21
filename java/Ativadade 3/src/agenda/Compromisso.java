package agenda;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Compromisso {
    protected int id;
    protected String descricao;
    protected Date data;
    protected Local local;
    ArrayList<Contato> contatos = new ArrayList<Contato>();

    public Compromisso(){

    }
    public Compromisso(int id, String descricao, Date data,Local local){
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.local = local;
    }

    public void addContatoLista(Contato contato){
        contatos.add(contato);
        System.out.println("Contato adicionado a lista");
    }

    public String toString() {
        return  id + " " + descricao + " | " + data + " | " + local + " | " + contatos + " | ";
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

}
