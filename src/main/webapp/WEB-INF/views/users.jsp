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
    <title>Users</title>
    <form action="update" method="post">
        <table>
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
                    <tr>
                        <td>${ user.email }</td>
                        <td>${ user.account.name }</td>
                        <td>${ user.role }</td>
                        <td>${ user.account.isActive }</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <input type="submit" value="Login" />
    </form>
</head>
<body>

</body>
</html>
