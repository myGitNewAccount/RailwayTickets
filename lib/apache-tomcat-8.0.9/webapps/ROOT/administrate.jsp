<%-- 
    Document   : order
    Created on : 24.11.2016, 13:47:59
    Author     : denis
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Sign In</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
        <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        
        <div class="container">
            <a href="Controller?command=order">
                <div class="logo"></div>
            </a>
            <center> 
                <span> 
                    <a href="Controller?command=usertickets"> Мои билеты </a> |
                    <c:if test="${adminrights}">
                         <a href="Controller?command=administration"> Администрирование </a> |
                    </c:if>
                    <a href="Controller?command=logout"> Выход </a> 
                </span> 
            </center> 
                
            </center>
                <c:forEach var="user" items="${users}">
                <div class="ticketblock">
                        <div class="trainnumber"> Id <c:out value="${user.id}"/> </div>
                        <div class="date"> <c:out value="${user.email}"/> </div>
                        <div class="trainroad"> <c:out value="${user.firstname}"/> - <c:out value="${user.lastname}"/> <a href="Controller?command=deleteuser&userid=${user.id}" class="delete">x </a> </div>
                </div>
                </c:forEach>

        </div>

  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/index.js"></script>
	


    </body>
</html>
