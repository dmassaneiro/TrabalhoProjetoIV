<%-- 
    Document   : Principal
    Created on : 02/11/2016, 09:40:30
    Author     : Diego Massaneiro
--%>

<jsp:useBean id="menu" class="br.com.controle.Menu"/> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Principal</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!--CSS-->
        <link rel="stylesheet" href="css/principal.css">

    </head>
    <body>
        <%
            out.print(menu.MostrarMenu());
        %>
    <center><h1>Servidor Web<br>E-commerce</h1></center>
    </body>
</html>
