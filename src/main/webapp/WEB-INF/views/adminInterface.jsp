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
  <link rel="stylesheet" type="text/css" media="all"  href="/public/css/mystyle.css" />
</head>
<body>
  <header>
    <h1>Bienvenue <%= request.getSession().getAttribute("user") %> à votre compte </h1>
  </header>
  <main>
    <article>
      	
      	
      <div class="form other">
    	<form action = "questionnaire" method="post" >
          	<input type="hidden" name="action" value="questionnaire">
          	<button>Gestion des questionnaires</button>
        </form>
        <form action = "comptes" method="post">
          	<input type="hidden" name="action" value="comptes">
          	<button>Gestion des comptes</button>
        </form>
        <form action = "profile" method="post" >
          	<input type="hidden" name="action" value="profile">
          	<button>Profile</button>
        </form>
        <form action = "disconnect" method="post" >
          	<input type="hidden" name="action" value="disconnect">
          	<button>Déconnexion</button>
        </form>
        
      	</div>
      	
      	
      	
    </article>
  </main>
</body>
</html>
