<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<head>
<meta charset="UTF-8">
<title>CREATE REQUISITION</title>
<link rel="stylesheet" href="resources/css/createRequisition.css">
<script type="text/javascript">
  function showAlert() {
	  alert ("Thank You, Requisition details saved successfully.");
	  }
  </script> 
 </head>
<body>
<div class="header">
     <div> <img src="resources/HireTalentLogo.png" class="htlogo"></div> 
     <div> <img src="resources/sacumen-logo.png" class="slogo"></div> 
     <div> <h1>CREATE REQUISITION</h1></div> 
</div><br>
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
<div class="box">
<form action="viewrequisition" method="POST"  onsubmit="showAlert()">

   <label class="row">Project Name :
   <select class="alignBox" required id="name" name="projectName">
     <option selected disabled>Select</option>
   <c:forEach var="project" items="${projects}">
     <option>${project.projectName}</option>
     </c:forEach>
   </select></label> <br><br><br>

   <label class="row">Role Designation :
   <select class="alignBox" required id="name" name="roleDesignation">
    <option selected disabled>--Select--</option>
     <c:forEach var="designation" items="${designations}">
    <option>${designation.designation}</option>
     </c:forEach>
   </select></label><br><br><br>

   <label class="row">Experience Range :
   <input type="number" class="alignBox" required id="name" placeholder="Enter the min Exp" min="0" max="100" name="experienceRange"/> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;- 
   <input type="number" class="alignBox1" required id="name" placeholder="Enter the max Exp" min="0" max="100" name="experienceRange"/></label><br><br><br>
 
   <label class="row"> Must have Skills :
   <input type="text" class="alignBox" required id="name" placeholder="Enter the mandatory Skill1" maxlength="20" name="mustHaveSkill1"/>
   <input type="text" class="alignBox1" required id="name" placeholder="Enter the mandatory Skill2" maxlength="20" name="mustHaveSkill2"/>
   <input type="text" class="alignBox2" required id="name" placeholder="Enter the mandatory Skill3" maxlength="20" name="mustHaveSkill3"/></label><br><br><br>


   <label class="row"> Good to have Skills :
   <input type="text" class="alignBox" required id="name" placeholder="Enter the optional skill1" maxlength="20" name="goodToHaveSkill1"/>
   <input type="text" class="alignBox1" required id="name" placeholder="Enter the optional skill2" maxlength="20" name="goodToHaveSkill2"/>
   <input type="text" class="alignBox2" required id="name" placeholder="Enter the optional skill3" maxlength="20" name="goodToHaveSkill3"/></label><br><br><br>

    <label class="row">
    <input type="radio" checked="checked" id="jobtype" value="FullTime" name="requisitionType"/> Full Time
    </label> 
    <label class="row">
    <input type="radio" id="contractor" value="Contractor" name="requisitionType"/> Contractor
    </label><br><br><br>
              
   <input type="submit" value="Submit" class="submit" id="button" /> 
   <input type="reset" value="Clear" class="clear" id="button" />

</form>
</div>

<div class="footer">
  Sacumen &copy 2021 | All rights reserved | Terms of use | Privacy Policy
  </div>
  
</body>
</html>