function verificarIdade(event) {

    event.preventDefault();

    let idade = document.getElementById("ip-idade").value;

    if (validarIdade(idade)) {

        if (idade >= 18) {
            resultado('Parabéns, você é maior de idade!')
        }
        else {
            resultado('Que pena, você não é maior de idade!')
        }
    }

    document.getElementById('ip-idade').value = " "

}

function validarIdade(x) {
    x = parseInt(x);
    if (isNaN(x)) {
        alert("Preencha o campo com uma idade válida");
        return false;
    }
    return true;
}


function resultado(message){  
  
    document.getElementById('text-modal').innerHTML = message
    bodyModal = document.getElementById('body-modal');
    bodyModal.style.display = 'block';
}

function closepopup(){
    bodyModal = document.getElementById('body-modal');
    bodyModal.style.display = 'none';
}