function inserir(num) {
    var resultado = document.getElementById("resultado");
    var numeroAtual = resultado.innerHTML;

    if (numeroAtual === "0" && num !== ".") {
        resultado.innerHTML = num;
    } else {
        resultado.innerHTML += num;
    }
}


function apagar() {
    document.getElementById('resultado').innerHTML = 0
}

function limpar() {

    var resultado = document.getElementById('resultado');
    var numero = resultado.innerHTML;

    if (numero.length > 1) {
        numero = numero.slice(0, -1);
        resultado.innerHTML = numero;
    }
    else {
        resultado.innerHTML = 0
    }
}

function calcular() {

    var resultado = document.getElementById('resultado').innerHTML
    if (resultado) {
        document.getElementById('resultado').innerHTML = eval(resultado)
    }

}

function inversa() {

    numero = document.getElementById('resultado').innerHTML
    document.getElementById('resultado').innerHTML = "1 / " + numero

}


function aoQuadrado() {

    numero = document.getElementById('resultado').innerHTML
    document.getElementById('resultado').innerHTML = numero + " * " + numero

}

function raizQuadrada() {

    numero = document.getElementById('resultado').innerHTML

    document.getElementById('resultado').innerHTML = "Math.sqrt(" + numero + ")"

}
