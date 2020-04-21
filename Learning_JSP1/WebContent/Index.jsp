<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<title>Index</title>
</head>
<body>

	<form action="UserDetails" method="post">
		<div class="container">
			<h1>Login Page</h1>
			<hr>
			<div class="form-group">
				<label for="username"><b> User Name</b></label> <input type="text"
					class="form-control" name="username" required>
			</div>
			
			<div class="form-group">
				<label for="password"><b> Password</b></label> <input type="text"
					class="form-control" name="password" required>
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-primary" value="login">Login</button>
			</div>
			<div class="form-group">
				<button type="reset" class="btn-btn-primary" value="Reset">Reset</button>
				<span>Don't have an account<a href="Registration.jsp"> Sign Up</a></span>
			</div>
		</div>
	</form>
</body>
</html>