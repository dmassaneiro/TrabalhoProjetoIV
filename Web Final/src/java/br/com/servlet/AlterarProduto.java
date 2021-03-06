package br.com.servlet;

import br.com.DAO.AdminDAO;
import br.com.controle.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego Massaneiro
 */
public class AlterarProduto extends HttpServlet {

    private Produto produto = new Produto();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String acao = request.getParameter("acao");
            if (acao.equals("alterar")) {
                int id = Integer.parseInt(request.getParameter("idProduto"));
                produto.setId(id);
                response.sendRedirect("AlterarProduto.jsp");
            }
        } catch (Exception erro) {
            request.setAttribute("erro", erro);
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idProduto"));
        produto.setId(id);
        response.sendRedirect("AlterarProduto.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        produto.setNome(request.getParameter("nome"));
        produto.setDescricao(request.getParameter("descricao"));
        produto.setPrecoUnitario(Double.parseDouble(request.getParameter("precoUnitario")));

        AdminDAO.AlterarProduto(produto.getNome(), produto.getDescricao(), produto.getPrecoUnitario(), produto.getId());
        response.sendRedirect("ProdutosAdmin.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
