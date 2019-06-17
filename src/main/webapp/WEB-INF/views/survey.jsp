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
  <link rel="stylesheet" type="text/css" href=http://localhost:8080/internshipManager/public/css/mystyle.css>

</head>
<body>
    <header>
    <h1 style = "color : #009999">La liste des questionnaires </h1>
    <h4 style = "color : black; text-align:left;"> Afin d'activer ou désactiver un questionnaire il faut utiliser le bouton valider à la fin de votre opértation.</h4>
  </header>
    <form class ="users" action="survey" method="post">
        <c:if test = "${!empty surveys}" >
        <table class = "users" style="width: 100%">
            <thead>
                <tr>
                    <th>Numéro</th>
                    <th>Titre</th>
                    <th>Compétence associée</th>
                    <th>active</th>
                    <th>Modifier</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ surveys }" var="survey">
                    <c:if test = "${survey.isActive == false}" var = "inverse"></c:if>
                    <tr>
                        <td>${ survey.id }</td>
                        <td>${ survey.title }</td>
                        <td>${ survey.skill.subject }</td>
                        <td>
                         <input type="radio" name=${survey.id}  value= ${survey.isActive} checked/>${survey.isActive}
                         <br><br>
                         <input type="radio" name=${survey.id} value= ${inverse} />${inverse}
                        </td>
                        <td>
                        <input type="radio" name="survey" value = "${survey.id}"/>
                        </td>
                    </tr>
                </c:forEach>
            
            </tbody>
        </table>
        <input class = "admin" type="submit" name = "survey" value = "Valider">
        </c:if>
        <c:if test = "${empty surveys}" >
            <p> Il n'y a pas de questionnaires d'enregistrer ! </p>
        </c:if>
    </form>
    
    <form action = "newSurvey" method = "get">
        <table>
            <caption>Vous voulez avoir un nouveau questionnaire dans la liste ? Créez-un !</caption>
            <tr>
                    <td>Nombre de questions</td>
                    <td>
                        <input type="number" min = "0" step="1" name="question">
                    </td>
            </tr>
                <tr>
                    <td>Nombre de réponses par question</td>
                    <td>
                        <input type="number" min = "0" step="1" name="response">
                    </td>
                </tr>
        </table>
        <input type="hidden" name="action" value="newSurvey">
        <button class = "survey">Nouveau Questionnaire</button>
    </form>

</body>
</html>
