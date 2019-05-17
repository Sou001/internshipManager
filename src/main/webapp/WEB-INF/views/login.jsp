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
    </div>
        
    <form action = "newUser" method="get" >
                <table style="with: 50%">
                <tr>
                    <td>S'inscrire ?</td>
                    <td><input type="submit" name="newUser" value="Nouveau compte"/></td>
                </tr>
            </table>
    </form>
    

</body>
</html>