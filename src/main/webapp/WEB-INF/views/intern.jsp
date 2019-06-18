<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <meta http-equiv="pragma" content="no-cache" />
  <meta http-equiv="cache-control" content="no-store, no-cache, must-revalidate, post-check=0, pre-check=0, no-cache="set-cookie" />
    
  <title>Intern Acceuil</title>
  <link rel="shortcut icon" href="">
  <link rel="stylesheet" type="text/css" href=http://localhost:8080/internshipManager/public/css/mystyle.css>

</head>

<body style="background-color: grey">
  <header>
    <h1>Bienvenue ${user.name} à votre compte </h1>

  </header>
  
      	
      <div class="form other">
        <form action = "profil" method="get" >
          	<input type="hidden" name="action" value="${user.email}">
          	<button>Profil</button>
        </form>
        <form action = "survey" method="get" >
          	<input type="hidden" name="action" value="${user.email}">
          	<button>Questionnaires</button>
        </form>
        <form action = "newUser" method="get" >
          	<input type="hidden" name="action" value="${user.email}">
          	<button>Historiques de parcours</button>
        </form>  
        <form action = "disconnect" method="get" >
          	<input type="hidden" name="action" value="${user.email}">
          	<button>Déconnexion</button>
        </form>
        
      	</div>
        

</body>
</html>
