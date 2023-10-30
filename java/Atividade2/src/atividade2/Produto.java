package atividade2;

public class Produto {
    private int ID;
    private String descricao;
    private double valorUnitario;
    private double estoque;

    public Produto(int ID, String descricao, double valorUnitario, double estoque) {
        this.ID = ID;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.estoque = estoque;
    }

    public void exibir() {
        System.out.println("Código: " + ID);
        System.out.println("Descrição: " + descricao);
        System.out.println("Valor Unitário: " + valorUnitario);
        System.out.println("Estoque: " + estoque);
        System.out.println("===============================");
    }

    public void alterar(String descricao, double valorUnitario, double estoque) {
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.estoque = estoque;
    }
}
