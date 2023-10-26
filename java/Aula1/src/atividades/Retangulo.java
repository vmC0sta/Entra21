package atividades;

public class Retangulo {

    double comprimento;
    double largura;

    public void area(){
        double resultado = comprimento * largura;
        System.out.println("Área: " + resultado);
        System.out.println();
    }

    public void perimetro(){
        double resultado = (comprimento + comprimento) + (largura+largura);
        System.out.println("Perímetro: " + resultado);
        System.out.println();
    }

}
