<%@page import="car.tp4.dataBase.Book"%>
<%@page import="java.util.Collection"%>
<%@ page import="java.util.Enumeration" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>

        <h2>Existing books</h2>
        <table border="1" style="border:solid black 1px;">
            <thead>
                <th>Author</th>
                <th>Title</th>
                <th>Year</th>
                <th>Quantity</th>
                <th>Add the cart</th>

            </thead>
            <tbody>

        <%
            Collection<Book> books = (Collection<Book>) request.getAttribute("books");
            int i =0;
            for (Book book: books) {

                out.print("<tr>");

                out.print("<td>" + book.getAuthor() + "</td>");
                out.print("<td>" + book.getTitle() + "</td>");
                out.print("<td>" + book.getYear() + "</td>");
                out.print("<td>" + book.getQuantity() + "</td>");
                if(book.getQuantity()>0){
        %>


                <td> <a href="list_books?idpanier-<%=book.getId()%>=<%= 1 %>">add to panier</a> </td>
        <%
                }else{
        %>
                <td> Out of stock </td>
        <%
            }
        %>

        <%
                i++;
            }
        %>

            </tbody>
        </table>

        <br>
        <a href="../index.jsp">Go to Menu</a><br>
        <a href="list_books?order=asc">Order by year (ascending)</a><br>
        <a href="list_books?order=desc">Order by year (descending)</a><br>
        <a href="list_books?getatt=getatt">getAtt</a>
        <a href="validecommande">Valide Commande</a>

    </body>
</html>
