<%@ page import="car.tp4.dataBase.Book" %>
<%@ page import="java.util.Collection" %>
<%@ page import="car.tp4.dataBase.Commande" %>
<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: romain
  Date: 11/04/18
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>

    <table border="1" style="border:solid black 1px;">
        <thead>
        <th>Id-book</th>
        <th>Quantite</th>

        </thead>
        <tbody>
        <%
            Collection<Commande> books = (Collection<Commande>) request.getAttribute("newCommande");

            for (Commande commande: books) {

                out.print("<tr>");

                out.print("<td>" + commande.getTitle() + "</td>");
                out.print("<td>" + commande.getQuantite() + "</td>");
                out.print("</tr>");

            }

            Enumeration e = session.getAttributeNames();
            System.out.print("GO" + e.hasMoreElements());
            while (e.hasMoreElements()) {
                String name = (String) e.nextElement();
                if(name.startsWith("panier") || name.startsWith("idpanier")) {
                    session.removeAttribute(name);
                }
            }
        %>
        </tbody>
    </table>
</head>
<body>

</body>
</html>
