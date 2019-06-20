<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-store, no-cache, must-revalidate, post-check=0, pre-check=0, no-cache="set-cookie" />
    
    <title>New survey</title>
    <link rel="shortcut icon" href="">
    <link rel="stylesheet" type = "text/css" href="http://localhost:8080/internshipManager/public/css/mystyle.css">
</head>
    <body>
        <header>
            <h2> Nouveau Questionnaire </h2>
            </h1>
                </header>
    <div class="form other full create">
    
    <form action="newSurvey" method="post">
        <table style="-webkit-border-vertical-spacing: 15px;">
            <tr>
                <td>Titre</td>
                <td><input type="text" name="title" /></td>
            </tr>
            <tr>
                <td>Compétence</td>
                <td>
                    <select name = "skill" >
                        <option>Aucune</option>
                        <c:forEach items="${ skills }" var="skill">
                        <option>${skill.subject}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Statut</td>
                <td>
                    <input type="radio" name="actif" value = "actif"/>Actif
                    <input type="radio" name="actif" value = "inactif"/>Inactif
                </td>
            </tr>
            
            <tr>
                <td></td>
                <td>
                    L'odre des questions est annoté par 1..n et l'ordre des réponses est de la gauche à la droite.
                    <br>N'oubliez pas de sélectionner la bonne réponse pour chaque question sinon la première sera la bonne par défaut.
                </td>
            </tr>
            
            <tr>
            <input type="hidden" name="nbquestion" value="${ nbquestion }"/>
            <input type="hidden" name="nbresponse" value="${ nbresponse }"/>
            </tr>
            
            </table>
            <table>
            <c:forEach var = "i" begin = "1" end = "${ nbquestion }">
                <tr>
                    <td style="width: 100px;">Question <c:out value = "${i}"/></td>
                </tr> 
                
                <tr>
                    <td>Titre</td>
                    <td><input type="text" name="title${i}"/></td>
                </tr> 
                
                <tr>
                    <td>Réponses</td>
                    <c:forEach var = "j" begin = "1" end = "${ nbresponse }">
                        <td>
                            <div style="display:flex">
                                <input type="radio" name="good${i}" value = "good${i}${j}"/>
                            <input type="text" name="response${i}${j}"/>
                            </div>
                            
                        </td>
                    </c:forEach>
                </tr> 
            </c:forEach>
            
            </table>
       <input type="submit" value="Valider"/> 
        
    </form>
     
         
    </div>
</body>
</html>