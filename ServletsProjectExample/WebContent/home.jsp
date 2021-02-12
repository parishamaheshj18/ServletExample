<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
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
	<h1 style="text-align: center; color: White; font-family: arial;">
		Hello
		<%
	out.print(session.getAttribute("UserName"));
	%>, You have logged In.
	</h1>

	<form class="form-inline" method="post" action="search.htm">
		<div class="container">
			<input type="text" name="SearchedPhoneNo" class="form-control"
				placeholder="Search Phone Number..">
			<button type="submit" name="save" class="btn btn-primary">Search</button>
		</div>
	</form>

	<form class="form-inline" method="post" action="expense.htm">
		<div class="container">
				<input type="text" name="expense_date" placeholder="mm/dd/yyyy"> 
				<input type="text"  name="expense_type" placeholder="Spent for"> 
				<input type="text"  name="expense_amount" placeholder="Amount"> 
				<input type="text"  name="comment" placeholder="Comment(Optional)"> 
				<button type="submit" name="add_expense" class="btn btn-primary">Add Expense</button>
				<button name="show_expense" class="btn btn-primary">Show Expenses</button>
		</div>
	</form>

</body>
</html>


