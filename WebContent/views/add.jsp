<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

<div class="container">

<div class="float-right">
<a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
</div>

<form action="${pageContext.request.contextPath}/UserController "method="POST">
                <div class="form-group">
					<input type="text" name="name" value="${user.name}" placeholder="Enter Name" class="form-control"/><br />
				</div>

				<div class="form-group">
					<input type="text" name="phone" value="${user.phone}" placeholder="Enter Phone" class="form-control"/><br />
				</div>

				<div class="form-group">
					<input type="text" name="email" value="${user.email}"  placeholder="Enter Email" class="form-control"/><br />
				</div>
				
				<div class="form-group">
					<input type="text" name="country" value="${user.country}" placeholder="Enter Country" class="form-control"/><br />
				</div>
				
				<input type="hidden" value="${user.id}"  name="id"/>

               <button class="btn btn-primary" type="submit">Save</button>
          
              
</form>

</div>

</body>
</html>