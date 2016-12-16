<%-- 
    Document   : payticket
    Created on : 24.11.2016, 15:32:18
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
	<div class="logo"></div>
        <form class="cardform" action="Controller">
            <input type="hidden" name="command" value ="buyticket"/>
            <input type="hidden" value="${train.id}" name="trainid">
            <input type="hidden" value="${userid}" name="userid">
            <input type="text" name="amount" class="amountpay" value="${train.price}">
            <input type="text" name="cardnumber" class="cardnumberpay" placeholder="1234-5678-1234-5678">				<br>

            <div class="bottomcardinfo">
		<input type="text" name="cardyear" class="cardyearpay" placeholder="11/22">
		<input type="text" name="cardcvv" class="cardcvvpay" placeholder="11/22">
            </div>
            <input type="submit" value="Оплатить">
	</form>	
        </div>
            
        <form action="Controller" id="mytickets"> 
		<input type="hidden" name="command" value="usertickets">
	</form> 
        
        <form action="Controller" id="administration"> 
		<input type="hidden" name="command" value="administration">
	</form> 
        
        <form action="Controller" id="logout"> 
		<input type="hidden" name="command" value="logout">
	</form> 
        
        <form action="Controller" id="index"> 
		<input type="hidden" name="command" value="order">
	</form> 
    </body>
</html>
