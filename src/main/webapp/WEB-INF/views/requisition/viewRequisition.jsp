<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%><html lang="en" xmlns:th="http://www.thymeleaf.org" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW REQUISITION</title>
<link href="resources/css/viewRequisition.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
   integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
   crossorigin="anonymous">
</head>
<body>
<div class="header">
<div> <img  src="resources/HireTalentLogo.png" class="htlogo"></div>
<div> <img  src="resources/sacumen-logo.png" class="slogo"></div>
<div> <h1>VIEW REQUISITION</h1></div>
</div>
<br>
<ul>
<li title="Click to go to Home page"><a class="menu" href="/homepage">Home</a></li>
<li title="Click to create a new requisition"><a class="menu" href="/createRequisition">Create Requisition</a></li>
<li title="Click to view requisitions"><a class="menu" href="/viewrequisition">View Requisitions</a></li>  
<li title="Click to view Dashboard"><a class="menu" href="#">Dashboard</a></li>
<li title="Click to view Interview"><a class="menu" href="#">Interview</a></li>
<sec:authorize access="hasAuthority('ADMIN')">
		<li title="Click to add a User"><a  class="menu" href="/addUser">Add User</a></li>
		</sec:authorize>  </ul>  
  <ul>
<li title="Click to logout"><a class="logout" href="/logout">Logout</a></li>  
</ul>
<br>
<ul>
<li title="Click to view status-open"><a class="menu1" href="/statusopen?page=0&size=10">Status Open</a><li>
<li title="Click to view status-close"><a class="menu2" href="/statusclose?page=0&size=10">Status Close</a><li>
</ul>
<img src="resources/WhySacumen-2.svg" class="bgimg1">
<br>
	<div class="footer">
      Sacumen &copy 2021 | All rights reserved | Terms of use | Privacy Policy
  </div>
  </body>
</html>