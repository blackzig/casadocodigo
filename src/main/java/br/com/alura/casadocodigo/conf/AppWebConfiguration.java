/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.casadocodigo.conf;

import br.com.alura.casadocodigo.controllers.HomeController;
import br.com.alura.casadocodigo.dao.ProdutoDAO;
import br.com.alura.casadocodigo.infra.FileSaver;
import br.com.alura.casadocodigo.models.CarrinhoCompras;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;

import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author Michel A. Medeiros
 */
@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class, ProdutoDAO.class,
    FileSaver.class, CarrinhoCompras.class})
public class AppWebConfiguration {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        
        resolver.setExposedContextBeanNames("carrinhoCompras");

        return resolver;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource rrbms = new ReloadableResourceBundleMessageSource();
        rrbms.setBasename("/WEB-INF/message");
        rrbms.setDefaultEncoding("UTF-8");
        rrbms.setCacheSeconds(1);

        return rrbms;
    }

    @Bean
    public FormattingConversionService mvcConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        DateFormatterRegistrar dateFormatterRegistrar = new DateFormatterRegistrar();
        dateFormatterRegistrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
        dateFormatterRegistrar.registerFormatters(conversionService);

        return conversionService;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

}
