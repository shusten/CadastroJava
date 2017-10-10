/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Categoria;
import model.bean.Produto;


/**
 *
 * @author Windows
 */
public class ProdutoDAO {
    private Connection con = null;
    
    //Alt insert construtor

    public ProdutoDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    //Inserindo um produto
    public boolean save(Produto produto){
        String sql = "INSERT INTO produto (descricao,qtd, valor, idCategoria) VALUES (?,?,?,?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,produto.getDescricao());
            stmt.setInt(2, produto.getQtd());
            stmt.setDouble(3, produto.getValor());
            stmt.setInt(4, produto.getCategoria().getIdCategoria());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Listando todos os produtos
    public List<Produto> findAll(){
        String sql = "SELECT idCategoria, idProduto, p.descricao AS pdesc, qtd, valor, c.descricao AS cdesc FROM produto AS p INNER JOIN categoria AS c USING(idCategoria)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareCall(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setDescricao(rs.getString("pdesc"));
                produto.setQtd(rs.getInt("qtd"));
                produto.setValor(rs.getDouble("valor"));
                
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setDescricao(rs.getString("cdesc"));
                
                produto.setCategoria(categoria);
                
                
                produtos.add(produto);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;
        
    }
    
}
