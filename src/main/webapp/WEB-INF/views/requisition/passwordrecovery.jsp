<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta charset="UTF-8">
<title>PASSWORD RECOVERY</title>
<link rel="stylesheet" href="resources/css/adduser.css">
 </head>
<body>
<div class="header">
     <div> <img src="resources/HireTalentLogo.png" class="htlogo"></div> 
     <div> <img src="resources/sacumen-logo.png" class="slogo"></div> 
     <div> <h1>PASSWORD RECOVERY</h1></div> 
</div><br><br><br>
 <br><br><br>
<div class="box" >

<label class="row" for="password"> New Password :
<input type="text" class="alignBox" required id="name" placeholder="Enter New Password"     maxlength="20" name="new password"/></label><br><br><br>
  
<label class="row" for="password">Confirm Password :
<input type="text" class="alignBox" required id="name" placeholder="Enter New Password"     maxlength="20" name="confirm password"/></label><br><br><br>
	   
 <input type="submit" value="save" class="submit" id="button" /> 
  
</div>
  
</body>
</html>