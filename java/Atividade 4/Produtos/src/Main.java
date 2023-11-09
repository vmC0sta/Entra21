import product.Product;
import util.ManageDB;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ManageDB manageDB = new ManageDB();
        ArrayList<Product> listProducts = manageDB.fetchData();

        while (true) {
            System.out.println("===============================");
            System.out.println("1 - INSERIR PRODUTO            ");
            System.out.println("2 - ALTERAR PRODUTO            ");
            System.out.println("3 - EXCLUIR PRODUTO            ");
            System.out.println("4 - EXIBIR UM PRODUTO          ");
            System.out.println("5 - EXIBIR TODOS OS PRODUTOS   ");
            System.out.println("6 - SAIR                       ");
            System.out.println("===============================");
            int opcao = new Scanner(System.in).nextInt();

            listProducts = manageDB.fetchData();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a descrição do produto: ");
                    String description = new Scanner(System.in).nextLine();
                    System.out.println("Digite a quantidade do produto");
                    double quantity = new Scanner(System.in).nextDouble();
                    System.out.println("Digite o valor unitário do produto");
                    double value = new Scanner(System.in).nextDouble();
                    manageDB.insert(description,quantity,value);
                    break;
                case 2:
                    System.out.println("Digite o código do produto a ser alterado: ");
                    int id = new Scanner(System.in).nextInt();
                    System.out.println("Digite a descrição do produto: ");
                    description = new Scanner(System.in).nextLine();
                    System.out.println("Digite o valor unitário do produto");
                    value = new Scanner(System.in).nextDouble();
                    System.out.println("Digite a quantidade do produto");
                    quantity = new Scanner(System.in).nextDouble();
                    manageDB.update(id, description, value, quantity);
                    break;
                case 3:
                    System.out.println("Digite o código do produto a ser excluído: ");
                    id = new Scanner(System.in).nextInt();
                    manageDB.delete(id);
                    break;
                case 4:
                    System.out.println("Digite o código do produto: ");
                    id = new Scanner(System.in).nextInt();
                    manageDB.query(listProducts,id);
                    break;
                case 5:
                    listProducts = manageDB.fetchData();
                    manageDB.queryAll(listProducts);
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
