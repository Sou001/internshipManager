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
    <h1 style = "color : #009999">Informations personnelles </h1>
  </header>
   
  <main>
  <table class  = "users" style="width: 100%">
            
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Email</th>
                    <th>Société</th>
                    <th>Coordonnées téléphoniques</th>
                    <th>Date de création</th>
                    <th>État du compte</th>
                    <th>Fonction</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                        <td><%= request.getSession().getAttribute("name") %></td>
                        <td><%= request.getSession().getAttribute("email") %></td>
                        <td><%= request.getSession().getAttribute("society") %></td>
                        <td><%= request.getSession().getAttribute("tel") %></td>
                        <td><%= request.getSession().getAttribute("date") %></td>
                        <td><%= request.getSession().getAttribute("state") %></td>
                        <td><%= request.getSession().getAttribute("role") %></td>
                </tr>
            
            </tbody>
</table>
 
  </main>
</body>
</html>
