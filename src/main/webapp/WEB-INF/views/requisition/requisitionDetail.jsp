<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<head>
    <meta charset="UTF-8">
    <title>REQUISITION DETAIL</title>
<link href="resources/css/requisitionDetail.css" rel="stylesheet" type="text/css">   
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="header">
    <div> <img src="resources/HireTalentLogo.png" class="htlogo"></div>
    <div> <img src="resources/sacumen-logo.png" class="slogo"></div>
    <div> <h1>REQUISITION DETAIL</h1></div>
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
<c:forEach var="requisition" items="${requisitions}">
<a href="/viewprofile?page=0&size=12&requisitionId=${requisition.requisitionId}"><button title="Click to view candidate profiles" class="button1"><i class="fa fa-eye"></i></button></a> 
<a href="/addnewprofile?isViewProfile=true&requisitionId=${requisition.requisitionId}"><button title="Click to add new candidate" class="button2"><i class="fa fa-plus"></i></button></a>
</c:forEach>
<table class="styled1-table">
    <tbody>
    <c:forEach var="requisition" items="${requisitions}">
    <tr class="active-row">
        <td>Requisition ID</td>
        <td>${requisition.requisitionId}</td>
    </tr>   
    <tr class="active-row">
        <td>Hiring Manager</td>
        <td>${requisition.hiringManager}</td>
    </tr>   
    <tr class="active-row">
        <td>Created Date</td>
        <td>${requisition.createdDate}</td>   
    </tr>   
    <tr class="active-row">
        <td>Project Name</td>
        <td>${requisition.projectName}</td>       
    </tr>  
    <tr class="active-row">
        <td>Role Designation</td>
        <td>${requisition.roleDesignation}</td>        
    </tr>   
    <tr class="active-row">
        <td>Experience Range</td>
        <td>${requisition.experienceRange} years</td>
    </tr>   
    <tr class="active-row">
        <td>Must have Skills 1</td>
        <td>${requisition.mustHaveSkill1}</td>
    </tr>   
    <tr class="active-row">
        <td>Must have Skills 2</td>
        <td>${requisition.mustHaveSkill2}</td>
    </tr>    
    <tr class="active-row">
        <td>Must have Skills 3</td>
        <td>${requisition.mustHaveSkill3}</td>
    </tr>    
    <tr class="active-row">
        <td>Good to have skills 1</td>
        <td>${requisition.goodToHaveSkill1}</td>
    </tr>   
    <tr class="active-row">
        <td>Good to have skills 2</td>
        <td>${requisition.goodToHaveSkill2}</td>
    </tr>   
    <tr class="active-row">
        <td>Good to have skills 3</td>
        <td>${requisition.goodToHaveSkill3}</td>
    </tr>  
    <tr class="active-row">
        <td>Requisition type</td>
         <td>${requisition.requisitionType.getType()}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<div class="styled2-table">
    <div class="heading"> Key Statistics</div>
    <div class="flex-container">
  <div><h5><b class="sourced">SOURCED</b></h5><div class="box1">${countid}</div></div>
  <h5><b class="interviewed">INTERVIEWED</b></h5>
  <div><h5><b class="l1">L1</b></h5><div class="box2">${countl1}</div></div>
  <div><h5><b class="l2">L2</b></h5><div class="box3">${countl2}</div> </div> 
  <div><h5><b class="l3">L3</b></h5><div class="box4">${countl3}</div>  </div>
</div>
   </div>
     <table class="styled3-table">
        <thead>
            <tr>
                <th colspan="5">Candidate offer /Joining</th>
            </tr>
        </thead>
        <tbody>       
         <c:forEach var="candidate" items="${candidates}">        
        <tr class="active-row">
            <td>CANDIDATE NAME</td>
             <td>OFFERED ON</td>
             <td>ACCEPTED ON</td>
             <td>JOINING ON</td>  
             <td>JOINED ON</td>       
        </tr>       
        <tr class="active-row">
           <td>${candidate.candidateName}</td>
            <td>${candidate.offeredDate}</td>
             <td>${candidate.offerAcceptedDate}</td>  
              <td>${candidate.joiningDate}</td> 
               <td>${candidate.joinedDate}</td>    
        </tr>             
        </c:forEach>         
        </tbody>
    </table>
<br>
<div class="footer">
    Sacumen &copy 2021 | All rights reserved | Terms of use | Privacy Policy
</div>
</body>
</html>

