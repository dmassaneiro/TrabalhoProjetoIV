package br.com.controle;

/**
 *
 * @author Diego Massaneiro
 */
public class Menu {

    public String MostrarMenu() {
        String menu = "<div class=\"scrollmenu\">\n"
                + "            <a href=\"Principal.jsp\">Home</a>\n"
                + "            <a href=\"ProdutosAdmin.jsp\">Admin</a>\n"
                + "            <a href=\"AddCarrinho.jsp\">Produto</a>\n"
                + "            <a href=\"Carrinho.jsp\">Carrinho</a>\n"
                + "        </div>";
        return menu;
    }
}
