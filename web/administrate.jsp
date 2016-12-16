<%-- 
    Document   : order
    Created on : 24.11.2016, 13:47:59
    Author     : denis
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/footerTag.tld" prefix="m"%>
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
            <a href="Controller?command=findtickets">
                <div class="logo"></div>
            </a>
            <center> 
                <span> 
                    <a href="Controller?command=usertickets"> ${mytickets} </a> |
                    <c:if test="${adminrights}">
                         <a href="Controller?command=administration"> ${administrate} </a> |
                    </c:if>
                    <a href="Controller?command=settings"> ${settings} </a> |
                    <a href="Controller?command=logout"> ${exit} </a> 
                </span> 
            </center> 
                
            </center>
                <c:forEach var="user" items="${users}">
                <div class="ticketblock">
                    <div class="usericon"></div>
                    <div class="traintopitemname"> 
                            <div class="travelway"> Фамилия имя, id = ${user.id} </div>
                            ${user.lastname} ${user.firstname}
                    </div>	
                    <div class="traintopemail"> 
                            <div class="travelway"> E-mail </div>
                            ${user.email}
                    </div>	

                    <a href="Controller?command=deleteuser&userid=${user.id}" class="deleteticket"></a>
                    <div class="mainitem">
                    </div>	
                </div>
                    
                    
                </c:forEach>

        </div>

  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/index.js"></script>
	

    <m:footertag/>
    </body>
</html>
