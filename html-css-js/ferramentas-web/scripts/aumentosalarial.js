function verificarAumento(event) {
    event.preventDefault()
    let option = document.querySelector('input[name="cargo"]:checked');
    let salarioAtual = parseFloat(document.getElementById("ip-salarioAtual").value);
    let aumento = 0;
    let salarioComAumento;
    if (verificarSalario(salarioAtual)) {

        if (option) {
            switch (option.value) {
                case 'gerente':
                    aumento = salarioAtual * (5 / 100);
                    break;
                case 'supervisor':
                    aumento = salarioAtual * (8 / 100);
                    break;
                case 'operador':
                    aumento = salarioAtual * (9 / 100);
                    break;
                case 'outro':
                    aumento = salarioAtual * (10 / 100);
                    break;
                default:
                    alert("Erro inesperado.");
            }

            salarioComAumento = salarioAtual + aumento;

            resultado('Seu novo salário com aumento é ' + salarioComAumento.toFixed(2)); // Mostra com duas casas decimais
        } else {
            alert("Selecione um cargo válido.");
        }

        document.querySelector('input[name="cargo"]:checked').checked = false; 
        document.getElementById("ip-salarioAtual").value = "";

    }

}

function verificarSalario(x) {
    x = parseFloat(x);
    if (isNaN(x)) {
        alert("Preencha o campo com um salário válido");
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