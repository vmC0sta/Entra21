let produtos = [];
let produtoEditar = [];
let soma = 0

function ehDuplicado(a, b) {  // Verifica se o produto já está presente no array


    for (let i = 0; i < produtos.length; i++) {
        if (a.toLowerCase() === produtos[i].produto.toLowerCase() && b === produtos[i].valorUnitario) {
            return true;
        }
    }
    return false;
}

function carregarArquivo(file, callback) {  // Carrega o arquivo

    // Verifica se o file está vazio, se um arquivo foi fornecido
    if (file) {

        // O FileReader permite ler conteúdo de arquivos.
        const reader = new FileReader();

        //Define o que acontecerá quando o FileReader terminar de ler o arquivo.
        reader.onload = function (event) {

            callback(event.target.result); // Chama a função de callback com a URL da imagem.
        };

        // Inicia a leitura do arquivo. Isso faz com que o navegador comece a ler o conteúdo do arquivo especificado.
        reader.readAsDataURL(file);
    }
    else {
        //Se 'file' estiver vazio, exibe um alerta para informar ao usuário que uma foto do produto deve ser fornecida.
        alert('Informe uma foto do produto!')
    }
}

function adicionarProduto() {


    // Atribui os valores dos inputs a variáveis
    let produto = document.getElementById('produto').value;
    let valorUnitario = parseFloat(document.getElementById('valor').value);
    let quantidade = parseFloat(document.getElementById('quantidade').value);
    let arquivoInput = document.getElementById('arquivo');

    // Verifica se os campos foram preenchidos
    if (produto === '' || valorUnitario === '' || quantidade === '') {
        alert('O campo não foi preenchido!');
        return;
    }
    // Verifica se os valores dos campos valorUnitario e quantidade são números
    if (isNaN(valorUnitario) || isNaN(quantidade)) {
        alert('Informe um número válido')
        document.getElementById('valor').value = ''
        document.getElementById('quantidade').value = ''
        return
    }
    // Verifica se os valores já estavam presentes no Array
    if (ehDuplicado(produto, valorUnitario)) {
        alert('Produto duplicado!');
        return;
    }


    carregarArquivo(arquivoInput.files[0], function (imagemURL) {

        // Cria um novo produto com informações fornecidas pelo usuário.

        let novoProduto = {
            produto: produto,
            valorUnitario: valorUnitario,
            quantidade: quantidade,
            imagem: imagemURL
        };

        // Adiciona o novoProduto ao array
        produtos.push(novoProduto);
        console.log(produtos);

        // Chama a função atualizarCards() para atualizar o site com os produtos adicionados.
        atualizarCards();
    });
}

function atualizarCards() {
    // Garante que a linha esteja vazia
    let linhas = '';

    // Inicializa a variável soma com zero
    let soma = 0;

    // Monta uma estrutura HTML com as informações fornecidas pelo usuário
    for (let i = 0; i < produtos.length; i++) {
        linhas += `
            <div class="col m-2">
                <div class="card" style="width: 18rem;height: 450px;">
                    <img id="imagem-produto" class="card-img-top style="height=300px src="${produtos[i].imagem}" alt="Produto ${produtos.produto}">
                    <div class="card-body text-center">
                        <h5 class="card-title">${produtos[i].produto}</h5>
                        <p class="card-text m-0"><strong>Quantidade: ${produtos[i].quantidade}</strong></p>
                        <p class="card-text m-0"><strong>Valor unitário: R$${produtos[i].valorUnitario}</strong></p>
                        <button type="button" class="btn btn-danger m-2" onclick=excluir('${i}')>Excluir</button>
                        <button type="button" class="btn btn-light m-2" id="editar" onclick=editar('${i}')>Editar</button>
                    </div>
                </div>
            </div>
        `;

        // Converte o valor unitário para número e adiciona à soma
        soma += parseFloat(produtos[i].valorUnitario) * parseFloat(produtos[i].quantidade);
    }

    // Adiciona essa estrutura ao elemento row do HTML
    document.getElementsByClassName('row')[0].innerHTML = linhas;
    limpar();

    document.getElementById('valorTotal').innerHTML= 'Valor unitário: R$' + soma;
}


// Limpa os campos
function limpar() {
    document.getElementById('produto').value = '';
    document.getElementById('valor').value = '';
    document.getElementById('quantidade').value = '';
    document.getElementById('arquivo').value = '';

}

function editar(i) {

    produtoEditar = produtos[i];
    document.getElementById('produto').value = produtoEditar.produto;
    document.getElementById('valor').value = produtoEditar.valorUnitario;
    document.getElementById('quantidade').value = produtoEditar.quantidade;

}


function salvar () {

    let produtoAlterado = document.getElementById('produto').value;
    let valorAlterado = parseFloat(document.getElementById('valor').value);
    let quantidadeAlterado = parseFloat(document.getElementById('quantidade').value);
    let novoArquivo = document.getElementById('arquivo').files[0]; // Nova imagem

    produtoEditar.produto = produtoAlterado;
    produtoEditar.valorUnitario = valorAlterado;
    produtoEditar.quantidade = quantidadeAlterado;

    // Atualiza a imagem apenas se um novo arquivo foi fornecido
    if (novoArquivo) {
        carregarArquivo(novoArquivo, function (imagemURL) {
            produtoEditar.imagem = imagemURL;
            atualizarCards();
            limpar();
        });
    } else {
        atualizarCards();
        limpar();
    }
}


function excluir(i) {

    produtos.splice(i, 1)
    atualizarCards()

}