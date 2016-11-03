package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.DAO.LoginController;
import br.com.DAO.ProdutoDAO;
import java.util.List;
import br.com.controle.Produto;

public final class ProdutosAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      br.com.controle.Menu menu = null;
      synchronized (_jspx_page_context) {
        menu = (br.com.controle.Menu) _jspx_page_context.getAttribute("menu", PageContext.PAGE_SCOPE);
        if (menu == null){
          menu = new br.com.controle.Menu();
          _jspx_page_context.setAttribute("menu", menu, PageContext.PAGE_SCOPE);
        }
      }
      out.write(" \n");
      out.write("\n");
      out.write("\n");
 if (LoginController.estaLogado(request)) { 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>  \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/w3.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <!--CSS-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/principal.css\">\n");
      out.write("\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            out.print(menu.MostrarMenu());
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div>\n");
      out.write("            <a href=\"AddProduto.jsp\">Add Produtos</a>\n");
      out.write("        </div>\n");
      out.write("        <div>\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                <div class=\"table-responsive\">\n");
      out.write("                    <table class=\"table\">\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Codigo</th>\n");
      out.write("                                <th>Nome</th>\n");
      out.write("                                <th>Valor</th>\n");
      out.write("                                <th>Descricao</th>\n");
      out.write("                                <th></th>\n");
      out.write("                                <th></th>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                List<Produto> produto = ProdutoDAO.MostrarProdutos();
                                for (int i = 0; i < produto.size(); i++) { 
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("\n");
      out.write("                                <td>");
out.print(produto.get(i).getId());
      out.write("</td>\n");
      out.write("                                <td>");
out.print(produto.get(i).getNome());
      out.write("</td>\n");
      out.write("                                <td>");
out.print(produto.get(i).getPrecoUnitario());
      out.write("</td>\n");
      out.write("                                <td>");
 out.print(produto.get(i).getDescricao());
      out.write("</td>\n");
      out.write("                                <td><a style=\"text-decoration:none\" href=\"AlterarProduto?acao=alterar&idProduto=");
      out.print(produto.get(i).getId());
      out.write("\">\n");
      out.write("                                        <span class=\"glyphicon glyphicon-edit\" aria-hidden=\"true\"></span>Editar</a></td>\n");
      out.write("                                <td><a style=\"text-decoration:none\" href=\"ControleAdmin?acao=excluir&idProduto=");
      out.print(produto.get(i).getId());
      out.write("\">\n");
      out.write("                                        <span class=\"glyphicon glyphicon-trash\" aria-hidden=\"true\">Excluir</span></a></td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
 }
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
 } else {
        response.sendRedirect("Login.jsp");
    }

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
