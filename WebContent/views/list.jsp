<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>

</head>
<body>

<%

String email=(String)session.getAttribute("email");

if(email==null){
	response.sendRedirect("index.jsp");
}

%>


<div class="container">

<div class="float-right">
<a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
</div>

<p>${message}</p>

<button class="btn btn-primary" onclick="window.location.href='views/add.jsp'">Add Student</button>
<table border="1" class="table table-striped table-bordered" id="datatable">

<thead>
<tr class="thead-drak">
<th>Name</th>
<th>PhoneNo</th>
<th>Email ID</th>
<th>Country Name</th>
<th>Actions</th>
</tr>
</thead>

<tbody>
<c:forEach items="${list}" var="user">
<tr>
<td>${user.name}</td>
<td>${user.phone}</td>
<td>${user.email}</td>
<td>${user.country}</td>
<td> <a href="${pageContext.request.contextPath}/UserController?action=EDIT&id=${user.id}">Edit</a>
|
<a href="${pageContext.request.contextPath}/UserController?action=DELETE&id=${user.id}">Delete</a>
</td>

</tr>

</c:forEach>
</tbody>
</table>
</div>

<script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>


<script>
$(document).ready(function(){
	$("#datatable").DataTable({
		"order":[[1,"desc"]]
	});
});
</script>

</body>
</html>
