/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.casadocodigo.controllers;

import br.com.alura.casadocodigo.dao.ProdutoDAO;
import br.com.alura.casadocodigo.models.Produto;
import br.com.alura.casadocodigo.models.TipoPreco;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Michel A. Medeiros
 */
@Controller
public class ProdutosController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping("/produtos/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        System.out.println("values " + Arrays.toString(TipoPreco.values()));
        return modelAndView;
    }

    @RequestMapping(value="/produtos", method = RequestMethod.POST)
    public String gravar(Produto produto) {
        produtoDAO.gravar(produto);
        return "produtos/ok";
    }

    @RequestMapping(value="/produtos", method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Produto> produtos = produtoDAO.listar();
        ModelAndView modelAndView = new ModelAndView("produtos/lista");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

}
