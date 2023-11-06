package classes;

public class Produto {
    private String descricao;
    double quantidade;
    double valor;

    public Produto(String descricao, double quantidade, double valor) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "\nDescricao: " + descricao +
                "\nQuantidade: " + quantidade +
                "\nValor: " + valor + "\n";
    }
}
