/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.casadocodigo.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Embeddable;

/**
 *
 * @author Michel A. Medeiros
 */
@Embeddable
public class Preco implements Serializable {
    
    private BigDecimal valor;
    private TipoPreco tipoPreco;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoPreco getTipoPreco() {
        return tipoPreco;
    }

    public void setTipoPreco(TipoPreco tipoPreco) {
        this.tipoPreco = tipoPreco;
    }
    
    
    
}
