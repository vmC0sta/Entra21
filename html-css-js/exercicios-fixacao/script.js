var numeros = []

function inserirNumero() {

    numero = document.getElementById('inputNumber').value

    var input = document.getElementById('inputNumber')
    var p = document.getElementsByTagName('p')[0];

    if (!ehNumero(numero)) {

        p.innerHTML = '<strong>Digite um número válido!</strong>'
        p.style.display = 'flex'
        p.style.color = 'red'
        input.style.border = 'red solid 2px'
        return
    }

    if(existeNumero(numero)){
        p.innerHTML = '<strong>O número já existe no array!</strong>'
        p.style.display = 'flex'
        p.style.color = 'rgb(255, 174, 0)'
        input.style.border = 'rgb(255, 174, 0) solid 2px'
        return
    }



    numeros.push(parseFloat(numero));

    p.innerHTML = '<strong>Número inserido com sucesso!</strong>'
    p.style.display = 'flex'
    p.style.color = 'green'
    input.style.border = 'green solid 2px'



    document.getElementById('inputNumber').value = ''

}

function exibirArray() {

    arrayCrescente(numeros)

    lista = document.createElement('ul')
    lista.className = 'list-group text-start'

    for (let i = 0; i < numeros.length; i++) {

        item = document.createElement('li')

        item.className = 'list-group-item mt-4'
        item.textContent = numeros[i]

        lista.appendChild(item)
    }

    document.getElementById('arrays').innerHTML = '';
    document.getElementById('arrays').appendChild(lista);


}

function limpar() {

    numeros = []
    document.getElementById('arrays').innerHTML = ''
}

function arrayCrescente(array) {
    array.sort(function(a, b) {
        return a - b;
    });
}

function existeNumero(numero) {

    for (let i = 0; i < numeros.length; i++) {
        if (numero == numeros[i]) {
            return true
        }
    }
    return false
}

function ehNumero(numero) {
    return !isNaN(parseFloat(numero)) && isFinite(numero);
}