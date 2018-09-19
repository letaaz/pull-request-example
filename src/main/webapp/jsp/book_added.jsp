<%@ page import="car.tp4.dataBase.Book" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: samlillett
  Date: 09/04/18
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Added</title>
</head>
<body>
  <h1>Result :</h1>
  <p>Book added : </p>
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
          e.printStackTrace();
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

  <div>
      <a href="jsp/add_book.jsp">add new book</a>
      <br/>
      <a href="../index.jsp">Go to Menu</a>
  </div>
</body>
</html>
