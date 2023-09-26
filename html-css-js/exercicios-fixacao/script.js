var numeros = []

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

function arrayCrescente(array) {
    array.sort(function(a, b) {
        return a - b;
    });
}

function arrayDecrescente(array){
    array.sort(function(a, b) {
        return b - a;
    });
}


function exibirArray() {

    var numerosCopiados = numeros.slice();

    var select = document.querySelector('select');
    var option = parseInt(select.options[select.selectedIndex].value);

    switch (option) {
        case 1:
            arrayCrescente(numerosCopiados);
            break;
        case 2:
            arrayDecrescente(numerosCopiados);
            break;
        default:
            break;
    }

    let linhas = '';

    for (let i = 0; i < numerosCopiados.length; i++) {
        linhas += `
            <tr>
                <td>${numerosCopiados[i]}</td>
                <td>${i}</td>
            </tr>
        `;
    }

    document.getElementsByTagName('tbody')[0].innerHTML = linhas;
}

function limpar() {

    var input = document.getElementById('inputNumber')
    var p = document.getElementsByTagName('p')[0];

    numeros = []
    input.value = ''
    document.getElementsByTagName('tbody')[0].innerHTML = ''
    p.style.display = 'none'
    input.style.border = '2px solid black'
}

function excluirNumero(){

     numero = document.getElementById('inputNumber').value
        
    for (let i = 0; i < numeros.length; i++) {
        if (numero == numeros[i]) {
            numeros.splice(i,1)
        }
    }

    exibirArray()
}

function alterarNumero(){

    numero = document.getElementById('inputNumber').value

    var input = document.getElementById('inputNumber')
    var p = document.getElementsByTagName('p')[0];

    if(!existeNumero(numero)){
        p.innerHTML = '<strong>O número não existe no array!</strong>'
        p.style.display = 'flex'
        p.style.color = 'rgb(255, 174, 0)'
        input.style.border = 'rgb(255, 174, 0) solid 2px'
        return
    }

    for (let i = 0; i < numeros.length; i++) {
        if (numero == numeros[i]) {
            numeros.splice(i,1)
        }
    }

    p.innerHTML = '<strong>Informe o novo número</strong>'
    p.style.display = 'flex'
    p.style.color = 'rgb(51, 82, 253)'
    input.style.border = 'rgb(51, 82, 253) solid 2px'

    document.getElementById('inputNumber').value = ''

}

function salvarAlteracao(){
    inserirNumero()
    exibirArray()
}

