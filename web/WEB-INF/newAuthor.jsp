<%-- 
    Document   : newAuthor
    Created on : Feb 8, 2023, 3:08:41 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Новый автор</title>
    </head>
    <body>
        <h1>Создание нового автора</h1>
        <form action="createAuthor" method="POST">
            Имя: <input type="text" name="firstname"><br>
            Фамилия: <input type="text" name="lastname"><br>
            <input type="submit" value="Создать автора">
        </form>
    </body>
</html>
