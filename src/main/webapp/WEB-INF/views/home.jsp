<%-- 
    Document   : home
    Created on : 19/01/2016, 21:51:28
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
    <body>

    <c:forEach var="counter" begin="1" end="10" step="1" >
        <c:out value="${counter-5}"/></br>
        <% System.out.println("counter= "
               + pageContext.findAttribute("counter"));%>
    </c:forEach>
    
    <h1>Casa do Código</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Livros</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>JAVA</td>
            </tr>
            <tr>
                <td>C#</td>
            </tr>
            <tr>
                <td>AngularJS</td>
            </tr>
            <tr>
                <td>WebServices</td>
            </tr>
        </tbody>
    </table>

</body>
</html>
