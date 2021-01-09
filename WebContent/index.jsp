
<%--<% response.sendRedirect("UserController?action=LIST");%> --%>
<html>
<head>
<title></title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>

<div class="container">

		<form action="loginprocess" method="post">
			<div class="card">
				<div class="card-header">Login</div>
				<div class="card-body">
					<div class="form-group">

						<input type="text" name="email" class="form-control"
							placeholder="Enter Email" />
					</div>

					<div class="form-group">

						<input type="password" name="password" class="form-control"
							placeholder="Enter Password" />
					</div>
				</div>

				<div class="form-footer">

					<input type="submit" value="Login" class="btn btn-primary" />
					<a href="registration.jsp">New User</a>
				</div>

			</div>

		</form>

	</div>

</body>

</html>
