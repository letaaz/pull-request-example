<%@ page import="car.tp4.dataBase.Book" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: samlillett
  Date: 09/04/18
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get book by Autors</title>
</head>
<body>
<h2>books founded</h2>

<%--<table border="1" style="border:solid black 1px;">--%>
    <%--<thead>--%>
    <%--<th>Author</th>--%>
    <%--<th>Title</th>--%>
    <%--<th>Year</th>--%>

    <%--</thead>--%>
    <%--<tbody>--%>
    <%--<%--%>
        <%--Collection<Book> books = (Collection<Book>) request.getAttribute("book_author_searched");--%>

        <%--for (Book book: books) {--%>

            <%--out.print("<tr>");--%>

            <%--out.print("<td>" + book.getAuthor() + "</td>");--%>
            <%--out.print("<td>" + book.getTitle() + "</td>");--%>
            <%--out.print("<td>" + book.getYear() + "</td>");--%>



            <%--out.print("</tr>");--%>

            <%--//out.print("Author: " + book.getAuthor() + ", Title: " + book.getTitle() + ", Year: " + book.getYear());--%>
            <%--//out.print("\n");--%>
            <%--//out.print("<br/>");--%>

        <%--}--%>
    <%--%>--%>
    <%--</tbody>--%>
<%--</table>--%>

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
        Collection<Book> books = (Collection<Book>) request.getAttribute("book_author_searched");
        int i =0;
        for (Book book: books) {

            out.print("<tr>");

            out.print("<td>" + book.getAuthor() + "</td>");
            out.print("<td>" + book.getTitle() + "</td>");
            out.print("<td>" + book.getYear() + "</td>");
            out.print("<td>" + book.getQuantity() + "</td>");
            if(book.getQuantity()>0){
    %>


    <td> <a href="getBookByAuthor?idpanier-<%=book.getId()%>=<%= 1 %>">add to panier</a> </td>
    <%
    }else{
    %>
    <td> Out of stock</td>
    <%
        }
    %>
    out.print("</tr>");

    <%
            i++;
        }
    %>

    </tbody>
</table>
<br>
<a href="../index.jsp">Go to Menu</a>
</body>
</html>
