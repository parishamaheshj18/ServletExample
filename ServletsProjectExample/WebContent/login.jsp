<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
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
<h1 style="text-align:center; color: White;font-family:arial;">Login</h1>
	<span style="text-align:center; color:White;font-family:arial; margin:auto;">
	<br><% if(request.getAttribute("msg1")!=null){out.print(request.getAttribute("msg1"));};%>
	</span>
	<form action="login.htm" method="post">
		<div class="container">
			<label for="UserName"><b>User Name</b></label> <input type="text"
				placeholder="Enter Username" name="UserName" required> <label
				for="password"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="Password" required>

			<button type="submit">Login</button>
			<label> <input type="checkbox" checked="checked"
				name="remember"> Remember me
			</label>
			<button type="submit" action="reg.htm">Register</button>
			
			
		</div>
		

	</form>

</body>
</html>