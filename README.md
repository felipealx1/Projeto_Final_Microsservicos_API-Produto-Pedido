# Projeto Final - Pós-Graduação Desemvolvimento Web FullStack 
# Microsserviços API Produto e Pedido
<html>
<body>
    <header>
        <h1>Pós-Graduação: Desenvolvimento Web Fullstack</h1>
        <h2>Disciplina: API e Microsserviço</h2>
        <h3>Integrantes do Grupo:</h3>
        <ul>
            <li>Caio césar  RGM : 38091399 </li>
            <li>Vitor Cauê Guimarães Travassos  RGM:  380546621</li>
            <li>William Felix de Souza  RGM: 39699013</li>
            <li>José Felipe Alexandre Martins  RGM: 39364429</li>
        </ul>
    </header>

<section>
        <h2>API Order e Product - Microsserviços</h2>
        <p>Esta API é composta por dois microsserviços: o serviço de <strong>Produtos</strong> e o serviço de <strong>Pedidos</strong>. A arquitetura de microsserviços permite que cada serviço seja independente e escalável, facilitando o gerenciamento de produtos e pedidos de forma modular.</p>
    </section>

<section>
        <h3>Diagrama de Classes</h3>
        <img src="img/Capturar9.PNG" alt="Diagrama de Classes Order e Product" width="400">
        <p>O diagrama acima ilustra a relação entre as entidades <strong>Produto</strong> e <strong>Pedido</strong>, incluindo o status enumerado de um pedido. Cada produto contém informações como nome, quantidade disponível, descrição e preço. Já cada pedido possui uma referência a um produto, data, endereço e status.</p>
    </section>

<section>
            <h2>Endpoints do Microsserviço de Produto</h2>
            <ul>
                <li><strong>GET /produtos</strong> - Retorna a lista de todos os produtos.</li>
                <li><strong>POST /produtos</strong> - Cria um novo produto no sistema.</li>
                <li><strong>GET /produtos/{id}</strong> - Retorna os detalhes de um produto específico.</li>
                <li><strong>POST /produtos/{id}/verificaDisponibilidade</strong> - Verifica a disponibilidade do produto pelo seu ID.</li>
                <li><strong>PUT /produtos/{id}/diminuir?quantidade={numeroQueVaiDiminuir}</strong> - Diminui a quantidade de um produto específico, passando a quantidade a ser diminuída como parâmetro.</li>
                <li><strong>DELETE /produtos/{id}</strong> - Remove um produto do sistema.</li>
            </ul>
        </section>

<section>
            <h2>Endpoints do Microsserviço de Pedido</h2>
            <ul>
                <li><strong>POST /pedidos</strong> - Cria um novo pedido.</li>
                <li><strong>GET /pedidos</strong> - Retorna a lista de todos os pedidos.</li>
                <li><strong>GET /pedidos/{id}</strong> - Retorna os detalhes de um pedido específico.</li>
                <li><strong>PUT /pedidos/{id}/confirmar</strong> - Confirma um pedido, alterando seu status para <em>CONFIRMADO</em>.</li>
                <li><strong>PUT /pedidos/{id}/cancelar</strong> - Cancela um pedido, alterando seu status para <em>CANCELADO</em>.</li>
                <li><strong>DELETE /pedidos/{id}</strong> - Remove um pedido do sistema.</li>
            </ul>
    <section>
        <h2>Testes dos Endpoints usando o Postman</h2>
        <p>Para realizar testes na API, utilize o <strong>Postman</strong> para enviar requisições HTTP aos endpoints. Abaixo estão os endpoints com suas respectivas URLs e espaços para imagens de exemplo das requisições:</p>

<h3>Microsserviço de Produto</h3>
        <ul>
            <li><strong>GET /produtos</strong> - Retorna a lista de todos os produtos.</li>
            <p>URL: <code>http://localhost:8080/api-product-ms/produtos</code></p>
            <img src="img/Capturar.PNG" alt="GET Produtos" width="500"><br>

<br><li><strong>POST /produtos</strong> - Cria um novo produto.</li>
            <p>URL: <code>http://localhost:8080/api-product-ms/produtos</code></p>
            <img src="img/Capturar1.PNG" alt="POST Produto" width="500"><br>

<br><li><strong>POST /produtos/{id}/verificaDisponibilidade</strong> - Verifica a disponibilidade do produto.</li>
            <p>URL: <code>http://localhost:8080/api-product-ms/produtos/4/verificaDisponibilidade</code></p>
            <img src="img/Capturar2.PNG" alt="POST Verifica Disponibilidade" width="500">
        </ul><br>
        
<br><li><strong>DELETE /produtos/{id}</strong> - Deleta o produto.</li>
            <p>URL: <code>http://localhost:8080/api-product-ms/produtos/4</code></p>
            <img src="img/Capturar10.PNG" width="500">
        </ul><br>

<h3>Microsserviço de Pedido</h3>
        <ul>
            <li><strong>POST /pedidos</strong> - Cria um novo pedido.</li>
            <p>URL: <code>http://localhost:8080/api-order-ms/pedidos</code></p>
            <img src="img/Capturar4.PNG" alt="POST Pedido" width="500"><br>

<br><li><strong>GET /pedidos</strong> - Retorna a lista de todos os pedidos.</li>
            <p>URL: <code>http://localhost:8080/api-order-ms/pedidos</code></p>
            <img src="img/Capturar3.PNG" alt="GET Pedidos" width="500"><br>

<br><li><strong>PUT /pedidos/{id}/confirmar</strong> - Confirma um pedido.</li>
            <p>URL: <code>http://localhost:8080/api-order-ms/pedidos/6/confirmar</code></p>
            <img src="img/Capturar5.PNG" alt="PUT Confirmar Pedido" width="500"><br>

<br><li><strong>PUT /pedidos/{id}/cancelar</strong> - Cancela um pedido.</li>
            <p>URL: <code>http://localhost:8080/api-order-ms/pedidos/6/cancelar</code></p>
            <img src="img/Capturar6.PNG" alt="PUT Cancelar Pedido" width="500"><br>

<br><li><strong>DELETE /pedidos/{id}</strong> - Remove um pedido do sistema.</li>
            <p>URL: <code>http://localhost:8080/api-order-ms/pedidos/6</code></p>
            <img src="img/Capturar7.PNG" alt="DELETE Pedido" width="500"><br>
        </ul>
    </section>
</body>
</html>
