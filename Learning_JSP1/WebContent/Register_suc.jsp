<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrarion_Succ</title>
</head>
<body>
 <form>
		<div class="container">
			<h1>Registration Status: Successful!</h1>
		</div>
		<br><br>
		<div class="container">
		<span>Welcome ${ obj.uname}, ${obj.email }, ${obj.mobileno}</span>
		<span> and your Password is ${obj.password }</span><br>
		<p> Welcome to our site. You are registered Successfully. Now you can access your account , and please don't share your password with anyone for safety measures...Enjoy your journey here...</p>
		</div>
		<br><br>
		<div class="container">
		<span>Want to Login Now <a href="Index.jsp"> Click Here</a></span>
		
		</div>
		</form>
		
</body>
</html>