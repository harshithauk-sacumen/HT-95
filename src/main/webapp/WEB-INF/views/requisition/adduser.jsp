<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<head>
<meta charset="UTF-8">
<title>ADD USER</title>
<link rel="stylesheet" href="resources/css/adduser.css">
<script type="text/javascript">
  function showAlert() {
	  alert ("Thank You, Added User successfully.");
	  }
  </script> 
 </head>
<body>
<div class="header">
     <div> <img src="resources/HireTalentLogo.png" class="htlogo"></div> 
     <div> <img src="resources/sacumen-logo.png" class="slogo"></div> 
     <div> <h1>ADD USER</h1></div> 
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
<li title="Click to logout"><a class="logout" href="/login">Logout</a></li>  
</ul>
<div class="box" >
<form action="addUser" method="POST"  onsubmit="showAlert()"  name="myform">

   <label class="row" for="name"> Name :
   <input type="text" class="alignBox" required id="name" placeholder="Enter Name" maxlength="20" name="name"/></label><br><br><br>
   
   <label class="row" for="email"> Email :
  <input type="email" class="alignBox" required id="name" placeholder="Enter Email"  maxlength="20" name="email"/></label><br><br><br>
   

   <label class="row">Role  :
   <select class="alignBox" required id="name" name="role">
    <option selected disabled>--Select--</option>
     <c:forEach var="role" items="${roles}">
    <option>${role.role}</option>
     </c:forEach>
   </select></label><br><br><br>

  <label class="row" for="userName"> Username :
  <input type="text" class="alignBox" required id="name" placeholder="Enter Username" title ="User name should not contain spaces" maxlength="20" name="username"/></label><br><br><br>
  
 
  <label class="row" for="password"> Password :
  <input type="text" class="alignBox" required id="name" placeholder="Enter Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"  maxlength="20" name="password"/></label><br><br><br>
	   
  <label class="row" for="confirmpassword"> Confirm Password :
  <input type="text" class="alignBox" required id="name" placeholder="Enter Password" title="confirm password must be same as password" maxlength="20"  onkeyup="validate()" name="confirmpassword"/></label><br><br><br>
      <span id="err"></span>
                  
   <input type="submit" value="Submit" class="submit" id="button" /> 
  

</form>
</div>

<div class="footer">
  Sacumen &copy 2021 | All rights reserved | Terms of use | Privacy Policy
  </div>
  
  <script>
    var myInput = document.getElementById("psw");
    var letter = document.getElementById("letter");
    var capital = document.getElementById("capital");
    var number = document.getElementById("number");
    var length = document.getElementById("length");
    

    myInput.onfocus = function() {
      document.getElementById("message").style.display = "block";
    }
    
    
    myInput.onblur = function() {
      document.getElementById("message").style.display = "none";
    }
    
    
    myInput.onkeyup = function() {
      
      var lowerCaseLetters = /[a-z]/g;
      if(myInput.value.match(lowerCaseLetters)) {  
        letter.classList.remove("invalid");
        letter.classList.add("valid");
      } else {
        letter.classList.remove("valid");
        letter.classList.add("invalid");
      }
      
    
      var upperCaseLetters = /[A-Z]/g;
      if(myInput.value.match(upperCaseLetters)) {  
        capital.classList.remove("invalid");
        capital.classList.add("valid");
      } else {
        capital.classList.remove("valid");
        capital.classList.add("invalid");
      }
    
      
      var numbers = /[0-9]/g;
      if(myInput.value.match(numbers)) {  
        number.classList.remove("invalid");
        number.classList.add("valid");
      } else {
        number.classList.remove("valid");
        number.classList.add("invalid");
      }
      
      
      if(myInput.value.length >= 8) {
        length.classList.remove("invalid");
        length.classList.add("valid");
      } else {
        length.classList.remove("valid");
        length.classList.add("invalid");
      }
    }
 
function validate() {
    var upass=document.myform.password.value;
    var cpass=document.myform.confirmpassword.value;
    
    if(upass==cpass) {
       document.getElementById("err").innerText="Password is correct";
       // alert("Password is matched");
        return true;
    }
    else{
        document.getElementById("err").innerText="Password is not correct";
       // alert("Password is not correct");
        return false;
    }
}
    </script>
  
</body>
</html>