<%-- 
    Document   : ProdutosAdmin
    Created on : 02/11/2016, 09:44:20
    Author     : Diego Massaneiro
--%>

<%@page import="br.com.DAO.LoginController"%>
<%@page import="br.com.DAO.ProdutoDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.controle.Produto"%>
<jsp:useBean id="menu" class="br.com.controle.Menu"/> 


<% if (LoginController.estaLogado(request)) { %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="css/w3.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!--CSS-->
        <link rel="stylesheet" href="css/principal.css">

        <title>JSP Page</title>

    </head>
    <body>

        <%
            out.print(menu.MostrarMenu());
        %>
        <div>
            <center><h1>Todo os Produtos Registrados</h1></center>
        </div>

        <div>
            <center><a href="AddProduto.jsp" class="btn btn-primary"style=" position: absolute;top: 25%;left: 0.5%;
    width: 180px;">Add Produtos</a></center>
        </div>
        <div>
            <div class="container">

                <div class="table-responsive">
                    <center><table class="table">
                            <tr>
                                <th>Codigo</th>
                                <th>Nome</th>
                                <th>Valor</th>
                                <th>Descricao</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <%
                                List<Produto> produto = ProdutoDAO.MostrarProdutos();
                                for (int i = 0; i < produto.size(); i++) { %>
                            <tr>

                                <td><%out.print(produto.get(i).getId());%></td>
                                <td><%out.print(produto.get(i).getNome());%></td>
                                <td>R$: <%out.print(produto.get(i).getPrecoUnitario());%></td>
                                <td><% out.print(produto.get(i).getDescricao());%></td>
                                <td><a style="text-decoration:none" href="AlterarProduto?acao=alterar&idProduto=<%=produto.get(i).getId()%>">
                                        <span class="btn btn-primary"style="width: 80px" aria-hidden="true">Editar</span></a></td>
                                <td><a style="text-decoration:none" href="ControleAdmin?acao=excluir&idProduto=<%=produto.get(i).getId()%>">
                                        <span class="btn btn-warning"style="width: 80px" aria-hidden="true">Excluir</span></a></td>
                            </tr>
                            <% }%>
                        </table></center>
                </div>
            </div>
        </div>
    </body>
</html>
<% } else {
        response.sendRedirect("Login.jsp");
    }
%>