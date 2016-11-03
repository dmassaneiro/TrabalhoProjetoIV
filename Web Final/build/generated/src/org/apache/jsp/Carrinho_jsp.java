package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.controle.ItemDeCompra;
import br.com.controle.CarrinhoDeCompra;

public final class Carrinho_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
      br.com.controle.Menu menu = null;
      synchronized (_jspx_page_context) {
        menu = (br.com.controle.Menu) _jspx_page_context.getAttribute("menu", PageContext.PAGE_SCOPE);
        if (menu == null){
          menu = new br.com.controle.Menu();
          _jspx_page_context.setAttribute("menu", menu, PageContext.PAGE_SCOPE);
        }
      }
      out.write("  \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Carrinho de Compras</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/w3.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/meu-estilo.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/principal.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <!-- Navbar -->\n");
      out.write("        ");

            if(request.getSession() == null){
               request.getSession(true);
             }
            
            out.print(menu.MostrarMenu());
        
      out.write("\n");
      out.write("\n");
      out.write("        <div>\n");
      out.write("            <center><h1>Seus Iten(s) para Compra</h1></center>\n");
      out.write("            <div class=\"table-responsive\">\n");
      out.write("                <center><table class=\"table\">\n");
      out.write("                        <tr>\n");
      out.write("                            \n");
      out.write("                            <th>Item</font></th>\n");
      out.write("                            <th>Quantidade</font></th>\n");
      out.write("                            <th>Preço Unitário</font></th>\n");
      out.write("                            <th>Total Item</font></th>\n");
      out.write("                            <th>Adicionar</font></th>\n");
      out.write("                            <th>Remover</font></th>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                            //recupera os produtos do carrinho da sessao
                            CarrinhoDeCompra carrinho = (CarrinhoDeCompra) session.getAttribute("carrinho");
                            for (ItemDeCompra item : carrinho.getItens()) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            \n");
      out.write("                            <td>");
      out.print(item.getProduto().getNome());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(item.getQuantidade());
      out.write("</td>\n");
      out.write("                            <td>R$: ");
      out.print(item.getProduto().getPrecoUnitario());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(item.getTotal());
      out.write("</td>\n");
      out.write("                            <td><a href=\"ControleCarrinho?acao=addProduto&idProduto=");
      out.print(item.getProduto().getId());
      out.write("\"\n");
      out.write("                                   class=\"btn btn-primary\">ADD +1 </a>\n");
      out.write("                            </td>\n");
      out.write("                            <td><a href=\"ControleCarrinho?acao=removeProduto&idProduto=");
      out.print(item.getProduto().getId());
      out.write("\"\n");
      out.write("                                   class=\"btn btn-warning\">Retirar</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                    </table></center>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <strong class=\"total\"><h4>Valor Total R$: </br><b>");
      out.print(carrinho.calculaTotal());
      out.write("</b></h4></strong><br/>\n");
      out.write("    \n");
      out.write("    <button class=\"btn btn-success\">\n");
      out.write("        <a style=\"text-decoration:none\" href=\"ControleCarrinho?acao=finalizarCompra\">Finalizar compra</a>\n");
      out.write("    </button></br>\n");
      out.write("    <button class=\"btn btn-info\">\n");
      out.write("        <a style=\"text-decoration:none\" href=\"AddCarrinho.jsp\">Continue comprando</a>\n");
      out.write("    </button></br>\n");
      out.write("    <button class=\"btn btn-danger\">\n");
      out.write("        <a style=\"text-decoration:none\" href=\"ControleCarrinho?acao=cancelaCompra\">Cancelar comprar</a>\n");
      out.write("    </button>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
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
