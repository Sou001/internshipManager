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
  <link rel="stylesheet" type="text/css" href="public/css/mystyle.css" />
</head>
<body>
  <header>
    <h1>Bienvenue à votre compte</h1>
  </header>
  <main>
    <article>
    <div class = "form">
      		<h1 style="text-align : center"> Informations personnelles </h1>
      		<h1>${username}</h1>
      	</div>
      	
      	
      <div class="form other">
      	<h2 style="text-align : center"> Options</h2>
    	<form method="GET" >
          	<input type="hidden" name="action" value="messagerie">
          	<button>Gestion des questionnaires</button>
        </form>
        <form method="GET">
          	<input type="hidden" name="action" value="virement">
          	<button>Gestion des comptes</button>
        </form>
        <form method="GET" >
          	<input type="hidden" name="action" value="clients">
          	<button>Profile</button>
        </form>
        <form method="GET" >
          	<input type="hidden" name="action" value="disconnect">
          	<button>Déconnexion</button>
        </form>
        
      	</div>
      	
      	
      	
    </article>
  </main>
</body>
</html>
