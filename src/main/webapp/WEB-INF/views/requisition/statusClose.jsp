<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<head>
    <meta charset="UTF-8">
    <title>REQUISITION STATUS-CLOSE</title>
<link href="resources/css/viewRequisition.css" rel="stylesheet" type="text/css">    
</head>
<body>
<div class="header">
    <div> <img src="resources/HireTalentLogo.png" class="htlogo"></div>
    <div> <img src="resources/sacumen-logo.png" class="slogo"></div>
    <div> <h1>REQUISITION STATUS-CLOSE</h1></div>
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
 <table border="1" cellpadding="2" cellspacing="2px" class="styled2-table" id="myTable">
      
        <tr>
			<th onclick="sortTable(0)">Requisition ID</th>
			<th onclick="sortTable(1)">Creation Date</th>
			<th onclick="sortTable(2)">Hiring Manager</th>
			<th onclick="sortTable(3)">Project Name</th>
			<th onclick="sortTable(4)">Role Designation</th>
		</tr>
		 <c:if test="${viewrequisitions.size() > 0}">	
		<c:forEach var="viewrequisition" items="${viewreq}">
				<c:if test = "${item.status == Status.CLOSE}">
			<tr>
				<td> <a href="/requisitionDetail?requisitionId=${viewrequisition.requisitionId}">${viewrequisition.requisitionId }</a></td>
				<td>${viewrequisition.createdDate }</td>
				<td>${viewrequisition.hiringManager }</td>
				<td>${viewrequisition.projectName }</td>
				<td>${viewrequisition.roleDesignation }</td>
			</tr>	
			</c:if>				 
		</c:forEach>
		 </c:if>
</table>
<c:if test="${viewrequisitions.size() > 0}">
  <ul class="pagination">  
  <li><a href="statusclose?page=0&size=10">1</a></li>  
  <li><a href="statusclose?page=1&size=10">2</a></li>  
  <li><a href="statusclose?page=2&size=10">3</a></li>  
</ul>  
</c:if>
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