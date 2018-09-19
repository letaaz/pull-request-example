<%--
  Created by IntelliJ IDEA.
  User: samlillett
  Date: 09/04/18
  Time: 01:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter Book information</title>
</head>
<body>
 <% if(session.getAttribute("title") != null &&
        session.getAttribute("nom_auteur") != null &&
        session.getAttribute("parution") != null){
     %>
 <FORM action="recap.jsp" method="post">
     <P>
         <LABEL for="titre">Titre : </LABEL>
         <INPUT type="text" name="title" value="<%session.getAttribute("title");%>"><BR>
         <LABEL for="nom_auteur">Nom  d'auteur: </LABEL>
         <INPUT type="text"  name="nom_auteur" value="<%session.getAttribute("nom_auteur");%>"><BR>
         <LABEL for="parution">Année de parution : </LABEL>
         <INPUT type="text"  name="parution" value="<%session.getAttribute("parution");%>"><BR>
         <INPUT type="submit" value="Envoyer">
         <INPUT type="reset">
     </P>
 </FORM>
 <%
        }else{
 %>
     <FORM action="recap.jsp" method="post">
         <P>
             <LABEL for="titre">Titre : </LABEL>
             <INPUT type="text" id="titre" name="title"><BR>
             <LABEL for="nom_auteur">Nom  d'auteur: </LABEL>
             <INPUT type="text" id="nom_auteur" name="nom_auteur"><BR>
             <LABEL for="parution">Année de parution : </LABEL>
             <INPUT type="text" id="parution" name="parution"><BR>
             <INPUT type="submit" value="Envoyer">
             <INPUT type="reset">
         </P>
     </FORM>
<%
 }
%>
</body>
</html>
