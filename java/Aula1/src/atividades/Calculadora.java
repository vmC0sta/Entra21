package atividades;

public class Calculadora {
    private double numero1;
    private double numero2;

    public void setNumeros(double numero1, double numero2){
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public void somar(){
        double resultado = numero1 + numero2;
        System.out.println("Soma: " + resultado);
    }
    public void subtrair(){
        double resultado = numero1 - numero2;
        System.out.println("Subtração: " + resultado);
    }

    public void multiplicar(){
        double resultado = numero1 * numero2;
        System.out.println("Multiplicação: " + resultado);
    }

    public void dividir(){
        double resultado = numero1 / numero2;
        System.out.println("Dividir: " + resultado);
    }

}
