package atividades;

public class Retangulo {

    private double comprimento;
    private double largura;

    public void setMedidas(double comprimento, double largura){
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public void getMedidas(){
        System.out.println(largura);
        System.out.println(comprimento);;
    }

    public void area(){
        double resultado = comprimento * largura;
        System.out.println("Área: " + resultado);
        System.out.println();
    }

    public void perimetro(){
        double resultado = (comprimento * 2) + (largura * 2);
        System.out.println("Perímetro: " + resultado);
        System.out.println();
    }

}
