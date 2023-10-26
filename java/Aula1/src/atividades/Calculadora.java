package atividades;

public class Calculadora {
    double numero1;
    double numero2;

    public void somar(){
        double resultado = numero1 + numero2;
        System.out.println("Soma: " + resultado);
        System.out.println();
    }
    public void subtrair(){
        double resultado = numero1 - numero2;
        System.out.println("Subtração: " + resultado);
        System.out.println();
    }

    public void multiplicar(){
        double resultado = numero1 * numero2;
        System.out.println("Multiplicação: " + resultado);
        System.out.println();
    }

    public void dividir(){
        double resultado = numero1 / numero2;
        System.out.println("Dividir: " + resultado);
        System.out.println();
    }


}
