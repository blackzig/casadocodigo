/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.casadocodigo.validation;

import br.com.alura.casadocodigo.models.Produto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Michel A. Medeiros
 */
public class ProdutoValidation implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Produto.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");

        Produto produto = (Produto) target;
        if (produto.getPaginas() <= 0) {
            errors.rejectValue("paginas", "field.required");
        }
    }

}
