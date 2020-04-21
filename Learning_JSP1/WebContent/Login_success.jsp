<%@page import="Details.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Details_p.FetchData"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<title>Login_Sucess</title>
</head>
<body>
	<form>
		<div class="container">
			<h1>Login Status: Successful!</h1>
		</div>
		<br>
		<div class="container">
		<span>Welcome ${ data.uname}</span>
		
		<span> and your Password is ${data.password }</span>
		<br><br>
		<p> Welcome to our site. You logged in Successfully. Now you can access your all data , and please don't share your password with anyone for safety measures...Enjoy your journey here...</p>
		</div>
		<br><br>
		<div class="container">
		<span>If you want to go back<a href="Index.jsp"> Click Here</a></span>
		</div>
	</form>

</body>
</html>
