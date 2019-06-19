<%-- 
    Document   : record
    Created on : 19 juin 2019, 16:23:36
    Author     : air
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-store, no-cache, must-revalidate, post-check=0, pre-check=0, no-cache="set-cookie" />
    
    <title>Taking survey</title>
    <link rel="shortcut icon" href="">
    <link rel="stylesheet" type = "text/css" href="http://localhost:8080/internshipManager/public/css/mystyle.css">
</head>
    <body>
        
    <div class="form other full create">
    
    <form action="record" method="post">
        <input type="hidden" name="survey" value=${survey.id}  />
        <input type="hidden" name="user" value=${user.email}  />
        <input type="hidden" name="timer" value=${timer}  />
            <table>
                <header style="padding-bottom: 20px;">
            <h2> ${user.name}, vous êtes en train de remplir le questionnaire ${survey.title} </h2>
            
         </header>
            
            <c:forEach items="${survey.orderQuestions}" var="orderQuestion">
                <tr>
                    <td>${orderQuestion.orderQ} - ${orderQuestion.question.title}</td>
                    
                </tr>
                <tr>
                <c:forEach items="${orderQuestion.question.orderResponses}" var="orderResponse">
                        <td style="padding-left: 20px;">
                            <div style="display:flex">
                                <input type="radio" name="resp${orderQuestion.orderQ}" value = "${orderQuestion.orderQ}${orderResponse.orderR}"/>
                                <p>${orderResponse.response.content}</p>
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
