package com.ServletsExample.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class searchServlet extends HttpServlet{

		public void init(ServletConfig config) {
			System.out.println("**************************");
		}
		
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			UserDetails exp = new UserDetails();
			req.setAttribute("user", exp);
		}

}
