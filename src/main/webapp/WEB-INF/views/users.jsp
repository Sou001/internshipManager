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
  <title>Accueil</title>
  <link rel="shortcut icon" href="">
  <link rel="stylesheet" type="text/css" href=http://localhost:8080/internshipManager/public/css/mystyle.css>

</head>
<body>
    <title>Users</title>
    <form class = "form other" action="users" method="post">
        <table style="width: 100%">
            <caption>Liste d'utilisateurs</caption>
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
                    <c:if test = "${user.account.isActive == false}" var = "inverse"></c:if>
                    <tr>
                        <td>${ user.email }</td>
                        <td>${ user.account.name }</td>
                        <td>${ user.role }</td>
                        <td>
                            <form name="doublecombo">
                                <p align="center">
                                <select name="example" size="1" onchange="ChanGeValue()">
                                    <option value = "">${ user.account.isActive }</option>
                                    <option value = "${user}">${ inverse }</option>
                                </select>
                                </p>
                        <script>

                        function ChanGeValue(){
                        var sel = document.doublecombo.example;
                        var opt = sel.options[sel.selectedIndex].value;
                        request.getSession().setAttribute("User",opt);
                        }
                        </script>
                        </form>
                            
                        </td>
                    </tr>
                </c:forEach>
            
            </tbody>
        </table>
        
        <form action="users" method="POST">
            <input type="submit" value="Valider" />
       </form>
    </form>

</body>
</html>
