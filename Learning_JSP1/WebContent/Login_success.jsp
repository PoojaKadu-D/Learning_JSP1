
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="Details_p.FetchData"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<title>Login_Sucess</title>
</head>
<body>
	
	<form>
	<c:if test="${empty data}">
		<h1>Login failed</h1>
	</c:if>
	<c:if test="${not empty data}">
	    <h3>Welcome Admin </h3> 
		<
		
		<div class="container">
			<h3>Login Status: Successful!</h3>
		</div>
		<br>
		<div class="container">
		
		<br><br>
		<p> Welcome to our site. You logged in Successfully. Now you can access your all data , and please don't share your password with anyone for safety measures...Enjoy your journey here...</p>
		</div>
		<br><br>
		
		<table border="1">
		<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Email Id</th>
		<th>Password</th>
		<th>Mobile Number</th>
		<th>Action on Data</th>
		</tr>
		<c:forEach items="${userList}" var="data">
		
		<tr>
			<td>${data.id}</td>	
			<td>${data.uname}</td>
			<td>${data.password}</td>
			<td>${data.email}</td>
			<td>${data.mobileno}</td>
			<td><a href="EditDetail?id=${data.id}">Edit</a> : <a href="Deletedata?id=${data.id}">Delete</a></td>
			
		</tr>
		</c:forEach>
		</table>
		
		<div class="container">
		<span>If you want to go back<a href="Index.jsp"> Click Here</a></span>
		</div>
		</c:if>
	</form>

		
</body>
</html>
