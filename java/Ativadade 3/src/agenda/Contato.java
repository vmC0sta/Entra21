package agenda;

public class Contato {

    protected int id;
    protected String nome, fone, email;

    public Contato(){

    }

    public Contato(int id, String nome, String fone,String email){
        this.id = id;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }
    public String toString(){
        return  id + " " + nome + " | " + fone + " | " + email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
