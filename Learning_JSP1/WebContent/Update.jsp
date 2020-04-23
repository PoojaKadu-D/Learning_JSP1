<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<title>Edit_detail_Page</title>
</head>

<body>
	<form action="Update" method="get">
		<div class="container">
			<h2>Edit your Details</h2>
			<hr>
			<div class="form-group">
				<label for="username"> <b>User Name</b></label>
				 <input type="text" class="form-control" name="username" value="${data.uname}" required="required">
			</div>
			<div class="form-group">
				<label for="password"> <b>Password</b></label>
				 <input type="text" class="form-control" name="password" value="${data.password}" required="required">
			</div>
			<div class="form-group">
				<label for="email"> <b>Email</b></label>
				 <input type="text" class="form-control" name="email" value=" ${data.email}" required="required">
			</div>
			<div class="form-group">
				<label for="mobile-no"> <b>Mobile Number</b></label> 
				<input type="number" class="form-control" name="mobileno" value=" ${data.mobileno}" required="required"> 
				<input type="hidden" name="" value="${data.id}">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary" value="Update">Update</button>
			</div>

		</div>
	</form>
</body>
</html>