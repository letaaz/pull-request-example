<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recup</title>
    </head>

    <body>
    <%
        session.setAttribute("title",request.getParameter("title"));
        session.setAttribute("nom_auteur",request.getParameter("nom_auteur"));
        session.setAttribute("parution",request.getParameter("parution"));

    %>
    <h1>Informations</h1>
    </body>

    <table>
        <tr>
            <td>Title</td>
            <td><%= request.getParameter("title")%></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><%= request.getParameter("nom_auteur")%></td>
        </tr>
        <tr>
            <td>Book year</td>
            <td><%= request.getParameter("parution")%></td>
        </tr>
    </table>
</html>