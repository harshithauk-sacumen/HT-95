<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<head>
    <meta charset="UTF-8">
    <title>HOME PAGE</title>
<link href="resources/css/requisitionDetail.css" rel="stylesheet" type="text/css">   
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous"> 
</head>
<body>
<div class="header">
    <div> <img src="resources/HireTalentLogo.png" class="htlogo"></div>
    <div> <img src="resources/sacumen-logo.png" class="slogo"></div>
    <div> <h1>HIRE TALENT HOME PAGE</h1></div>
</div>
<ul>
<li title="Click to create a new requisition"><a class="menu" href="/createRequisition">Create Requisition</a></li>
<li title="Click to view requisitions"><a  class="menu" href="/viewrequisition">View Requisitions</a></li>  
<li title="Click to view Dashboard"><a class="menu" href="#">Dashboard</a></li>
<li title="Click to view Interview"><a class="menu" href="#">Interview</a></li>
<sec:authorize access="hasAuthority('ADMIN')">
		<li title="Click to add a User"><a  class="menu" href="/addUser">Add User</a></li>
		</sec:authorize>
</ul>
<ul>
<li title="Click to logout"><a class="logout" href="/logout">Logout</a></li>  
</ul>
<img src="resources/WhySacumen-2.svg" class="bgimg">
<div class="footer">
    Sacumen &copy 2021 | All rights reserved | Terms of use | Privacy Policy
</div>
</body>
</html>