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
public class Produto {
    private int idProduto;
    private String descricao;
    private int qtd;
    private double valor;
    private Categoria categoria; //Composição - objeto da classe Categoria

    public Produto() {
    }

    public Produto(String descricao, int qtd, double valor, Categoria categoria) {
        this.descricao = descricao;
        this.qtd = qtd;
        this.valor = valor;
        this.categoria = categoria;
    }
    
    
    
    //Alt Insert getters e setters

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}
