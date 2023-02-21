<%-- 
    Document   : index
    Created on : Feb 8, 2023, 3:22:29 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SPTV21WebTest</title>
        <style>
            .button {
                border: none;
                color: lightskyblue;
                padding: 16px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 20px;
                margin: 4px 2px;
                transition-duration: 0.4s;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        
        <h1 class="">Статьи:</h1>
        <ol>
            <c:forEach var="article" items="${listArticles}">
                <li><a href="article?articleId=${article.id}">${article.caption}</a></li>
            </c:forEach>
        </ol>
        <br>
        <a href="newArticle"><button class="button">Добавить новую статью</button></a><br>
        <a href="newAuthor"><button class="button">Добавить нового автора</button></a>
    </body>
</html>
