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
<h1 style="text-align:center; color:White;font-family:arial;"><%
	out.print(session.getAttribute("UserName"));
	%>,Your Expenses</h1>
	
<table style="margin-left: auto;margin-right: auto;">
<tr class= "table">
<td class= "table">Expense Date</td>
<td class= "table">Expense Type</td>
<td class= "table">Expense Amount</td>
<td class= "table">Comment</td>
</tr>


<tr>
<td class= "table">${user_expenses.expense_date} </td>
<td class= "table">${user_expenses.expense_type}</td>
<td class= "table">${user_expenses.expense_amount}</td>
<td class= "table">${user_expenses.comment}</td>
</tr>
<%

%>
</table>
</body>
</html>