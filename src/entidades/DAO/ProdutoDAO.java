package entidades.DAO;


import dataBase.DataBaseConnect;
import entidades.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
    public static void insertProduto(Produto produto) {
        try (Connection con = DataBaseConnect.getConnection()) {
            String query = "INSERT INTO produtos (nome_produto, descricao, preco, data_adicionado) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setTimestamp(4, produto.getDataAdicionado());

            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto");
            System.out.println(e.getMessage());
        }
    }
}
