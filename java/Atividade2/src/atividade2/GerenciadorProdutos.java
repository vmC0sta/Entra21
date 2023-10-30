package atividade2;

import java.util.ArrayList;

public class GerenciadorProdutos {
    private ArrayList<Produto> listaProdutos = new ArrayList<>();
    private int proximoID = 1;

    public void inserirProduto(String descricao, double valorUnitario, double estoque) {
        Produto produto = new Produto(proximoID, descricao, valorUnitario, estoque);
        listaProdutos.add(produto);
        produto.exibir();
        proximoID++;
    }

    public void alterarProduto(int codigo, String descricao, double valorUnitario, double estoque) {
        if (codigo >= 1 && codigo <= listaProdutos.size()) {
            Produto produto = listaProdutos.get(codigo - 1);
            produto.alterar(descricao, valorUnitario, estoque);
            produto.exibir();
        } else {
            System.out.println("Esse produto não existe!");
        }
    }

    public void excluirProduto(int codigo) {
        if (codigo >= 1 && codigo <= listaProdutos.size()) {
            listaProdutos.remove(codigo - 1);
            System.out.println("Produto excluído com sucesso");
            for (Produto produto : listaProdutos) {
                produto.exibir();
            }
        } else {
            System.out.println("Esse produto não existe!");
        }
    }

    public void exibirProduto(int codigo) {
        if (codigo >= 1 && codigo <= listaProdutos.size()) {
            Produto produto = listaProdutos.get(codigo - 1);
            produto.exibir();
        } else {
            System.out.println("Esse produto não existe!");
        }
    }

    public void exibirTodosProdutos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Produtos cadastrados:");
            System.out.println();
            for (Produto produto : listaProdutos) {
                produto.exibir();
            }
        }
    }
}
