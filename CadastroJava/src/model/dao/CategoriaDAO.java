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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Categoria;

/**
 * CRUD
 * Create
 * Read
 * Update
 * Delete
 * @author Windows
 */
public class CategoriaDAO {
    private Connection con = null;

   //alt insert construtor     
    public CategoriaDAO() {
        //Cria a conexão com o banco de dados
        con = ConnectionFactory.getConnection();
    }
    
    //Inserindo uma categoria
    public boolean save(Categoria categoria){
        String sql = "INSERT INTO categoria (descricao) VALUES (?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,categoria.getDescricao());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //Listando todas as categorias
    public List<Categoria> findAll(){
        String sql = "SELECT * from categoria";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Categoria> categorias = new ArrayList<>();
        
        try {
            stmt = con.prepareCall(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setDescricao(rs.getString("descricao"));
                categorias.add(categoria);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return categorias;
        
    }
    
    //Copiar o método de inserção de categoria
    //Atualizando uma categoria
    public boolean update(Categoria categoria){
        String sql = "UPDATE categoria SET descricao= ? WHERE idCategoria = ?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,categoria.getDescricao());
            stmt.setInt(2, categoria.getIdCategoria());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    //Copiar o método de atualização de categoria
    //Apagando uma categoria
    public boolean delete(Categoria categoria){
        String sql = "DELETE FROM categoria WHERE idCategoria = ?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, categoria.getIdCategoria());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
}
