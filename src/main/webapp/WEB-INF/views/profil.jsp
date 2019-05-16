<%-- 
    Document   : admin
    Created on : 15 mai 2019, 22:58:44
    Author     : air
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Accueil</title>
  <link rel="stylesheet" type="text/css" href=http://localhost:8080/internshipManager/public/css/mystyle.css>
</head>
<body style="background-color:grey">
  <header>
    <h1 style = "color : #009999">Votre profil </h1>
  </header>
   
  <main>
    <article>
      	
      <div class="form other">
            <td>Name : <%= request.getSession().getAttribute("user") %></td>
            <td>email : <%= request.getSession().getAttribute("email") %></td>
            <td>society : <%= request.getSession().getAttribute("society") %></td>
            <td>Tel : <%= request.getSession().getAttribute("tel") %></td>
            <td>Date de création : <%= request.getSession().getAttribute("date") %></td>
     
      	</div>
        
 </article>
  </main>
</body>
</html>
