package entidades;

public class Main {
    public static void main(String[] args) {

        criarVeiculo();
        criarPessoa();

    }

    static void criarVeiculo(){
        Veiculo veiculo = new Veiculo("Chevrolet");
        veiculo.honk();

        Carro carro = new Carro();
        carro.modelo = "Corsa";
        carro.marca = "Chevrolet";
        carro.honk();
    }

    static  void criarPessoa(){
        Pessoa pessoa = new Pessoa();
        pessoa.nome = "Maria Eduarda Vieira da Costa";
        pessoa.email = "maria.costa@gmail.com";
        System.out.println(pessoa.toString());

        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.CPF = "117.754.559-47";
        pessoaFisica.nome = "José";
        pessoaFisica.email = "jose@gmail.com";
        System.out.println(pessoaFisica.toString());

    }

}