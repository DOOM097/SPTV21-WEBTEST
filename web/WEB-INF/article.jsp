<%-- 
    Document   : article
    Created on : Feb 10, 2023, 10:39:29 AM
    Author     : sillamae kutsekool
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Вывод статьи</title>
    </head>
    <body>
        <h1>Заголовок: ${article.caption}</h1>
        <p>${article.text}</p>
        <p>Дата публикации: ${article.date}. Автор: ${article.author.firstname} ${article.author.lastname}</p>
        
    </body>
</html>
