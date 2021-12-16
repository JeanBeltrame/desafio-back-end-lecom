function getPedidos() {
    let request = new XMLHttpRequest();
    request.open("GET","http://localhost:8080/venda/consultar/entrega",false);

    let pedidos = [{
        nomeProduto:[],
        cepDestinatario:'',
        cepRemetente:'',
        status: ''
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

    let CEPDestino = document.createElement("span");
    CEPDestino.classList.add("d-block");
    CEPDestino.textContent =  "CEP do destino: " + pedido.cepDestinatario;

    let CEPRemetente = document.createElement("span");
    CEPRemetente.classList.add("d-block");
    CEPRemetente.textContent =  "CEP do remetente: " + pedido.cepRemetente;

    let produto = document.createElement("span");
    produto.classList.add("d-block");
    produto.textContent =  "Produtos: ";

    pedido.nomeProduto.forEach(nome => {
        let nomeProduto = document.createElement("span");

        nomeProduto.classList.add("d-block");
        nomeProduto.classList.add("ml-2");
        nomeProduto.textContent = nome;

        produto.appendChild(nomeProduto);
    });

    let status = document.createElement("span");
    status.classList.add("d-block");
    status.textContent =  "Satus: " + pedido.status;
    
    div.appendChild(CEPRemetente);
    div.appendChild(CEPDestino);
    div.appendChild(produto);
    div.appendChild(status);

    lista.appendChild(div);
    
}