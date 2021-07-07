 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<head>
    <meta charset="UTF-8">
    <title>ADD NEW PROFILES</title>
<link href="resources/css/addNewProfile.css" rel="stylesheet" type="text/css"> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous"> 
  <script type="text/javascript">
  function isSourceTypeReferral()
  {
	  var x = document.getElementById("sourceType").value;
      if(x === 'Referral')
    	  {
    	      document.getElementById("sourcedBy").disabled = false;
    	  }
      else
    	  {
    	      document.getElementById("sourcedBy").disabled = true;
    	  }
  }
  function showAlert() {
	  alert ("Thank You, Candidate details saved successfully.");
	  }
  </script> 
</head>
<body>
<div class="header">
    <div> <img src="resources/HireTalentLogo.png" class="htlogo"></div>
    <div> <img src="resources/sacumen-logo.png" class="slogo"></div>
    <div> <h1>ADD NEW PROFILES</h1></div>
</div>
<c:choose>
<c:when test="${isViewProfile==true}">
 <a href="/isViewProfile?isViewProfile=${isViewProfile}&requisitionId=${requisition.requisitionId}"> <button class="button">Back</button></a>
 </c:when>
 <c:otherwise>
  <a href="/isViewProfile?isViewProfile=${isViewProfile}&page=0&size=12&requisitionId=${requisition.requisitionId}"> <button class="button">Back</button></a>
 </c:otherwise>
 </c:choose>
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
 <form action ="/viewprofile"  method="post" onsubmit="showAlert()" encType="multipart/form-data">
 <input type="hidden" id="requisitionId" name="requisitionId" value="${requisition.requisitionId}">
 <div class="row">
 <div class="col-25">
   <label >Requisition id: 
   ${requisition.requisitionId}  
 </label></div></div> <br>
 <div class="row">
      <div class="col-25">
        <label>Candidate Name:</label>
      </div>
      <div class="col-75">
        <input type="text" class="cname" required  pattern="[A-Za-z\s]{1,50}"
        title="Candidate name should only contain alphabets. e.g. John" name="candidateName" placeholder="Enter Candidate Name"  min="0" max="100">
      </div>
    </div><br>
      
    <div class="row">
      <div class="col-25">
        <label >Candidate Email:</label>
      </div>
      <div class="col-75">
        <input type="email" class="cemail" required  placeholder="Enter Candidate Email" min="0" max="20" name="candidateEmail">
      </div>
    </div><br>
    
    <div class="row">
      <div class="col-25">
        <label >Candidate Phone number:</label>
      </div>
      <div class="col-75">
        <input type="text" class="cphone" required  pattern="[0-9]{10}"
        title="Phone number should be of 10 digits!" placeholder="Enter Phone number"  name="candidatePhoneNumber">
      </div>
    </div>
    <br>
 
 <div class="row">
      <div class="col-25">
        <label>Current Designation:</label>
      </div>
      <div class="col-75">
        <input type="text" class="cdesignation" required  pattern="[A-Za-z\s]{1,50}"
        title="Candidate designation should only contain alphabets." placeholder="Enter Current Designation" min="0" max="100" name="candidateDesignation">
      </div>
    </div><br>
    
   <div class="row">
      <div class="col-25">
        <label >Current Company:</label>
      </div>
      <div class="col-75">
        <input type="text" class="ccompany" required  pattern="[A-Za-z\s]{1,50}"
        title="Candidate company should only contain alphabets." placeholder="Enter Current Company" min="0" max="100" name="currentCompany">
      </div>
    </div><br>

 <div class="row">
      <div class="col-25">
        <label >Relevant Experience:</label>
      </div>
      <div class="col-75">
        <input type="number" class="experience1" required  placeholder="Enter Exp Years" min="0" max="50" name="relevantExperience">
      </div>
      <div class="col-75">
        <input type="number" class="experience2" required  placeholder="Enter Exp Months" min="0" max="12" name="relevantExperience">
      </div>
    </div><br>
    
  <div class="row">
      <div class="col-25">
        <label >Source Type:</label>
      </div>
      <div class="col-75">
        <select class="sourcetype" required  id="sourceType" name="sourceType" onchange="isSourceTypeReferral()">
         <option selected disabled>--Select--</option>
   <c:forEach var="source" items="${sourceTypes}">
     <option>${source.sourceType}</option>
     </c:forEach>
        </select>
      </div>
    </div><br>
      
   <div class="row">
      <div class="col-25">
        <label>Sourced by:</label>
      </div>
      <div class="col-75">
        <input type="email" disabled="disabled" class="sourcedby" required id="sourcedBy" placeholder="Enter Sourced by" min="0" max="100" name="sourcedBy">
      </div>
    </div><br>
  	 
	 <div class="row">
      <div class="col-25">
        <label>Upload profile:</label>
      </div>
      <div class="col-75">
        <input type="file" accept=".pdf,.docx,.doc" class="upload" required id="myfile" name="files">
      </div>
    </div><br>
                
   <input type="submit" value="Submit" class="submit" id="button" /> 
   <input type="reset" value="Clear" class="clear" id="button" />

</form>
</div>
<div class="footer">
    Sacumen &copy 2021 | All rights reserved | Terms of use | Privacy Policy
</div>
</body>
</html>