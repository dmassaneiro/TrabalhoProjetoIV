<%@page import="br.com.controle.ItemDeCompra"%>
<%@page import="br.com.controle.CarrinhoDeCompra"%>
<jsp:useBean id="menu" class="br.com.controle.Menu"/>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho de Compras</title>
        <link rel="stylesheet" href="css/w3.css">
        <link rel="stylesheet" href="css/meu-estilo.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/principal.css">


    </head>


    <body>
        <!-- Navbar -->
        <%
            out.print(menu.MostrarMenu());
        %>

        <div>
            <center><h1>Seus Iten(s) para Compra</h1></center>
            <div class="table-responsive">
                <center><table class="table">
                        <tr>

                            <th>Item</font></th>
                            <th>Quantidade</font></th>
                            <th>Preço Unitário</font></th>
                            <th>Total Item</font></th>
                            <th>Adicionar</font></th>
                            <th>Remover</font></th>
                        </tr>
                        <%
                            //recupera os produtos do carrinho da sessao                           
                            if (session.getAttribute("carrinho") != null) {
                                CarrinhoDeCompra carrinho = (CarrinhoDeCompra) session.getAttribute("carrinho");
                                for (ItemDeCompra item : carrinho.getItens()) {
                        %>
                        <tr>

                            <td><%=item.getProduto().getNome()%></td>
                            <td><%=item.getQuantidade()%></td>
                            <td>R$: <%=item.getProduto().getPrecoUnitario()%></td>
                            <td><%=item.getTotal()%></td>
                            <td><a href="ControleCarrinho?acao=addProduto&idProduto=<%=item.getProduto().getId()%>"
                                   class="btn btn-primary"style="width: 80px">ADD +1 </a>
                            </td>
                            <td><a href="ControleCarrinho?acao=removeProduto&idProduto=<%=item.getProduto().getId()%>"
                                   class="btn btn-warning"style="width: 80px">Retirar</a></td>
                        </tr>
                        <%
                            }
                        %>
                    </table></center>
            </div>

        </div>
    </div>
    <div class="container">
        <strong class="total"><h4>Valor Total R$: </br><b><%=carrinho.calculaTotal()%></b></h4></strong><br/>

        <button class="btn btn-success">
            <a style="text-decoration:none" href="ControleCarrinho?acao=finalizarCompra">Finalizar compra</a>
        </button></br>
        <button class="btn btn-info">
            <a style="text-decoration:none" href="AddCarrinho.jsp">Continue comprando</a>
        </button></br>
        <button class="btn btn-danger">
            <a style="text-decoration:none" href="ControleCarrinho?acao=cancelaCompra">Cancelar comprar</a>
        </button>
    </div>
    <%
            }        
    %>
</div>
</body>
</html>