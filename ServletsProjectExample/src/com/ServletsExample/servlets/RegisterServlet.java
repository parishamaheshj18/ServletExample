package com.ServletsExample.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {

	public void init(ServletConfig config) {
		System.out.println("**************************");
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String targetPage1 = null;
		HttpSession ses = req.getSession();
		if (ses.getAttribute("UserName") == null) {
			targetPage1 = "login.jsp";
			RequestDispatcher rs0 = req.getRequestDispatcher(targetPage1);
			rs0.forward(req, res);
		}

		UserDetails user = new UserDetails();
		user = SetAllUserDetails(req, user);
		int flag = authenticateRegistration(user);

		String targetPage = null;
		if (flag == 1) {
			targetPage = "home.jsp";
			ses.setAttribute("HomeLogin", "Success");
		} else {
			targetPage = "reg.jsp";
			req.setAttribute("msg2", "Username already exists. Choose another name.");
		}

		RequestDispatcher rs = req.getRequestDispatcher(targetPage);
		rs.forward(req, res);
	}

	public UserDetails SetAllUserDetails(HttpServletRequest req, UserDetails user) {
		user.userName = req.getParameter("UserName");
		user.password = req.getParameter("Password");
		user.firstName = req.getParameter("FirstName");
		user.lastName = req.getParameter("LastName");
		user.address = req.getParameter("Address");
		user.phoneNo = req.getParameter("PhoneNo");
		return user;
	};

	public void insertUser(UserDetails user) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(
					"INSERT INTO userLogin(UserName, Password,FirstName,LastName,Address) VALUES (?,?,?,?,?);");
			ps.setString(1, user.userName);
			ps.setString(2, user.password);
			ps.setString(3, user.firstName);
			ps.setString(4, user.lastName);
			ps.setString(5, user.address);
			ps.setString(6, user.phoneNo);
			ps.executeUpdate();
			System.out.println("User Added.");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public int authenticateRegistration(UserDetails user) {
		Connection con = null;
		ResultSet rs = null;
		int flag = 0;
		try {
			con = DBConnection.getConnection();
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM userLogin WHERE UserName = '" + user.userName + "';");
			if (rs.next()) {
				System.out.println("Username exists. Please choose another name");

			} else {
				insertUser(user);
				System.out.println("User added to database.");
				flag = 1;
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
