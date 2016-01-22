<%-- 
    Document   : form
    Created on : 20/01/2016, 21:17:26
    Author     : Michel A. Medeiros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
            <div>
                <label>${tipoPreco}</label>
                <input type="text" name="precos[${status.index}].valor">
                <input type="hidden" name="precos[${status.index}].tipoPreco" value="${tipoPreco}">
            </div>
        </c:forEach>
        <c:forEach var="counter" begin="1" end="10" step="1" >
            <c:out value="${counter-5}"/></br>
            <% System.out.println("counter= "
                        + pageContext.findAttribute("counter"));%>
        </c:forEach>
        <button type="submit">Cadastrar</button>
    </form>
</html>
