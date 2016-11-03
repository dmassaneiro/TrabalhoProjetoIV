<%-- 
    Document   : AddCarrinho
    Created on : 02/11/2016, 10:52:18
    Author     : Diego Massaneiro
--%>
<%@page import="java.util.List"%>
<%@page import="br.com.controle.Produto"%>
<%@page import="br.com.DAO.ProdutoDAO"%>
<jsp:useBean id="menu" class="br.com.controle.Menu"/> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
        <link rel="stylesheet" href="css/meu-estilo.css">
        <link rel="stylesheet" href="css/w3.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" href="css/principal.css">


    </head>
    <body>
        <!-- Barra de Navegacao -->
        <%
            out.print(menu.MostrarMenu());
        %>

        <div class="w3-content " style="max-width:2000px;margin-top:46px">
            <center><h1>Produtos para Comprar</h1></center>
            <div class="table-responsive">
                    <center><table class="table">
                    <tr>
                        <th>Codigo</th>
                        <th>Produto</th>
                        <th>Descrição</th>
                        <th>Valor Unitario</th>
                        <th style="text-align: left">Comprar</th>
                    </tr>
                    <%
                        List<Produto> produtos = ProdutoDAO.MostrarProdutos();
                        for (int i = 0; i < produtos.size(); i++) {
                    %>
                    <tr>
                        <td><%out.print(produtos.get(i).getId());%></td>
                        <td><% out.print(produtos.get(i).getNome());%></td>
                        <td><% out.print(produtos.get(i).getDescricao());%></td>
                        <td>R$: <% out.print(produtos.get(i).getPrecoUnitario());%></td>
                        <td><a style="text-decoration:none" href="ControleCarrinho?acao=addProduto&idProduto=<%=produtos.get(i).getId()%>">
                                <span class="btn btn-primary">Add Carrinho</a></td>
                    </tr>
                    <%}%>
                </table>
            </div>
        </div>
    </body>
</html>