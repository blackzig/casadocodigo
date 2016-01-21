/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.casadocodigo.controllers;

import br.com.alura.casadocodigo.dao.ProdutoDAO;
import br.com.alura.casadocodigo.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Michel A. Medeiros
 */
@Controller
public class ProdutosController {
    
    @Autowired
    private ProdutoDAO produtoDAO;
    
    @RequestMapping("/produtos/form")
    public String form(){
        return "produtos/form";
    }
    
    @RequestMapping("/produtos")
    public String gravar(Produto produto){
        produtoDAO.gravar(produto);
        return "produtos/ok";
    }
    
}
