package classes;

public class Pessoa {

    private String cpf;

    public Pessoa(){
//
    }

    public Pessoa(String cpf){
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return cpf;
    }
}


