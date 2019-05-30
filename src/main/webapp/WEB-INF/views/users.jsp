<%--
  Created by IntelliJ IDEA.
  User: lefilou
  Date: 16/05/19
  Time: 01:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
  <meta charset="utf-8">
  <meta http-equiv="pragma" content="no-cache" />
  <title>Accueil</title>
  <link rel="shortcut icon" href="">
  <link rel="stylesheet" type="text/css" href=http://localhost:8080/internshipManager/public/css/mystyle.css>

</head>
<body>
    <header>
    <h1 style = "color : #009999">La liste des utilisateurs </h1>
  </header>
    <title>Users</title>
    <form class ="users" action="users" method="post">
        <table class = "users" style="width: 100%">
            <thead>
                <tr>
                    <th>email</th>
                    <th>name</th>
                    <th>role</th>
                    <th>active</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ users }" var="user">
                    <c:if test = "${user.isActive == false}" var = "inverse"></c:if>
                    <tr>
                        <td>${ user.email }</td>
                        <td>${ user.name }</td>
                        <td>${ user.role }</td>
                        <td>
                         <input type="radio" name="${user.email}"  value=${ user.isActive } checked/>${ user.isActive }
                         <br><br>
                         <input type="radio" name="${user.email}" value =${ inverse} />${ inverse}
                        </td>
                    </tr>
                </c:forEach>
            
            </tbody>
        </table>
        <input type="submit" name = "users" value = "Valider">
    </form>
            

</body>
</html>
