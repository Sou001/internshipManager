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
        <form action="newUser" method="post">
    <table style="with: 50%">
        <tr>
            <td>Email :</td>
            <td><input type="text" name="email" /></td>
        </tr>
        <tr>
            <td>Name :</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>Password :</td>
            <td><input type="password" name="password" /></td>
        </tr>
        
        <tr>
            <td>tel :</td>
            <td><input type="text" name="tel" /></td>
        </tr>
        <tr>
            <td>Society :</td>
            <td><input type="text" name="society" /></td>
        </tr>
        <tr>
            <td>role :</td>
            <td><input type="radio" name="Intern" />Intern<br><br><input type="radio" name="Admin" />Admin</td>
        </tr>
    </table> 
            <div class = "login" >
                <input type="submit" value="NewUser" />  
               
            </div>
       </form>
     
         
    </div>
</body>
</html>
