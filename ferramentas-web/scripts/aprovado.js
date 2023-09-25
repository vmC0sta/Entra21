function verificarAprovado(event) {
    event.preventDefault();
    let nota1 = parseFloat(document.getElementById("ip-nota1").value);
    let nota2 = parseFloat(document.getElementById("ip-nota2").value);
    let nota3 = parseFloat(document.getElementById("ip-nota3").value);
    let frequencia = parseFloat(document.getElementById("ip-frequencia").value)

    // Verifique se cada nota é válida antes de prosseguir
    if (verificarNota(nota1) && verificarNota(nota2) && verificarNota(nota3) && verificarFrequencia(frequencia)) {
        let media = (nota1 + nota2 + nota3) / 3;

        if (frequencia >= 75 && media >= 6) {
            resultado("Parabéns você foi aprovado!");
        } else {
            resultado("Que pena, você não foi aprovado!");
        }
    } 

    document.getElementById("ip-nota1").value = "";
    document.getElementById("ip-nota2").value = "";
    document.getElementById("ip-nota3").value = "";
    document.getElementById("ip-frequencia").value = "";

}

function verificarNota(x) {
    try { 
        if (isNaN(x)) {
            throw "Preencha o campo com uma nota válida";
        }
        x = parseFloat(x);
        if (x > 10 || x < 0) {
            throw "Preecha com uma nota entre 0 e 10";
        }
        return true;
    } catch (err) {
        alert(err)
        return false;
    }
}

function verificarFrequencia(x){
    try{
        if(isNaN(x)){
            throw "Preencha o campo com uma frequência válida"
        }
        if(x > 100 || x < 0){
            throw "Preecha com uma frequência entre 0 e 100"
        }
        return true;
        
    }catch(err){
        alert(err);
        return false
    }
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