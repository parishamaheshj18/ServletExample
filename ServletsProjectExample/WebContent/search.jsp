<%@page import="com.ServletsExample.servlets.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet"%>

<%@ page import="com.ServletsExample.servlets.DBConnection,com.ServletsExample.servlets.MySQLCreds " %>
<%

String PhoneNo=request.getParameter("PhoneNo");

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
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

<%UserDetails user = (UserDetails)request.getAttribute("user"); %>

<%
try{
connection = DBConnection.getConnection();
PreparedStatement ps = connection.prepareStatement("select * from userLogin where PhoneNo=?;");
ps.setString(1,PhoneNo);
resultSet = ps.executeQuery();

while(resultSet.next()){
%>
<tr>
<td class= "table"><%=resultSet.getString("UserName") %></td>
<td class= "table"><%=resultSet.getString("FirstName") %></td>
<td class= "table"><%=resultSet.getString("LastName") %></td>
<td class= "table"><%=resultSet.getString("Address") %></td>
<td class= "table"><%=resultSet.getString("PhoneNo") %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>