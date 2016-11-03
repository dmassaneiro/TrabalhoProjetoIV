package br.com.servlet;

import br.com.DAO.LoginController;
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
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        if (LoginController.login(usuario, senha)) {
            response.addCookie(LoginController.getCookie("usuario", usuario));
            response.addCookie(LoginController.getCookie("senha", senha));

            response.sendRedirect("ProdutosAdmin.jsp");
        } else {
            response.sendRedirect("");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
