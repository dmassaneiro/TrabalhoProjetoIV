package br.com.servlet;

import br.com.DAO.ProdutoDAO;
import br.com.DAO.VendaDAO;
import br.com.controle.CarrinhoDeCompra;
import br.com.controle.ItemDeCompra;
import br.com.controle.Produto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego Massaneiro
 */
public class ControleCarrinho extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String acao = request.getParameter("acao");
            if (acao.equals("addProduto")) {
//recupera o id do produto que deve ser add no carrinho
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));
//flag para controle de inserção de novos produtos no carrinho
                boolean existe = false;
//recupera a sessão pertencente ao request
                HttpSession sessao = request.getSession();
//recupera um carrinho de produtos da sessão
//se não exite um carrinho na sessão o valor será igual a null
                CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");
//verifica se já exista um carrinho na sessao
                if (carrinho == null) {
//cria um carrinho
                    carrinho = new CarrinhoDeCompra();
                    sessao.setAttribute("carrinho", carrinho);
                }
//verifica se o produto existe no carrinho
                if (carrinho.getItens() != null) {
                    for (ItemDeCompra item : carrinho.getItens()) {
                        if (item.getProduto().getId() == idProduto) {
//incrementa a quantidade
                            item.setQuantidade(item.getQuantidade() + 1);
                            existe = true;
                        }
                    }
                }
//se não existe o item ou produto, cria um novo
                if (existe == false) {
//encontra o produto no banco
                    Produto produto = new ProdutoDAO().consultarPorId(idProduto);
//cria um novo item
                    ItemDeCompra novoItem = new ItemDeCompra();
                    novoItem.setProduto(produto);
                    novoItem.setQuantidade(1);
//adiciona novo item
                    carrinho.addNovoItem(novoItem);
                }
//carrega a pagina do carrinho de compras
                request.getRequestDispatcher("Carrinho.jsp").forward(request, response);
            }//fim addProduto
            else if (acao.equals("removeProduto")) {
//recupera a sessão pertencente ao request
                HttpSession sessao = request.getSession();
//recupera um carrinho de produtos da sessão
                CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");
//recupera o id do produto
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));
                ItemDeCompra itemRemove = new ItemDeCompra();
                Produto prodRemove = new Produto();
                prodRemove.setId(idProduto);
                itemRemove.setProduto(prodRemove);
                carrinho.removerItem(itemRemove);
//carrega a pagina do carrinho de compras
                request.getRequestDispatcher("Carrinho.jsp").forward(request, response);
            } else if (acao.equals("cancelaCompra")) {
//recupera a sessão pertencente ao request
                HttpSession sessao = request.getSession();
//remove o carrinho da sessão
                sessao.removeAttribute("carrinho");
//redireciona para pagina principal
                response.sendRedirect("AddCarrinho.jsp");
            } else if (acao.equals("finalizarCompra")) {
                HttpSession sessao = request.getSession();
                CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");
                String cdVenda = VendaDAO.UltimaSequencia("venda", "idvenda");
                for (ItemDeCompra item : carrinho.getItens()) {
                    VendaDAO.Cadastrar(cdVenda, item.getProduto().getId(), item.getQuantidade(), item.getTotal());
                }
                response.sendRedirect("ControleCarrinho?acao=cancelaCompra");
            } else if (acao.equals("visualizar")) {
                boolean existe = false;
                HttpSession sessao = request.getSession();
                CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");
                request.getRequestDispatcher("carrinho.jsp").forward(request, response);
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
