<%-- 
    Document   : order
    Created on : 24.11.2016, 13:47:59
    Author     : denis
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/footerTag.tld" prefix="m"%>
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

	<form class="orderform" method="POST" action="Controller?command=order">
		<div class="input-container">
	        <input type="text" id="From" name="departurecity" value="<c:choose><c:when test="${not empty departurecity}">${departurecity}</c:when></c:choose>" required="required"/>
	        <label for="From">${from}</label>
	        <div class="bar"></div>
    	</div>
    	<div class="input-container">
            <input type="text" id="To" name="destinationcity" value="<c:choose><c:when test="${not empty destinationcity}">${destinationcity}</c:when></c:choose>" required="required"/>
	        <label for="To">${to}</label>
	        <div class="bar"></div>
    	</div>
    	<div class="button-container">
	        <button><span>${findtickets}</span></button>
	    </div>
	</form>
	<center> 
            <span>
                <br>
                ${error} 
            </span> 
        </center>
        <c:forEach var="train" items="${trains}">
            <a href="Controller?command=pay&trainid=${train.id}">
            
            	<div class="ticketblock">
                    <div class="trainicon"> </div>
                    <div class="traintopitem"> 
                            <div class="travelway"> ${traindirection} № <c:out value="${train.id}"/>  </div>
                            <c:out value="${train.departurecity}"/> - <c:out value="${train.destinationcity}"/>
                    </div>	
                    <div class="mainitem">
                            <div class="itemj">
                                    <h4> ${departuretime} </h4>
                                    <fmt:formatDate pattern="HH:mm" value="${train.departuretime}" />
                            </div>
                            <div class="itemj">
                                    <h4> ${arrivaltime} </h4>
                                    <fmt:formatDate pattern="HH:mm" value="${train.arrivaltime}" />
                            </div>
                            <div class="itemj">
                                    <h4> ${traveltime} </h4>
                                    <fmt:formatDate pattern="HH:mm" value="${train.traveltime}" />
                            </div>
                            <div class="itemj">
                                    <h4> ${ticketprice} </h4>
                                    <fmt:formatNumber value="${train.price}"  maxFractionDigits="0" />
                            </div>

                    </div>	
                </div>

            
            </a>
        </c:forEach>
	
</div>

                <m:footertag/>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>
        
        
    </body>
</html>
