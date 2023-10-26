package atividades;

public class Produto {
    String codigo;
    String descricao;
    double estoque;
    double valorUnitario;

    public void aplicarDesconto(double desconto){
        double produtoDesconto = valorUnitario - desconto;
        System.out.println("Valor do produto: " + valorUnitario);
        System.out.println("Desconto: " + desconto);
        System.out.println("Valor do produto com desconto: " + produtoDesconto);
        System.out.println();
    }

    public void aplicarAcrescimo(double acrescimo){
        double produtoAcrescimo = valorUnitario + acrescimo;
        System.out.println("Valor do produto: " + valorUnitario);
        System.out.println("Acréscimo: " + acrescimo);
        System.out.println("Valor do produto com acréscimo: " + produtoAcrescimo);
        System.out.println();
    }

    public void exibirEstoque(){
        System.out.println("Quantidade total: " + estoque);
        System.out.println("Valor total: " + estoque * valorUnitario);
        System.out.println();
    }


}
