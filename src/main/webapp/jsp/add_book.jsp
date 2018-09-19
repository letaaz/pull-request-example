<%@ page import="car.tp4.dataBase.Book" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: romain
  Date: 08/04/18
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add book</title>
</head>
<body>

<%
    String title = (String) request.getAttribute("title");
    String author = (String) request.getAttribute("author");
    String year = (String) request.getAttribute("year");

    try{
        Collection<Book> books = (Collection<Book>) request.getAttribute("newBook");


    for (Book book: books) {
        title = book.getTitle();
        author = book.getAuthor();
        year = book.getYear() ;
    }
    }catch (NullPointerException e){

    }
    if (title == null) {
        title = "";
    }

    if(author == null)
    {
        author = "";
    }


    if(year == null)
    {
      year = "";

    }
%>


<h2> Add new book </h2>
<FORM action="http://localhost:8080/add_book" method="post">
    <P>
        <LABEL for="titre">Titre : </LABEL>
        <INPUT type="text" id="titre" name="titre" <% out.print(" value=\"" + title + "\""); %>><BR>
        <LABEL for="nom_auteur">Nom  d'auteur: </LABEL>
        <INPUT type="text" id="nom_auteur" name="nom_auteur" <% out.print(" value=\"" + author + "\""); %>><BR>
        <LABEL for="parution">Année de parution : </LABEL>
        <INPUT type="number" id="parution" name="parution" <% out.print(" value=\"" + year + "\""); %>><BR>
        <INPUT type="submit" value="Envoyer"> <INPUT type="reset">
    </P>
</FORM>

<h2>Informations saisies : </h2>
<p> Titre :<%
    out.print(title);
    %>
</p>

<br/>
<p>Auteur :<%
    out.print(author);
    %>
</p>

<br/>
<p>Année : <%
    out.print(year);
    %>
</p>

<br/>

</body>
</html>
