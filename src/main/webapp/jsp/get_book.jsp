<%@ page import="java.util.Collection" %>
<%@ page import="car.tp4.dataBase.Book" %><%--
  Created by IntelliJ IDEA.
  User: samlillett
  Date: 09/04/18
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get book</title>
</head>
<body>
<h2>books searched</h2>
<%--<%--%>
    <%--//Collection<String > books = (Collection<String>) request.getAttribute("book_searched");--%>
    <%--String books = (String)request.getAttribute("book_searched");--%>
    <%--//for (String book: books) {--%>
        <%--out.print("Book: " + books+"<br>");--%>
        <%--out.print("\n");--%>
    <%--//}--%>
<%--%>--%>
<table border="1" style="border:solid black 1px;">
    <thead>
    <th>Author</th>
    <th>Title</th>
    <th>Year</th>
    <th>Quantity</th>
    <th>Add the cart</th>

    </thead>
    <tbody>

    <%--<%--%>
        <%--Collection<Book> books = (Collection<Book>) request.getAttribute("book_searched");--%>

        <%--for (Book book: books) {--%>

            <%--out.print("<tr>");--%>

            <%--out.print("<td>" + book.getAuthor() + "</td>");--%>
            <%--out.print("<td>" + book.getTitle() + "</td>");--%>
            <%--out.print("<td>" + book.getYear() + "</td>");--%>
            <%--out.print("</tr>");--%>
            <%----%>

        <%--}--%>
    <%--%>--%>

    <%
        Collection<Book> books = (Collection<Book>) request.getAttribute("book_searched");
        int i =0;
        for (Book book: books) {

            out.print("<tr>");

            out.print("<td>" + book.getAuthor() + "</td>");
            out.print("<td>" + book.getTitle() + "</td>");
            out.print("<td>" + book.getYear() + "</td>");
            out.print("<td>" + book.getQuantity() + "</td>");
            if(book.getQuantity()>0){
    %>


    <td> <a href="get_book?idpanier-<%=book.getId()%>=<%= 1 %>">add to panier</a> </td>
    <%
    }else{
    %>
    <td>Out of stock</td>
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
