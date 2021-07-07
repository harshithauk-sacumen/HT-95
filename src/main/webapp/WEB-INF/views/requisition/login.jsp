<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta charset="UTF-8">
<title>LOGIN PAGE</title>
<link rel="stylesheet" href="resources/css/login.css">
 </head>
<body>
<div class="header">
     <div> <img src="resources/HireTalentLogo.png" class="htlogo"></div> 
     <div> <img src="resources/sacumen-logo.png" class="slogo"></div> 
     <div> <h1>LOGIN PAGE</h1></div> 
</div><br><br><br>
 <br><br><br>
<div class="box" >
 <div class="error">${SPRING_SECURITY_LAST_EXCEPTION.message}</div><br>
   <form action="login" method='POST'>
  <label class="row" for="userName"> Username :
  <input type="text" class="alignBox" required id="name" placeholder="Enter Username"  maxlength="20" name="username"/></label><br><br><br>
  
  <label class="row" for="password"> Password :
  <input type="password" class="alignBox" required id="name" placeholder="Enter Password"     maxlength="20" name="password"/></label><br><br><br>
	   
 
  
  <input type="submit" value="Login" class="submit" id="button" /> <br><br>
 
  <span >  <a class="alignBox1" href="/passwordrecovery">Forgot password?</a></span>
   
</form>
</div>
  <div class="footer">
    Sacumen &copy 2021 | All rights reserved | Terms of use | Privacy Policy
</div>
</body>
</html>