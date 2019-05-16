<!DOCTYPE html PUBLIC >
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type = "text/css" href="http://localhost:8080/internshipManager/public/css/mystyle.css">
</head>
    <body>
        <header>
            <h1><img src="http://localhost:8080/internshipManager/public/images/internships.png">
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
                <p class="create">Pas inscrit? <a href="#">Creer un compte</a></p>
        
            </div>
</form>
    </div>


</body>
</html>