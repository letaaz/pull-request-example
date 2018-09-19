<%@page import="java.util.Collection"%>
<%@ page import="car.tp4.dataBase.Book" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>

        <h2>books's autors</h2>
        <%
            Collection<String > books = (Collection<String>) request.getAttribute("booksAutors");

            for (String book: books) {
                out.print("Author: " + book+"<br>");
                out.print("\n");
            }
        %>

        <br>
        <a href="../index.jsp">Go to Menu</a>

    </body>
</html>
