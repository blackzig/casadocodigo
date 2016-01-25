/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.casadocodigo.infra;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Michel A. Medeiros
 */
@Component
public class FileSaver {

    @Autowired
    private HttpServletRequest request;

    public String write(String baseFolder, MultipartFile file) {
        try {
            System.out.println("baseFolder " + baseFolder);
            System.out.println("file " + file);


            String realPath = request.getServletContext().getRealPath("/")+baseFolder;
            //String realPath = "H:\\Alura\\casadocodigo\\src\\main\\webapp\\arquivos-sumario";
            System.out.println("realPath " + realPath);
            String path = realPath + "\\" + file.getOriginalFilename();
            
          //  String filePath = request.getServletContext().getRealPath("/");
            
            System.out.println("path " + path);
            file.transferTo(new File(path));
            
            System.out.println("retorno " + baseFolder + "\\" + file.getOriginalFilename());
            return baseFolder + "/" + file.getOriginalFilename();
        } catch (IOException | IllegalStateException ex) {
            throw new RuntimeException(ex);
        }

    }

}
