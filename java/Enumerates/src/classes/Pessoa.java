package classes;

import enums.EnumTipoPessoa;

public class Pessoa {
    int id;
    String nome;
    EnumTipoPessoa tipo; /* Física, Júridica */

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
