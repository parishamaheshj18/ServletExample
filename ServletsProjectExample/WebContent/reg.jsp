<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
<style>
body {
	background-image: url('pic2.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>
</head>
<body>
<h1 style="text-align:center; color:White;font-family:arial;">Register</h1>
	<span style="text-align:center; color:White;font-family:arial;margin:auto;">
	<br><% if(request.getAttribute("msg1")!=null){out.print(request.getAttribute("msg1"));};%>
	<br><% if(request.getAttribute("msg2")!=null){out.print(request.getAttribute("msg2"));};%>
	</span>
	<form action="reg.htm" method="post">
	<span style="text-align:center; color:White;font-family:arial;"><br><% request.getAttribute("msg1"); %></span>
		<div class="container">
			<label for="UserName"><b>User Name</b></label> <input type="text"
				placeholder="Choose Username" name="UserName" required> <label
				for="password"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="Password" required> <label
				for="FirstName"><b>First Name</b></label> <input type="text"
				placeholder="Enter First Name" name="FirstName" required> <label
				for="LastName"><b>Last Name</b></label> <input type="text"
				placeholder="Enter Last Name" name="LastName" required> <label
				for="Address"><b>Address</b></label> <input type="text"
				placeholder="Enter Address" name="Address" required><label
				for="PhoneNo"><b>Phone Number</b></label> <input type="text"
				placeholder="Enter Phone Number" name="PhoneNo" required>

			<button type="submit">Register</button>
		</div>
		

	</form>
</body>
</html>