package agenda;

public class Local {

    protected int id,numero;
    protected String nome,rua;

    public Local() {

    }
    public Local(int id,String nome, String rua,int numero){
        this.id = id;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
    }

    public String toString(){
        return  id + " " + nome + " | " + rua + " | " + numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }


}
