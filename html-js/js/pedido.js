function getPedidos() {
    let request = new XMLHttpRequest();
    request.open("GET","http://localhost:8080/venda/consultar",false);

    let pedidos = [{
        vendaId:'',
        itens:[{
            quantidade: 0,
            produto: {
                id: '',
                nome: '',
                descricao:  '',
                categoria: '',
                precoUnitario: 0
            }
        }],
        precoTotal: 0,
        cepDestinatario:''
    }];

    request.send();

    pedidos=JSON.parse(request.responseText);
    console.log(pedidos);
    pedidos.forEach(pedido => {
        exibirPedido(pedido);
    })

}

function exibirPedido(pedido) {
    let lista = document.querySelector("#lista-pedidos");
    let div = document.createElement("div");

    div.classList.add("produto");
    div.classList.add("col-lg-5");
    div.classList.add("mx-auto");

    let CEP = document.createElement("span");
    CEP.classList.add("d-block");
    CEP.textContent =  "CEP do destino: " + pedido.cepDestinatario;

    let produto = document.createElement("span");
    produto.classList.add("d-block");
    produto.textContent =  "Produtos: ";

    pedido.itens.forEach(item => {
        let nomeProduto = document.createElement("span");
        let quantidadeProduto = document.createElement("span");

        nomeProduto.classList.add("d-block");
        nomeProduto.classList.add("ml-2");
        nomeProduto.textContent = "Nome: " + item.produto.nome;

        quantidadeProduto.classList.add("d-block");
        quantidadeProduto.classList.add("ml-2");
        quantidadeProduto.textContent = "Quantidade: " + item.quantidade;

        produto.appendChild(nomeProduto);
        produto.appendChild(quantidadeProduto);
    });

    let precoTotal = document.createElement("span");
    precoTotal.classList.add("d-block");
    precoTotal.textContent =  "Preço  total: " + pedido.precoTotal;
    
    div.appendChild(CEP);
    div.appendChild(produto);
    div.appendChild(precoTotal);

    lista.appendChild(div);
    
}
