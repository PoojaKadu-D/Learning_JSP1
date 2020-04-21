<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<title>New Registration</title>
</head>
<body>
	<form action="Register_Details" method="post">
		<div class="container">
			<h1>New Registration</h1>
			<p>Fill in all the needed details</p>
			<hr>
			<div class="form-group">
				<label for="username"> <b>User Name</b></label>
				<input type="text" class="form-control" name="username" required="required">
			</div>
			<div class="form-group">
				<label for="password"> <b>Password</b> </label>
				<input type="text" class="form-control" name="password" required="required">
			</div>	
			<div class="form-group">
				<label for="email"> <b>Email</b> </label>
				<input type="text" class="form-control" name="email" required="required">
			</div>
			<div class="form-group">
				<label for="mobile-no"> <b>Mobile Number</b> </label>
				<input type="number" class="form-control" name="mobileno" required="required">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary" value="Register">Register</button>
				<button type="reset" class="btn-btn-primary" value="Reset">Reset</button>
			</div>
		
		</div>
	</form>

</body>
</html>