<%-- 
    Document   : lista
    Created on : 22/01/2016, 16:21:11
    Author     : MAM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livros de Programação</title>
    </head>
    <h1>Lista de Produtos</h1>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Título</th>
                    <th>Descrição</th>
                    <th>Páginas</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${produtos}" var="produto">
                    <tr>
                        <td> <a href="${s:mvcUrl('PC#detalhe').arg(0,produto.id).build()}">${produto.titulo}</a></a></td>
                        <td>${produto.descricao}</td>
                        <td>${produto.paginas}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
