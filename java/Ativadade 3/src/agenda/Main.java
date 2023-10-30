package agenda;

import java.util.Date;

public class Main {
    public static void main(String[] args) {


        Local local = new Local();
        local.setId(1);
        local.setNome("Clube XV");
        local.setRua("Rua XV Novembro");
        local.setNumero(305);
        System.out.println(local.toString());

        Contato contato1 = new Contato();
        contato1.setId(1);
        contato1.setNome("Maria");
        contato1.setFone("(47) 99607-5616");
        contato1.setEmail("maria@gmail.com");
        System.out.println(contato1.toString());
        
        Contato contato2 = new Contato();
        contato2.setId(2);
        contato2.setNome("José");
        contato2.setFone("(47) 99343-5422");
        contato2.setEmail("jose@gmail.com");
        System.out.println(contato2.toString());

        Date data = new Date(2023-1900,10,10);
        Compromisso compromisso = new Compromisso();
        compromisso.setId(1);
        compromisso.setDescricao("Jogar bocha");
        compromisso.setData(data);
        compromisso.setLocal(local);
        compromisso.addContatoLista(contato1);
        compromisso.addContatoLista(contato2);

        System.out.println(compromisso.toString());

    }
}