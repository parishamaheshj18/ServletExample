package com.ServletsExample.servlets;

import java.sql.Date;

public class UserExpense {
	String expense_date;
	String expense_type;
	Float expense_amount;
	String user_id;
	String comment;
	public String getExpense_date() {
		return expense_date;
	}
	public void setExpense_date(String expense_date) {
		this.expense_date = expense_date;
	}
	public String getExpense_type() {
		return expense_type;
	}
	public void setExpense_type(String expense_type) {
		this.expense_type = expense_type;
	}
	public Float getExpense_amount() {
		return expense_amount;
	}
	public void setExpense_amount(Float expense_amount) {
		this.expense_amount = expense_amount;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
