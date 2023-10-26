package atividades;

public class Main {
    public static void main(String[] args) {

        Carro carro = new Carro();
        carro.marca = "Volkswagem";
        carro.modelo = "Jetta";
        carro.cor = "Branco";
        carro.placa = "ABC-1234";
        carro.display();

        Calculadora calculo1 = new Calculadora();
        calculo1.numero1 = 5;
        calculo1.numero2 = 5;
        calculo1.somar();
        calculo1.subtrair();
        calculo1.multiplicar();
        calculo1.dividir();

        Retangulo retangulo1 = new Retangulo();
        retangulo1.largura = 4;
        retangulo1.comprimento = 6;
        retangulo1.area();
        retangulo1.perimetro();

        Produto produto1 = new Produto();
        produto1.codigo = "1234";
        produto1.descricao = "Microfone KNUP";
        produto1.valorUnitario = 139.23;
        produto1.estoque = 25;
        produto1.aplicarAcrescimo(10);
        produto1.aplicarDesconto(100);
        produto1.exibirEstoque();

    }
}

