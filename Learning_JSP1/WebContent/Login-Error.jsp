<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<title>>Login_Error</title>
</head>
<body>
	<form>
		<div class="container">
			<h1>Login Status: Unsuccessful</h1>
		</div>
		<br>
		<div class="container">
		${msg}<br>
		<span>Back to Login Page <a href="Index.jsp">Click Here </a></span>
		</div>
		</form>
	</body>
</html>