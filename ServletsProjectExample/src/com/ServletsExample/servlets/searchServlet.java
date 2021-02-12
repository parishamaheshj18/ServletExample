package com.ServletsExample.servlets;

import java.io.IOException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class searchServlet extends HttpServlet {

	public void init(ServletConfig config) {
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String PhoneNo = req.getParameter("SearchedPhoneNo");
			UserDetails user = getUserDetailsFromPhoneNo(PhoneNo);
			req.setAttribute(PhoneNo, user);
			HttpSession ses = req.getSession();
			ses.setAttribute("SearchedUser", user);
			String targetPage = null;
			targetPage = "search.jsp";
			RequestDispatcher rs = req.getRequestDispatcher(targetPage);
			rs.forward(req, res);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public UserDetails getUserDetailsFromPhoneNo(String PhoneNo) {
		UserDetails user = new UserDetails();
		try {
			Connection connection = null;
			Statement statement = null;
			ResultSet rs = null;
			connection = DBConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM userLogin WHERE PhoneNo = ?;");
			ps.setString(1, PhoneNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				user = setDetails(rs,user);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return user;
		

	}
	
	public UserDetails setDetails(ResultSet rs,UserDetails user) {
		try {
			user.setUserName(rs.getString("UserName"));
			user.setFirstName(rs.getString("FirstName"));
			user.setLastName(rs.getString("LastName"));
			user.setAddress(rs.getString("Address"));
			user.setPhoneNo(rs.getString("PhoneNo"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	

}