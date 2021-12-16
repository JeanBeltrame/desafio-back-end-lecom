buscaHidden();

function montaObjetoProduto() {
    var produtos = [
        {
            id: "",
            nome: "",
            descricao: "",
            categoria: "",
            precoUnitario: 0
        }
    ];
    return produtos;
}

function mostraErro() {
    let lista = document.querySelector("#lista-produtos");
    let span = document.createElement("span");

    span.classList.add("mx-auto");
    span.textContent = "Não foi possível encontrar o(s) produto(s)";

    lista.appendChild(span);
}

function getProdutos() {
    try {
        limpar();

        let request = new XMLHttpRequest();
        request.open("GET", "http://localhost:8080/produto/consultar", false);
        
        request.send();
    
        var produtos = montaObjetoProduto();
    
        var produtoRequest = request.responseText;
        produtos = JSON.parse(produtoRequest);
        produtos.forEach(produto => {
            exibirProduto(produto);
        });
    } catch (error) {
        mostraErro();
    }
}

function exibirProduto(produto) {
    let lista = document.querySelector("#lista-produtos");
    let div = document.createElement("div");

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

    lista.appendChild(div);

    

}

function buscarPorId(event) {

    try {
        event.preventDefault();
        
        let idProduto = document.querySelector("#id-produto").value;
        if (idProduto == null || idProduto == "" || idProduto == 0) {
            getProdutos();
            return;
        }
    
        limpar();
    
        let request = new XMLHttpRequest();
        request.open("GET", "http://localhost:8080/produto/consultar/" + idProduto, false);
        request.send();
    
        let produto = montaObjetoProduto();
    
        var produtoRequest = request.responseText;
        produto = JSON.parse(produtoRequest);
    
        exibirProduto(produto);
    } catch (error) {
        mostraErro();
    }

}

function buscarPorNome(event) {

    try {
        event.preventDefault();
        
        let nomeProduto = document.querySelector("#nome-produto").value;
        if (nomeProduto == null || nomeProduto == "" || nomeProduto == " ") {
            getProdutos();
            return;
        }

        limpar();
    
        let request = new XMLHttpRequest();
        request.open("GET", "http://localhost:8080/produto/consultar/nome/" + nomeProduto, false);
        request.send();
    
        let produtos = montaObjetoProduto();
    
        var produtoRequest = request.responseText;
        produtos = JSON.parse(produtoRequest);

        produtos.forEach(produto => exibirProduto(produto));
    } catch (error) {
        mostraErro();
    }

}

function buscaHidden() {
    let buscaId = document.getElementById("busca-por-id");
    let buscaNome = document.getElementById("busca-por-nome");

    buscaId.hidden = true;
    buscaNome.hidden = true;

    
    let btnLimparBusca = document.getElementById("limpar-pesquisa");
    let btnBuscaId = document.getElementById("pesquisar-id");
    let btnBuscaNome = document.getElementById("pesquisar-nome");

    btnBuscaId.hidden = true;
    btnBuscaNome.hidden = true;
    btnLimparBusca.hidden = true;

}

function mudaOpcaoDeBuscaParaId() {
    let id = document.getElementById("busca-por-id");
    let nome = document.getElementById("busca-por-nome");
    id.hidden = false;
    nome.hidden = true;

    let btnBuscaId = document.getElementById("pesquisar-id");
    let btnBuscaNome = document.getElementById("pesquisar-nome");
    let btnLimparBusca = document.getElementById("limpar-pesquisa");
    btnBuscaId.hidden = false;
    btnBuscaNome.hidden = true;
    btnLimparBusca.hidden = false;

}

function mudaOpcaoDeBuscaParaNome() {
    let id = document.getElementById("busca-por-id");
    let nome = document.getElementById("busca-por-nome");
    id.hidden = true;
    nome.hidden = false;

    let btnBuscaId = document.getElementById("pesquisar-id");
    let btnBuscaNome = document.getElementById("pesquisar-nome");
    let btnLimparBusca = document.getElementById("limpar-pesquisa");
    btnBuscaId.hidden = true;
    btnBuscaNome.hidden = false;
    btnLimparBusca.hidden = false;

}

function limpar(){
    let produtos = document.querySelector("#lista-produtos").children;
    for (let i = produtos.length - 1; i >=  0; i--) {
        produtos[i].remove();
    }
}