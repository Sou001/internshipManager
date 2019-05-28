<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Accueil</title>
  <link rel="shortcut icon" href="">
  <link rel="stylesheet" type="text/css" href=http://localhost:8080/internshipManager/public/css/mystyle.css>

</head>

<body style="background-color: grey">
  <header>
    <h1>Bienvenue <%= request.getSession().getAttribute("name") %> à votre compte </h1>

  </header>
  
      	
      <div class="form other">
        <form action = "users" method="get">
          	<input type="hidden" name="action" value="users">
          	<button>Gestion des comptes</button>
        </form>
          
        <form action = "survey" method="get">
          	<input type="hidden" name="action" value="survey">
          	<button>Gestion des questionnaires</button>
        </form>
        <form action = "profil" method="get" >
          	<input type="hidden" name="action" value="profil">
          	<button>Profil</button>
        </form>
        <form action = "newUser" method="get" >
          	<input type="hidden" name="action" value="newUser">
          	<button>Nouveau utilisateur</button>
        </form>
        <form action = "disconnect" method="get" >
          	<input type="hidden" name="action" value="disconnect">
          	<button>Déconnexion</button>
        </form>
        
      	</div>
        

</body>
</html>
