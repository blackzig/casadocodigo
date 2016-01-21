<%-- 
    Document   : form
    Created on : 20/01/2016, 21:17:26
    Author     : Michel A. Medeiros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livros de Programação</title>
    </head>
    <form action="/casadocodigo/produtos" method="post">
        <div>
            <label>Título</label>
            <input type="text" name="titulo" />
        </div>
        <div>
            <label>Descrição</label>
            <textarea rows="10" cols="20" name="descricao"></textarea>
        </div>
        <div>
            <label>Páginas</label>
            <input type="text" name="paginas"/>
        </div>
        <button type="submit">Cadastrar</button>
    </form>
</html>
