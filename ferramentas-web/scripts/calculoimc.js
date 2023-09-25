function verificarIMC(event) {

    event.preventDefault();

    let peso = parseFloat(document.getElementById("ip-peso").value);
    let altura = parseFloat(document.getElementById("ip-altura").value);
    let imc = parseFloat(peso / (altura * altura));

    if (verificarPeso(peso) && verificarAltura(altura)) {
        if (imc < 17) {
            resultado("Muito Abaixo do peso " + imc.toFixed(2));
        } else if (imc >= 17 && imc < 18.5) {
            resultado("Abaixo do peso " + imc.toFixed(2));
        } else if (imc >= 18.5 && imc < 25) {
            resultado("Peso normal " + imc.toFixed(2));
        } else if (imc >= 25 && imc < 30) {
            resultado("Acima do peso " + imc.toFixed(2));
        } else if (imc >= 30 && imc < 35) {
            resultado("Obesidade I " + imc.toFixed(2));
        } else if (imc >= 35 && imc < 40) {
            resultado("Obesidade II " + imc.toFixed(2));
        } else if (imc >= 40) {
            resultado("Obesidade III " + imc.toFixed(2));
        }
    }
}

function verificarPeso(x) {
    x = parseFloat(x);
    if (isNaN(x)) {
        alert("Preencha o campo com um peso válido");
        return false;
    }
    return true;
}

function verificarAltura(x) {
    x = parseFloat(x);
    if (isNaN(x)) {
        alert("Preencha o campo com uma altura válida");
        return false;
    }
    return true;
}

function resultado(message) {

    document.getElementById('text-modal').innerHTML = message
    bodyModal = document.getElementById('body-modal');
    bodyModal.style.display = 'block';
}

function closepopup() {
    bodyModal = document.getElementById('body-modal');
    bodyModal.style.display = 'none';
}


