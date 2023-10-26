package atividades;

public class Carro {
    private String placa;
    private String marca;
    private String modelo;
    private String cor;

    public void setCarro(String placa, String marca, String modelo, String cor){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    public void getCarro(){
        System.out.println(marca);
        System.out.println(modelo);
        System.out.println(cor);
        System.out.println(placa);
        System.out.println();
    }
}

