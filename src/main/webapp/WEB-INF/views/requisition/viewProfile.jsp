<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%><head>
    <meta charset="UTF-8">
    <title>VIEW REQUISITION PROFILES</title>
<link href="resources/css/viewRequisitionProfiles.css" rel="stylesheet" type="text/css">
 <link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">      
</head>
<body>
<div class="header">
    <div> <img src="resources/HireTalentLogo.png" class="htlogo"></div>
    <div> <img src="resources/sacumen-logo.png" class="slogo"></div>
    <div> <h1>VIEW REQUISITION PROFILES</h1></div>
</div>
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
<a href="/requisitionDetail?requisitionId=${requisition.requisitionId}"> <button class="button1">Back</button></a>
<a href="/addnewprofile?isViewProfile=false&requisitionId=${requisition.requisitionId}"><button title="Click to add new candidate" class="button" >Add New Profile</button></a>
<table class="styled1-table" id="myTable" >
    <tbody>
   <tr class="active-row">
   <td onclick="sortTable(0)">CANDIDATE NAME</td>
   <td onclick="sortTable(1)">CURRENT DESIGNATION</td>
   <td onclick="sortTable(2)">CURRENT COMPANY</td>
   <td onclick="sortTable(3)">RELEVANT EXPERIENCE </td>
   <td onclick="sortTable(4)">SOURCE DATE</td>
   <td onclick="sortTable(5)">SOURCE TYPE</td>
   <td onclick="sortTable(6)">SOURCED BY</td>
   <td onclick="sortTable(7)">STATUS</td>
   <td onclick="sortTable(8)">RESUME</td>
   </tr>
   
     <c:if test="${candidates.size() > 0}">
    <c:forEach var="candidate" items="${candidates}">
   
    <tr class="active-row1">
        
         <td>${candidate.candidateName}</td>
         <td>${candidate.candidateDesignation}</td>
         <td>${candidate.currentCompany}</td>
         <td>${candidate.relevantExperience}</td>
         <td>${candidate.sourceDate}</td>
         <td>${candidate.sourceType}</td> 
         <td>${candidate.sourcedBy}</td>  
         <td>${candidate.statusNumber}</td> 
          <td><a href="/downloadFile/${candidate.candidateId}">Download</a></td>
    </tr>
    </c:forEach>
    </c:if>
    </tbody>
</table>
<c:if test="${candidates.size() > 0}">
	    <nav aria-label="Page navigation example">
  <ul class="pagination">

    <li class="page-item"><a class="page-link" href="viewprofile?page=0&size=12&requisitionId=${requisition.requisitionId}">1</a></li>
    <li class="page-item"><a class="page-link" href="viewprofile?page=1&size=12&requisitionId=${requisition.requisitionId}">2</a></li>
    <li class="page-item"><a class="page-link" href="viewprofile?page=2&size=12&requisitionId=${requisition.requisitionId}">3</a></li>

  </ul>
  
</nav>
</c:if>

<br>
<div class="footer">
    Sacumen &copy 2021 | All rights reserved | Terms of use | Privacy Policy
</div>
<script>
function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("myTable");
  switching = true;
  dir = "asc"; 
  while (switching) {
    switching = false;
    rows = table.rows;
    for (i = 1; i < (rows.length - 1); i++) {
      shouldSwitch = false;
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];
      if (dir == "asc") {
        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          shouldSwitch= true;
          break;
        }
      } else if (dir == "desc") {
        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
          shouldSwitch = true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      switchcount ++;      
    } else {
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
</script>
</body>
</html>