<%-- 
    Document   : edit
    Created on : 17 juin 2019, 19:41:34
    Author     : air
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="">
        <link rel="stylesheet" type = "text/css" href="http://localhost:8080/internshipManager/public/css/mystyle.css">
    </head>
<body>
        <header>
            <h2 style = "color : #009999; text-align: center"> Édition du questionnaire </h2>
                </header>
    <div class="form other full create">
    
    <form  action="edit" method="post">
        <c:if test = "${survey.isActive == false}" var = "inverse"></c:if>
        <table style="-webkit-border-vertical-spacing: 15px;">
            <tr>
                <td>Titre</td>
                <td><input type="text" name="title" value="${survey.title}"/></td>
            </tr>
            <tr>
                <td>Compétence</td>
                <td>
                    <select name = "skill" >
                        <c:forEach items="${ skills }" var="skill">
                            <c:if test = "${skill.subject == survey.skill.subject}">
                                <option selected>${skill.subject}</option>
                            </c:if>
                                
                            <c:if test = "${empty survey.skill.subject}">
                                <option selected></option>
                            </c:if>
                                
                            <c:if test = "${skill.subject != survey.skill.subject}">
                                <option>${skill.subject}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Statut</td>
                <td>
                    <input type="radio" name="actif"  value = "actif" checked/>${survey.isActive}
                    <input type="radio" name="actif"  value = "inactif" />${inverse}
                </td>
            </tr>

            <input type="hidden" name="survey"  value = ${survey.id} checked/>
            </table>
       <input type="submit" value="Valider"/> 
        
    </form>
     
         
    </div>
</body>
</html>