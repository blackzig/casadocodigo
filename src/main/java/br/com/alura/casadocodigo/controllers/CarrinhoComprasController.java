/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.casadocodigo.controllers;

import br.com.alura.casadocodigo.dao.ProdutoDAO;
import br.com.alura.casadocodigo.models.CarrinhoCompras;
import br.com.alura.casadocodigo.models.CarrinhoItem;
import br.com.alura.casadocodigo.models.Produto;
import br.com.alura.casadocodigo.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Michel A. Medeiros
 */
@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Autowired
    private CarrinhoCompras carrinho;

    @RequestMapping("/add")
    public ModelAndView add(Integer produtoId, TipoPreco tipoPreco) {
        ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
        CarrinhoItem carrinhoItem = criaItem(produtoId, tipoPreco);

        carrinho.add(carrinhoItem);
        
        return modelAndView;
    }

    private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipoPreco) {
        Produto produto = produtoDAO.find(produtoId);
        CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipoPreco);
        return carrinhoItem;
    }

}
