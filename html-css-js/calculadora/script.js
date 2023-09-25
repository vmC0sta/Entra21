const getHours = () => {
    const relogio = document.getElementById("clock");
    const data = new Date();
    const horas = data.getHours();
    const minutos = data.getMinutes();
    const segundos = data.getSeconds();
    relogio.innerHTML = `${horas}:${minutos}:${segundos}`;
}


setInterval(getHours, 1000);

function inserir(num) {
    var resultado = document.getElementById("resultado");
    var numeroAtual = resultado.innerHTML;

    if (numeroAtual === "0" && num !== ".") {
        resultado.innerHTML = num;
    } else {
        resultado.innerHTML += num;
    }
}


function limpar() {
    document.getElementById('resultado').innerHTML = 0
}

function apagar() {

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

function umX() {

    numero = document.getElementById('resultado').innerHTML
    document.getElementById('resultado').innerHTML = "1 / " + numero

}


function calcular() {

    var resultado = document.getElementById('resultado').innerHTML
    if (resultado) {
        document.getElementById('resultado').innerHTML = eval(resultado)
    }

}

function aoQuadrado() {

    numero = document.getElementById('resultado').innerHTML
    document.getElementById('resultado').innerHTML = numero + " * " + numero

}

function raizQuadrada() {

    numero = document.getElementById('resultado').innerHTML

    document.getElementById('resultado').innerHTML = "Math.sqrt(" + numero + ")"

}