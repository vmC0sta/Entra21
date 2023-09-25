var frutas = []; // Array para armazenar as frutas

function adicionarFruta() {
    var fruta = document.getElementById('fruta').value; // Pega o valor da entrada

    var select = document.querySelector('select');
    var option = select.options[select.selectedIndex].value; // Obtém o valor da opção selecionada

    if (fruta.trim() === '') {
        alerta('O campo não foi preenchido!', 'alert-warning'); // Retorna um alerta caso o campo não tenha sido preenchido
        return;
    }

    if (existeFruta(fruta)) {
        alerta('Essa fruta já foi informada', 'alert-warning'); // Retorna um alerta caso a palavra já tenha sido informada
        return;
    }

    frutas.push(fruta); // Adiciona a fruta ao array

    switch (option) {
        case '1':
            exibirParagrafo();
            break;
        case '2':
            exibirLista();
            break;
        case '3':
            exibirTabela();
            break;
        default:
            alerta('Erro inesperado', 'alert-danger');
    }

    document.getElementById('fruta').value = ''; // Limpa o campo de entrada
    alerta("O campo foi preenchido com sucesso", "alert-success"); // Retorna um alerta que exibe que a palavra foi informada na tabela
}

function excluirFruta(event) {
    var index = event.target.getAttribute('data-index'); // Obtém o índice do botão clicado
    frutas.splice(index, 1);
    exibirLista();
    exibirParagrafo();
    exibirTabela();
    alerta(`A fruta foi excluída com sucesso.`, 'alert-danger');
}

function editarFruta() {

}

function existeFruta(fruta) { /*Verifica se a palavra informada já existe no array*/

    for (let i = 0; i < frutas.length; i++) {
        if (fruta.toLowerCase() == frutas[i].toLowerCase()) {
            return true
        }
    }
    return false
}

function alerta(message, type) {

    var alertElement = document.querySelector('.alert');
    alertElement.style.display = 'block';
    document.getElementById('p-alert').innerHTML = `<strong>${message}</strong>`
    if (alertElement) {
        // Remova a classe atual ("alert-warning")
        alertElement.classList.remove('alert-warning');
        // Adicione a nova classe desejada ("alert-danger")
        alertElement.classList.add(type);
    }
}

function exibirLista() {


    var lista = document.createElement('ul');
    lista.className = 'list-group'

    for (let i = 0; i < frutas.length; i++) {

        var item = document.createElement('li');
        item.className = 'list-group-item mt-4'
        item.textContent = frutas[i];

        var deleteButton = document.createElement('button');
        deleteButton.textContent = 'Excluir';
        deleteButton.className = 'btn btn-danger btn-sm';
        deleteButton.style.float = 'right';
        deleteButton.setAttribute('data-index', i); 
        deleteButton.addEventListener('click', excluirFruta);

        item.appendChild(deleteButton);

        // Adicione o item à lista
        lista.appendChild(item);
    }

    document.getElementById('resultado').innerHTML = '';
    document.getElementById('resultado').appendChild(lista);
}


function exibirParagrafo() {

    var resultadoDiv = document.getElementById('resultado');

    resultadoDiv.innerHTML = '';

    for (let i = 0; i < frutas.length; i++) {
        var paragrafo = document.createElement('p');
        paragrafo.textContent = frutas[i];
        resultadoDiv.appendChild(paragrafo);

        var deleteButton = document.createElement('button');
        deleteButton.textContent = 'Excluir';
        deleteButton.className = 'btn btn-danger btn-sm';
        deleteButton.style.float = 'right';
        deleteButton.setAttribute('data-index', i); 
        deleteButton.addEventListener('click', excluirFruta);

        paragrafo.appendChild(deleteButton);
    }

    resultadoDiv.className = 'mt-5';
}

function exibirTabela() {

    var tabela = document.createElement('table');

    tabela.className = 'table'


    for (let i = 0; i < frutas.length; i++) {

        var novaLinha = tabela.insertRow();
        var novaCelula = novaLinha.insertCell(0);
        novaCelula.textContent = frutas[i];

        var deleteButton = document.createElement('button');
        deleteButton.textContent = 'Excluir';
        deleteButton.className = 'btn btn-danger btn-sm';
        deleteButton.style.float = 'right';
        deleteButton.setAttribute('data-index', i); 
        deleteButton.addEventListener('click', excluirFruta);

        novaCelula.appendChild(deleteButton);

    }

    var resultadoDiv = document.getElementById('resultado');

    resultadoDiv.innerHTML = '';

    resultadoDiv.appendChild(tabela);

}
