<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="shortcut icon" href="">
    <link rel="stylesheet" type = "text/css" href="http://localhost:8080/internshipManager/public/css/mystyle.css">
</head>
    <body>
        <header>
            <h2> Connexion </h2>
            </h1>
                </header>
    <div class="form other">
        <form action="login" method="post">
    <table style="with: 50%">
        <tr>
            <td>Email :</td>
            <td><input type="text" name="email" /></td>
        </tr>
        <tr>
            <td>Password :</td>
            <td><input type="password" name="password" /></td>
        </tr>
    </table> 
            <div class = "login" >
                <input type="submit" value="Login" />  
               
            </div>
            
             
       </form>
        <form class = " newUser" action = "newUser" method="get" >
                     
                     <div class = "login" >
                <input type="hidden" name="newUser" /> 
                <button>Nouveau compte</button>
            </div>
                </form>
         
    </div>


</body>
</html>