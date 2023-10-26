package atividades;

public class Main {
    public static void main(String[] args) {

        Carro carro = new Carro();
        carro.setCarro("ABC-1234","Volkswagem", "Jetta","Branco");
        carro.getCarro();

        Calculadora calculo1 = new Calculadora();
        calculo1.setNumeros(10,2);
        calculo1.somar();
        calculo1.subtrair();
        calculo1.multiplicar();
        calculo1.dividir();

        Retangulo retangulo = new Retangulo();
        retangulo.setMedidas(4,5);
        retangulo.area();
        retangulo.perimetro();

        Produto produto = new Produto();
        produto.setProduto("1234","Microfone KNUP", 25, 140);
        produto.getProduto();
        produto.aplicarAcrescimo(10);
        produto.aplicarDesconto(100);
        produto.exibirEstoque();

    }
}

