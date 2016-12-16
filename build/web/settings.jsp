<%-- 
    Document   : settings
    Created on : 28.11.2016, 22:53:42
    Author     : denis
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/footerTag.tld" prefix="m"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Settings</title>
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
            
            <form class="orderform" id="settingsform" action="Controller">
                <input type="hidden" name="command" value="settingssave"/>
                <div class="input-container">
                    <input type="text" id="Firstname" name="firstname" value="${user.firstname}" required="required"/>
                    <label for="Firstname">Firstname</label>
                    <div class="bar"></div>
                </div>
                <div class="input-container">
                    <input type="text" id="Lastname" name="lastname" value="${user.lastname}" required="required"/>
                        <label for="Lastname">Lastname</label>
                        <div class="bar"></div>
                </div>
                <div class="input-container">
                        <input type="text" id="Email" name="email" value="${user.email}" required="required"/>
                        <label for="Email">Email</label>
                        <div class="bar"></div>
                </div>
                <div class="input-container">
                    <input type="password" id="Password" name="password" value="${user.password}" required="required"/>
                        <label for="Password">Password</label>
                        <div class="bar"></div>
                </div>
                <select class="minimal" name="language">
                    <option value="${language}" selected> ${interfacelanguage} </option>
                          <option value="ru"> Russian </option>
                          <option value="en"> English </option>
                        </select>
                <div class="button-container">
                        <button><span>${save}</span></button>
                </div>
            </form>
	
	
        
	
        </div>

        
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>
        
        <m:footertag/>
    </body>
</html>
