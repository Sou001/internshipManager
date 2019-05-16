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
    <!h1Bienvenue = request.getSession().getAttribute("user") %à votre compte : </h1>

  </header>
   
  <main>
    <article>

    <div class = "form">
      		<h1 style="text-align : center"> Informations personnelles </h1>
      		<h1>${username}</h1>
      	</div>
      	
      <div class="form other">
    	<form action = "questionnaire" method="post" >
          	<input type="hidden" name="action" value="questionnaire">
          	<button>Gestion des questionnaires</button>
        </form>
        <form action = "comptes" method="post">
          	<input type="hidden" name="action" value="comptes">
          	<button>Gestion des comptes</button>
        </form>
        <form action = "profil" method="post" >
          	<input type="hidden" name="action" value="profil">
          	<button>Profil</button>
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
