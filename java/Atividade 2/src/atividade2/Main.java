package atividade2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("===============================");
            System.out.println("1 - INSERIR PRODUTO            ");
            System.out.println("2 - ALTERAR PRODUTO            ");
            System.out.println("3 - EXCLUIR PRODUTO            ");
            System.out.println("4 - EXIBIR UM PRODUTO          ");
            System.out.println("5 - EXIBIR TODOS OS PRODUTOS   ");
            System.out.println("6 - SAIR                       ");
            System.out.println("===============================");
            System.out.println();
            int opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a descrição do produto: ");
                    String descricao = scan.next();
                    System.out.println("Digite o valor unitário do produto");
                    double valorUnitario = scan.nextDouble();
                    System.out.println("Digite o estoque do produto");
                    double estoque = scan.nextDouble();
                    gerenciador.inserirProduto(descricao, valorUnitario, estoque);
                    break;
                case 2:
                    System.out.println("Digite o código do produto a ser alterado: ");
                    int codigo = scan.nextInt();
                    System.out.println("Digite a descrição do produto: ");
                    descricao = scan.next();
                    System.out.println("Digite o valor unitário do produto");
                    valorUnitario = scan.nextDouble();
                    System.out.println("Digite o estoque do produto");
                    estoque = scan.nextDouble();
                    gerenciador.alterarProduto(codigo, descricao, valorUnitario, estoque);
                    break;
                case 3:
                    System.out.println("Digite o código do produto a ser excluído: ");
                    codigo = scan.nextInt();
                    gerenciador.excluirProduto(codigo);
                    break;
                case 4:
                    System.out.println("Digite o código do produto: ");
                    codigo = scan.nextInt();
                    gerenciador.exibirProduto(codigo);
                    break;
                case 5:
                    gerenciador.exibirTodosProdutos();
                    break;
                case 6:
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
