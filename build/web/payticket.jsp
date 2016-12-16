<%-- 
    Document   : payticket
    Created on : 24.11.2016, 15:32:18
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
        
        
        
        <form class="ticketblock" action="Controller">
                <input type="hidden" name="command" value ="buyticket"/>
                <input type="hidden" value="${train.id}" name="trainid">
                <input type="hidden" value="${user.id}" name="userid">
		<div class="trainicon"> </div>
		<div class="traintopitem"> 
			<div class="travelway"> Направление № ${train.id}</div>
			${train.departurecity} - ${train.destinationcity}
		</div>	
		<div class="mainitem">
			<div class="itemj">
				<h4> Время <br> отправления </h4>
                                <fmt:formatDate pattern="HH:mm" value="${train.departuretime}" />
				
			</div>
			<div class="itemj">
				<h4> Время <br> прибытия </h4>
                                <fmt:formatDate pattern="HH:mm" value="${train.arrivaltime}" />
			</div>
			<div class="itemj">
				<h4> Время <br> в пути </h4>
                                <fmt:formatDate pattern="HH:mm" value="${train.traveltime}" />
			</div>
			<div class="itemj">
				<h4> Стоимость <br> билета </h4>
                                ${train.price}
                                
			</div>
		
		</div>	
		
		<div class="mainitem">
                    <div class="customerblock">
			<div class="topname"> Заказчик </div>
			${user.firstname} ${user.lastname}
                    </div>
			
                    <div class="input-container">
		        <input type="text" id="To" name="date" required="required"/>
		        <label for="To">Дата отправления</label>
		        <div class="bar"></div>
                    </div>
	    	
                    <div class="input-container" id="cardinfonumber">
                        <input type="text" id="To" required="required"/>
                        <label for="To">Номер банковской карты</label>
                        <div class="bar"></div>
                    </div>
                    <div class="input-container">
                        <input type="text" id="To" required="required"/>
                        <label for="To">CVV</label>
                        <div class="bar"></div>
                    </div>
	    	
                    <div class="button-container">
		        <button><span>Купить билет</span></button>
		    </div>
		</div>
		
		
	</form>
        
        
        
        
         <m:footertag/>
    </body>
</html>
