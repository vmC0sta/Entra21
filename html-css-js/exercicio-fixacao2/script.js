var produtos = [];

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
    else{
        //Se 'file' estiver vazio, exibe um alerta para informar ao usuário que uma foto do produto deve ser fornecida.
        alert('Informe uma foto do produto!')
    }
}

function adicionarProduto() {


    // Atribui os valores dos inputs a variáveis
    var produto = document.getElementById('produto').value;
    var valorUnitario = parseFloat(document.getElementById('valor').value);
    var quantidade = parseFloat(document.getElementById('quantidade').value);
    var arquivoInput = document.getElementById('arquivo');

    // Verifica se os campos foram preenchidos
    if (produto === '' || valorUnitario === '' || quantidade ==='') {
        alert('O campo não foi preenchido!');
        return;
    }
    // Verifica se os valores dos campos valorUnitario e quantidade são números
    if(isNaN(valorUnitario) || isNaN(quantidade)){
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

        var novoProduto = {
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

    // Monta uma estrutura HTML com as informações fornecidas pelo usuário
    for (let i = 0; i < produtos.length; i++) {
        linhas += `
            <div class="col m-2">
                <div class="card" style="width: 18rem;height: 450px;">
                    <img class="card-img-top style="height=300px" " src="${produtos[i].imagem}" alt="Produto ${produtos.produto}">
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
    }
    // Adiciona essa estrutura ao elemento row do HTML
    document.getElementsByClassName('row')[0].innerHTML = linhas;
    limpar()
}

// Limpa os campos
function limpar(){
    document.getElementById('produto').value = '';
    document.getElementById('valor').value = '';
    document.getElementById('quantidade').value='';
    document.getElementById('arquivo').value = '';

}

function editar(i){

    document.getElementById('produto').value = produtos[i].produto
    document.getElementById('valor').value = produtos[i].valorUnitario
    document.getElementById('quantidade').value = produtos[i].quantidade
    document.getElementById('arquivo').valueprodutos[i].imagem

    document.getElementsById('btn-gravar').innerHTML = 'Editar'

}

function excluir(i){

    produtos.splice(i,1)
    atualizarCards()

}