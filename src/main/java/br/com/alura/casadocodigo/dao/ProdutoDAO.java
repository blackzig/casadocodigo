/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.casadocodigo.dao;

import br.com.alura.casadocodigo.models.Produto;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Michel A. Medeiros
 */
@Repository
@Transactional
public class ProdutoDAO {
    
    @PersistenceContext
    private EntityManager manager;
    
    public void gravar(Produto produto){
        manager.persist(produto);
    }
    
}
