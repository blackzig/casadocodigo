/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.casadocodigo.models;

/**
 *
 * @author Michel A. Medeiros
 */
public class CarrinhoItem {

    private Produto produto;
    private TipoPreco tipoPreco;
    
    public CarrinhoItem(Produto produto, TipoPreco tipoPreco) {
       this.produto = produto;
       this.tipoPreco = tipoPreco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public TipoPreco getTipoPreco() {
        return tipoPreco;
    }

    public void setTipoPreco(TipoPreco tipoPreco) {
        this.tipoPreco = tipoPreco;
    }
    
    
    
}
