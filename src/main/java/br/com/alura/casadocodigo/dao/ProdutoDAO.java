/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.casadocodigo.dao;

import br.com.alura.casadocodigo.models.Produto;
import java.util.List;
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
    
    public List<Produto> listar(){
        return manager.createQuery("select p from Produto p", Produto.class).getResultList();
    }
    
    public Produto find(Integer id) {
        return manager.createQuery("select distinct(p) from Produto p "
                + "join fetch p.precos preco where p.id = :id", Produto.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    
}
