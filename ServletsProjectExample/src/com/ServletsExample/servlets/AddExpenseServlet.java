package com.ServletsExample.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddExpenseServlet extends HttpServlet {


		public void init(ServletConfig config) {
		}

		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			try {
				HttpSession ses = req.getSession();
				String UserName = (String) ses.getAttribute("UserName");
				String UserId = getUserId(UserName);
				UserExpense usrExp = new UserExpense();
				usrExp.expense_date = req.getParameter("expense_date");
				usrExp.expense_type = req.getParameter("expense_type");
				usrExp.expense_amount= Float.parseFloat(req.getParameter("expense_amount"));
				usrExp.user_id = UserId;
				usrExp.comment = req.getParameter("comment");
				
				boolean flag = AddExpenseToDatabase(usrExp);
				ses.setAttribute("user_expenses", usrExp);
				String targetPage =null;
				if(flag) {
					targetPage = "home.jsp";
				}else {
					targetPage = "ExpenseList.jsp";	
				}
				RequestDispatcher rs = req.getRequestDispatcher(targetPage);
				rs.forward(req, res);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		public String getUserId(String UserName) {
			Connection con = null;
			PreparedStatement ps = null;
			String idNum = null;
			try {
				con = DBConnection.getConnection();
				ps = con.prepareStatement("SELECT idNo FROM userLogin WHERE UserName = ?;");
				ps.setString(1,UserName );
				ResultSet rs = ps.executeQuery();
				idNum = rs.getString("idNo");
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			return idNum;
		}
		
		public boolean AddExpenseToDatabase(UserExpense usrExp) {
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = DBConnection.getConnection();
				ps = con.prepareStatement(
						"INSERT INTO userExpenses(expense_date,expense_type,expense_amount,user_id,comment) VALUES (?,?,?,?,?);");
				ps.setString(1, usrExp.expense_date);
				ps.setString(2, usrExp.expense_type);
				ps.setFloat(3, usrExp.expense_amount);
				ps.setString(4, usrExp.user_id);
				ps.setString(5, usrExp.comment);
				ps.executeUpdate();
				System.out.println("Expense Added to database");
				return true;
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				return false;
			}
			
		}

}
