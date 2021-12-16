//pode fazer que nem na pag de produtos, mas só que quando clica em cima, ele adiciona os itens (dai coloca um input pra selecionar a quantidade dentro da exibição do produto)
//e deixa junto as pesquisas
buscaHidden();
var itensCompra = [{
    quantidade: 0,
    produto: {
        id: ""
    }
}];

function getItensCompra() {
    return itensCompra;
}

function setItensCompra(produto, quantidade) {
    let item = {
        quantidade: quantidade,
        produto: {
            id: produto.id
        }
    }

    itensCompra.push(item);
}

function realizarCompra(cep) {
    let itens = getItensCompra();
    itens.splice(0,1);
    let compra = {
        cepDestinatario: cep,
        itens: itens
    }

    fetch("http://localhost:8080/venda", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(compra),})
    .then((response) => response.json())
    .then((data) => {
        alert("Venda feita com sucesso! O status do seu pedido é: " + data.status);
        document.location.reload(true);
    })
    .catch((error) => {
       alert("Não foi possível registrar o seu pedido: " +  error);
    });

}

function mostraProdutosDisponiveisCompra() {
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
    div.classList.add("produto");
    div.classList.add("col-lg-5");
    div.classList.add("mx-auto");

    let btnAdicionarProduto = document.createElement("input");
    btnAdicionarProduto.setAttribute("type", 'button');
    btnAdicionarProduto.setAttribute("value", "Adicionar à lista de produtos");

    btnAdicionarProduto.classList.add("btn");
    btnAdicionarProduto.classList.add("btn-primary");
    btnAdicionarProduto.classList.add("mb-3");
    btnAdicionarProduto.classList.add("d-block");
    btnAdicionarProduto.classList.add("mx-auto");

    btnAdicionarProduto.addEventListener("click", () => {
        criarInputCepEBtnEnviar(inputQuantidade.value);
        adicionarProdutoCompra(produto, inputQuantidade.value);
    });


    let inputQuantidade = document.createElement("input");
    inputQuantidade.setAttribute("type", 'number');
    inputQuantidade.setAttribute("id", 'quantidadeProduto');
    inputQuantidade.setAttribute("min", '0');
    inputQuantidade.setAttribute("placeholder", "Quantidade");
    inputQuantidade.classList.add("d-block");
    inputQuantidade.classList.add("mx-auto");
    inputQuantidade.classList.add("mb-2");


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
    div.appendChild(btnAdicionarProduto);

    lista.appendChild(div);

}

function criarInputCepEBtnEnviar(quantidade) {
    let input = document.querySelector("#input-cep");

    if(input == null && quantidade >= 1){
        
        let divProduto = document.querySelector("#produtos-selecionados");

        let btnComprar = document.createElement("button");
        btnComprar.setAttribute("type", "submit");
        btnComprar.textContent =  "Finalizar Compra";

        btnComprar.classList.add("btn");
        btnComprar.classList.add("btn-primary");
        btnComprar.classList.add("mb-3");
        btnComprar.classList.add("d-block");
    
        let inputCEP = document.createElement("input");
        inputCEP.setAttribute("id", "input-cep");
        inputCEP.setAttribute("type", "text");
        inputCEP.setAttribute("placeholder", "Digite o CEP do destino");
        inputCEP.setAttribute("required", true);

        inputCEP.classList.add("mb-3");
        inputCEP.classList.add("mt-3");
    
        divProduto.appendChild(inputCEP);
        divProduto.appendChild(btnComprar);

        btnComprar.addEventListener("click", (event) => {
            if(inputCEP.value != "" && inputCEP.value != " " && inputCEP.value != null){
                event.preventDefault();
                realizarCompra(inputCEP.value);
            }
        })
    }
}

function adicionarProdutoCompra(produto, quantidade) {
    if(quantidade >= 1) {
        let divProduto = document.querySelector("#produtos-selecionados");
        
    
        let nomeProduto = document.createElement("span");
        nomeProduto.classList.add("d-block");
        nomeProduto.textContent = "Produto: " + produto.nome;
    
        let quantidadeProduto = document.createElement("span");
        quantidadeProduto.classList.add("d-block");
        quantidadeProduto.textContent = "Quantidade: " + quantidade;
    
        divProduto.appendChild(nomeProduto);
        divProduto.appendChild(quantidadeProduto);

        setItensCompra(produto, quantidade);

    }
}

function buscarPorId(event) {

    try {
        event.preventDefault();
        
        let idProduto = document.querySelector("#id-produto").value;
        if (idProduto == null || idProduto == "" || idProduto == 0) {
            limpar();
            mostraProdutosDisponiveisCompra();
            return;
        }
    
        limpar();

        let request = new XMLHttpRequest();
        request.open("GET", "http://localhost:8080/produto/consultar/" + idProduto, false);
        request.send();
    
        let produto = montaObjetoProduto();
    
        var produtoRequest = request.responseText;
        produto = JSON.parse(produtoRequest);
    
        exibirProdutoDisponivel(produto);
    } catch (error) {
        mostraErro();
    }

}

function buscarPorNome(event) {

    try {
        event.preventDefault();
        
        let nomeProduto = document.querySelector("#nome-produto").value;
        if (nomeProduto == null || nomeProduto == "" || nomeProduto == " ") {
            limpar();
            mostraProdutosDisponiveisCompra();
            return;
        }

        limpar();
    
        let request = new XMLHttpRequest();
        request.open("GET", "http://localhost:8080/produto/consultar/nome/" + nomeProduto, false);
        request.send();
    
        let produtos = montaObjetoProduto();
    
        var produtoRequest = request.responseText;
        produtos = JSON.parse(produtoRequest);

        produtos.forEach(produto => exibirProdutoDisponivel(produto));
    } catch (error) {
        mostraErro();
    }

}