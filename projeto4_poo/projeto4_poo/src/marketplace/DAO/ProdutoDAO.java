package marketplace.DAO;


import java.sql.PreparedStatement;

import java.sql.SQLException;

import marketplace.entity.Produto;
import marketplace.conexao.Conexao;

public class ProdutoDAO {

    public void insereProduto(Produto produto) {

        String sql = "INSERT INTO PRODUTO (nome, preco, quantidade, vendedor) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setInt(3, produto.getQuantidade());
            ps.setString(4, produto.getVendedor());

            ps.execute();
            ps.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
