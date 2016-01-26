/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.casadocodigo.controllers;

import br.com.alura.casadocodigo.dao.ProdutoDAO;
import br.com.alura.casadocodigo.infra.FileSaver;
import br.com.alura.casadocodigo.models.Produto;
import br.com.alura.casadocodigo.models.TipoPreco;
import br.com.alura.casadocodigo.validation.ProdutoValidation;
import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



/**
 *
 * @author Michel A. Medeiros
 */
@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoDAO produtoDAO;
    
    @Autowired
    private FileSaver fileSaver;
    
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){

        webDataBinder.addValidators(new ProdutoValidation());
    }

    @RequestMapping("/form")
    public ModelAndView form(Produto produto) {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        System.out.println("values " + Arrays.toString(TipoPreco.values()));
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView gravar(MultipartFile sumario,
            @Valid Produto produto, BindingResult bindingResult, 
            RedirectAttributes redirectAttributes) {
        
        if(bindingResult.hasErrors()){
            return form(produto);
        }
        
        String path = fileSaver.write("arquivos-sumario", sumario);
        System.out.println("path gravar "+path);
        produto.setSumarioPath(path);
        
        produtoDAO.gravar(produto);
        redirectAttributes.addFlashAttribute("Sucesso", "Produto cadastrado com sucesso.");
        return new ModelAndView("redirect:produtos");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Produto> produtos = produtoDAO.listar();
        ModelAndView modelAndView = new ModelAndView("produtos/lista");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }
    
    @RequestMapping("/detalhe/{id}")
    public ModelAndView detalhe(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("produtos/detalhes");
        Produto produto = produtoDAO.find(id);
        modelAndView.addObject("produto", produto);
        return modelAndView;
    }

}
