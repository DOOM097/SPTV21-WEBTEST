<%-- 
    Document   : newArticle
    Created on : Feb 10, 2023, 10:06:08 AM
    Author     : Anatoli
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Новая статья</title>
    </head>
    <body>
        <h1>Новая статья</h1>
        <form action="createArticle" method="POST">
            Заголовок <input type="text" name="caption"><br>
            <textarea rows="5" cols="20" name="text"></textarea><br>
            <select name="authorId">
                <c:forEach var="author" items="${listAuthors}">
                    <option value="${author.id}">${author.firstname} ${author.lastname}</option>
                </c:forEach>
            </select><br>
            <input type="submit" value="Создать статью">
        </form>
    </body>
</html>