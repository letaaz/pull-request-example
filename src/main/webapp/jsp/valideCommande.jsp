<%@ page import="java.util.Enumeration" %>
<%@ page import="javax.ejb.EJB" %>
<%@ page import="car.tp4.bean.BookBeanServiceItrf" %>
<%@ page import="car.tp4.dataBase.Commande" %><%--
  Created by IntelliJ IDEA.
  User: samlillett
  Date: 16/04/18
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Valide commande</title>
</head>
<body>
<%
    out.print("PANIER : </BR>");
    Enumeration e = session.getAttributeNames();
    System.out.print("GO" + e.hasMoreElements());
    while (e.hasMoreElements()) {
        String name = (String) e.nextElement();
        if(name.startsWith("panier")) {
            Commande commande = (Commande)session.getAttribute(name);
            out.println(commande.getTitle() + "      " + "Quantité : ");
            out.println(commande.getQuantite() + "<BR>");
        }
    }
%>
</body>
</html>
