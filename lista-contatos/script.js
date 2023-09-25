var contatos = [];

function adicionarContato() {

    var nome = document.getElementById('nome').value;
    var email = document.getElementById('email').value;
    var fone = document.getElementById('fone').value;

    if (campoVazio(nome) || campoVazio(email) || campoVazio(fone)) {
        alert('Os campos não foram preenchidos', 'alert-warning')
        return;
    }

    if (campoExiste(nome, email, fone)) {
        alert('O contato já existe na agenda', 'alert-warning')
        return
    }

    var novoContato = { nome: nome, email: email, fone: fone };
    contatos.push(novoContato);

    console.log(contatos);

    atualizarTabela();

    alert('O contato foi adicionado com sucesso', 'alert-success')

}

function atualizarTabela() {
    let size = contatos.length
    let linhas = ''
    for (let i = 0; i < size; i++) {
        linhas += `<tr>
                    <td>${contatos[i].nome}</td>
                    <td>${contatos[i].email}</td>
                    <td>${contatos[i].fone}</td>
                    <td>
                        <button class="btn btn-primary btn-sm" id="botaoExcluir"onclick=editarContato('${i}')>Editar</button>
                        <button class="btn btn-danger btn-sm" id="botaoEditar" onclick=excluirContato('${i}')>Excluir</button>
                    </td>
                </tr>`
    }

    document.getElementsByTagName('tbody')[0].innerHTML = linhas

}

function excluirContato(item) {

    contatos.splice(item, 1)
    atualizarTabela(); // Atualiza a tabela após a exclusão

}

function editarContato(item) {

    contatoEditar = contatos[item]

    document.getElementById('nome').value = contatoEditar.nome
    document.getElementById('email').value = contatoEditar.email
    document.getElementById('fone').value = contatoEditar.fone

    document.getElementById('btn-gravar').setAttribute('disabled', 'true')
    document.getElementById('btn-editar').setAttribute('disabled')

}

function salvarEditar() {

    //atualizar o objeto com os novos dados
    let inputNome = document.getElementById('nome')
    let inputEmail = document.getElementById('email')
    let inputFone = document.getElementById('fone')

    contatoEditar.nome = inputNome.value
    contatoEditar.email = inputEmail.value
    contatoEditar.fone = inputFone.value

    atualizarTabela()

    //bloquear botão editar
    document.getElementById('btn-editar').setAttribute('disabled','true')
    //desbloquear botão gravar
    document.getElementById('btn-gravar').removeAttribute('disabled')

}

function limpar() {
    document.getElementById('nome').value = ''
    document.getElementById('email').value = ''
    document.getElementById('fone').value = ''
}

function campoVazio(valor) {
    if (valor === '') {
        return true; // Retorne true se o campo estiver vazio
    }
    return false; // Retorne false se o campo não estiver vazio
}

function campoExiste(a, b, c) {
    for (let i = 0; i < contatos.length; i++) {
        if (
            a.toLowerCase() === contatos[i].nome.toLowerCase() &&
            b.toLowerCase() === contatos[i].email.toLowerCase() &&
            c.toLowerCase() === contatos[i].fone.toLowerCase()
        ) {
            return true;
        }
        return false;
    }
}



function alert(message, type) {

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