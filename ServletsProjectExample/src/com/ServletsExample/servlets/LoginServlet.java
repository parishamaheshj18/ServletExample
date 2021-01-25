package com.ServletsExample.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	public void init(ServletConfig config) {
		System.out.println("**************************");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userName = req.getParameter("UserName");
		String password = req.getParameter("Password");
		int flag1 = isUserThere(userName); // Checks if user is there
		int flag2 = authenticateUser(userName, password); // Checks if password is correct
		String targetPage = null;

		if(flag1==1 && flag2==1) {
			targetPage = "home.jsp";
			HttpSession ses = req.getSession();
			ses.setAttribute("UserName", userName);
			Cookie ck = new Cookie("userLoggedIn","true");
			res.addCookie(ck);
		}else if(flag1==1 && flag2==0) {
			targetPage = "login.jsp";        
			req.setAttribute("msg1","Username and Password doesn't match");
		}else {
			targetPage = "reg.jsp";        
			req.setAttribute("msg1","Username not found. Please register");
		}
		RequestDispatcher rs = req.getRequestDispatcher(targetPage);
		rs.forward(req, res);
	}

	
	
	public int isUserThere(String usrName) {
		int flag = 0;
		try {
			Connection con = null;
			ResultSet rs = null;
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM userLogin WHERE UserName = ?;");
			ps.setString(1,usrName);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				System.out.println("User is there.Check for password");
				flag = 1;
			} else {
				System.out.println("User not found. Please Signup.");
				flag = 0;
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public int authenticateUser(String usrName, String pwd) {
		int flag = 0;
		try {
			Connection con = null;
			ResultSet rs = null;
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM userLogin WHERE UserName = ? AND Password= ?;");
			ps.setString(1,usrName);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				System.out.println("Username and password match.");
				flag = 1;
			} else {
				System.out.println("User not found. Please Signup.");
				flag = 0;
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		// System.out.println("auth = "+flag);
		return flag;
	}
	
	
}
