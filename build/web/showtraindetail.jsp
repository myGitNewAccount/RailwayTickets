<%-- 
    Document   : payticket
    Created on : 24.11.2016, 15:32:18
    Author     : denis
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
	<div class="logo"></div>
        
        
        
        <form class="ticketblock" action="Controller">
                
            <c:forEach var="station" items="${stations}">
		<div class="mainitem">
			<div class="customerblock">
				<div class="topname"> <fmt:formatDate pattern="HH:mm" value="${station.departureTime}" />  </div>
				 <c:out value="${station.name}"/>
			</div>
		</div>
            </c:forEach>
		
	</form>
        
        
        
        
         
    </body>
</html>
