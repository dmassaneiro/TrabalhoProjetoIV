package br.com.DAO;

import br.com.conexao.Mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Diego Massaneiro
 */
public class AdminDAO {
    
    public static void ExcluirProduto(int id) {

        // Comando SQL
        String sql = "DELETE FROM produto WHERE id = ?";

        // Statments
        try {
            PreparedStatement preparadorSQL = Mysql.getConexaoMySQL().prepareStatement(sql);
            preparadorSQL.setInt(1, id);
            // Commit no banco
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void AlterarProduto(String nome, String descricao, double precoUnitario, int id) {

        // Comando SQL
        String sql = "UPDATE produto SET nome = ?, descricao = ?, valor = ? WHERE id = ?";

        // Statments
        try {
            PreparedStatement preparadorSQL = Mysql.getConexaoMySQL().prepareStatement(sql);
            preparadorSQL.setString(1, nome);
            preparadorSQL.setString(2, descricao);
            preparadorSQL.setDouble(3, precoUnitario);
            preparadorSQL.setInt(4, id);
            // Commit no banco
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
    public static void CadastrarProduto(String idProduto, String nome, String descricao, double precoUnitario) {

        // Comando SQL
        String sql = "insert into produto (id, nome, descricao, valor) values (?, ?, ?, ?)";

        // Statments
        try {
            PreparedStatement preparadorSQL = Mysql.getConexaoMySQL().prepareStatement(sql);
            preparadorSQL.setString(1, idProduto);
            preparadorSQL.setString(2, nome);
            preparadorSQL.setString(3, descricao);
            preparadorSQL.setDouble(4, precoUnitario);
            // Commit no banco
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static String UltimaSequencia(String tabela, String atributo) {
        
        String sql = "SELECT COALESCE(MAX( " + atributo+" + 1),0) AS ULTIMO FROM " +tabela;
        String ultimo = "";
        
        Connection conexao = null;
        try {
            conexao = Mysql.getConexaoMySQL();
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ultimo = rs.getString("ULTIMO");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ultimo;
    }
}
