package br.com.servlet;

import br.com.DAO.ProdutoDAO;
import br.com.controle.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego Massaneiro
 */
public class ControleProduto extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String acao = request.getParameter("acao");
            if (acao.equals("listaProdutos")) {
//monta uma lista para exibição na pagina principal
                ArrayList<Produto> produtos = new ProdutoDAO().listar();
//armazena os produto na requisição
                request.setAttribute("produtos", produtos);
//invia para index.jsp
                request.getRequestDispatcher("produtos.jsp").forward(request, response);
            }
        } catch (Exception erro) {
            request.setAttribute("erro", erro);
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
