package classes;

import enums.EnumTipoPessoa;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       Pessoa pessoaFisica = new Pessoa();
       pessoaFisica.id = 1;
       pessoaFisica.nome = "Maria Eduarda";
       pessoaFisica.tipo = EnumTipoPessoa.FISICA;

       Pessoa pessoaJuridica = new Pessoa();
       pessoaJuridica.tipo = EnumTipoPessoa.JURIDICA;

       System.out.println(pessoaFisica.toString());
       System.out.println(pessoaJuridica.toString());

    }
}