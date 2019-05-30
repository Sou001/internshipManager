<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="pragma" content="no-cache" />
    <title>Login</title>
    <link rel="shortcut icon" href="">
    <link rel="stylesheet" type = "text/css" href="public/css/mystyle.css">
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
</body>
</html>