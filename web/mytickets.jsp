<%-- 
    Document   : order
    Created on : 24.11.2016, 13:47:59
    Author     : denis
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/footerTag.tld" prefix="m"%>
<%@ taglib uri="/WEB-INF/timeTag.tld" prefix="time"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <c:forEach var="ticket" items="${tickets}">
                
                <div class="ticketblock">
                    <div class="tickettrainicon"></div>
                    <div class="traintopitemticket"> 
                            <div class="travelway"> Направление № <c:out value="${ticket.trainid}"/></div>
                            <c:out value="${ticket.departurecity}"/> - <c:out value="${ticket.destinationcity}"/>
                    </div>	
                    <div class="traintopdate"> 
                            <div class="travelway"> Дата </div>
                            <fmt:formatDate pattern="dd.MM" value="${ticket.date}" />
                            
                    </div>	
                    <div class="traintopdate"> 
                            <div class="travelway"> Время </div>
                            <time:timetag date="${ticket.date}" format="HH:mm" />
                    </div>
                    <a href="Controller?command=deleteticket&ticketid=${ticket.id}" class="deleteticket"></a>
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
