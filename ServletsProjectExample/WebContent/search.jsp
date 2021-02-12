<%@page import="com.ServletsExample.servlets.UserExpense"%>
<%@page import="com.ServletsExample.servlets.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="style.css">
<body>
<style>
body {
  background-image: url('pic2.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}
</style>
<h1 style="text-align:center; color:White;font-family:arial;">Users</h1>
<table style="margin-left: auto;margin-right: auto;">
<tr class= "table">
<td class= "table">UserName</td>
<td class= "table">First Name</td>
<td class= "table">Last Name</td>
<td class= "table">Address</td>
<td class= "table">Phone No</td>
</tr>


<tr>
<td class= "table">${SearchedUser.userName} </td>
<td class= "table">${SearchedUser.firstName}</td>
<td class= "table">${SearchedUser.lastName}</td>
<td class= "table">${SearchedUser.address}</td>
<td class= "table">${SearchedUser.phoneNo}</td>
</tr>
<%

%>
</table>
</body>
</html>