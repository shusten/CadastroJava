/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Windows
 */
public class Categoria {
    private int idCategoria;
    private String descricao;

    // ALT Insert construtor vazio
    public Categoria() {
    }
    
     //ALT Insert construtor com descrição - id auto_increment

    public Categoria(String descricao) {
        this.descricao = descricao;
    }
    

    //ALT Insert - gerar getters e setters

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
