//pode fazer que nem na pag de produtos, mas só que quando clica em cima, ele adiciona os itens (dai coloca um input pra selecionar a quantidade dentro da exibição do produto)
//e deixa junto as pesquisas

function getProdutosCompra() {
    try {
        limpar();

        let request = new XMLHttpRequest();
        request.open("GET", "http://localhost:8080/produto/consultar", false);
        
        request.send();
    
        var produtos = montaObjetoProduto();
    
        var produtoRequest = request.responseText;
        produtos = JSON.parse(produtoRequest);
        produtos.forEach(produto => {
            exibirProdutoDisponivel(produto);
        });
    } catch (error) {
        mostraErro();
    }
}

function exibirProdutoDisponivel(produto) {
    let lista = document.querySelector("#lista-produtos");
    let div = document.createElement("div");

    let inputQuantidade = document.createElement("input");
    inputQuantidade.type = 'number';
    inputQuantidade.id = 'quantidadeProduto';
    inputQuantidade.min = '0';
    inputQuantidade.placeholder = "Quantidade";
    inputQuantidade.classList.add("d-block");
    inputQuantidade.classList.add("mx-auto");
    inputQuantidade.classList.add("mb-2");

    div.classList.add("produto");
    div.classList.add("col-lg-5");
    div.classList.add("mx-auto");

    let nome = document.createElement("span");
    nome.classList.add("d-block");
    nome.textContent =  "Nome: " + produto.nome;

    let descricao = document.createElement("span");
    descricao.classList.add("d-block");
    descricao.textContent = "Descrição: " + produto.descricao;

    let categoria = document.createElement("span");
    categoria.classList.add("d-block");
    categoria.textContent =  "Categoria: " + produto.categoria;

    let precoUnitario = document.createElement("span");
    precoUnitario.classList.add("d-block");
    precoUnitario.textContent = "Preço: " + produto.precoUnitario;


    div.appendChild(nome);
    div.appendChild(descricao);
    div.appendChild(categoria);
    div.appendChild(precoUnitario);
    div.appendChild(inputQuantidade);

    lista.appendChild(div);

    buscaHidden();

}