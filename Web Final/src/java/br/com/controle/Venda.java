package br.com.controle;

/**
 *
 * @author Diego Massaneiro
 */
public class Venda {
    private Integer idProduto;
    private int qtde;
    private double valorTotal;
    
    public Venda() {
        this.idProduto = idProduto;
        this.qtde = qtde;
        this.valorTotal = valorTotal;
    }
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
