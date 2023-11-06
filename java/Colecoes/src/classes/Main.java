package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
//       firstActivity();
//       secondActivity();
       thirdActiviry();
    }

    static void firstActivity(){
        HashMap<String, Pessoa> pessoas = new HashMap<String, Pessoa>();
        Pessoa pessoa;
        pessoas.put("Maria", new Pessoa("117-754-559-47"));

        for(String i : pessoas.keySet()){
            System.out.println("key: " +  i + "\nvalue: " + pessoas.get(i).toString());
        }
    }

    static void secondActivity(){
        HashSet<String> produtos = new HashSet<String>();

        produtos.add("Nome1");
        produtos.add("Nome1");
        produtos.add("Nome2");

        for (String i : produtos){
            System.out.println(i);
        }
    }

    static void thirdActiviry(){

        ArrayList<Produto> produtosDoces = new ArrayList<Produto>();
        produtosDoces.add(new Produto("Bala",2,5));
        produtosDoces.add(new Produto("Brigadeiro",19,3));

        ArrayList<Produto> produtosSalgados = new ArrayList<Produto>();
        produtosSalgados.add(new Produto("Salgadinho",5,10));
        produtosSalgados.add(new Produto("Coxinha",10,4 ));

        HashMap<String, ArrayList>  produtos = new HashMap<String, ArrayList>();
        produtos.put("Doce",produtosDoces);
        produtos.put("Salgado", produtosSalgados);

        for (String i : produtos.keySet()){
            System.out.println("Categoria: " +  i + "\nProdutos: \n" + produtos.get(i));
            System.out.println();
        }

    }

}