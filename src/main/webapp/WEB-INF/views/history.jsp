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
  <title>Surveys list</title>
  <link rel="shortcut icon" href="">
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  <link rel="stylesheet" type="text/css" href=http://localhost:8080/internshipManager/public/css/mystyle.css>

 </head>
<body>
  <header>
    <h1 style = "color : #009999">Historique de vos parcours</h1>

  </header>
    <form class ="users" action="history" method="post" style="margin-top: 5%;">
        <c:if test = "${!empty records}" >
            <p>Votre score est sous forme : nombre total de bonnes réponses / nombre total de questions</p>
        <table class = "users" style="width: 100%">
            <thead>
                <tr>
                    <th>Titre du questionnaire</th>
                    <th>Compétence testée</th>
                    <th>Score</th>
                    <th>Durée</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ records }" var="record">
                    <tr>
                        <td>${ record.survey.title }</td>
                        <td>${ record.survey.skill.subject }</td>
                        <td>${ record.score }/${record.survey.orderQuestions.size()}</td>
                        <td>${ record.duration }</td>
                    </tr>
                </c:forEach>
            
            </tbody>
        </table>
        </c:if>
        <c:if test = "${empty records}" >
            <p> Vous n'avez pas d'historiques car vous n'avez complété aucun questionnaire !</p>
        </c:if>
            
        <input type="submit" value="Page précédente" style="width: 10%;margin-top: 3%;"/>
    </form>

</body>
</html>
