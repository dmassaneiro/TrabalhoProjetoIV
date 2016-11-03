<%-- 
    Document   : AlterarProduto
    Created on : 02/11/2016, 10:15:01
    Author     : Diego Massaneiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/meu-estilo.css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <h1 class="text-center login-title">Insira os campos Para Cadastrar</h1>
                    <div class="span6">
                        <form class="form-signin" action="ControleAdmin" method="POST">
                            <input type="text" class="form-control" placeholder="Nome Produto" name="nome" required autofocus>
                            <input type="text" class="form-control" placeholder="Descrição" name="descricao" required>
                            <input type="number" class="form-control" placeholder="Preço Unitario" name="precoUnitario" required>
                            <button class="btn btn-lg btn-primary btn-block" type="submit">Cadastrar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
