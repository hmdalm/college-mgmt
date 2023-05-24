package com.gnit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnit.service.StudentDAO;

/**
 * Servlet implementation class Alert
 */
@WebServlet("/Alert")
public class Alert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Alert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method  q
		PrintWriter out = response.getWriter();
		//out.append("Served at:~~h~~ ").append(request.getContextPath());
		response.setContentType("text/html");
		
		String first_name = request.getParameter("fname");
		String middle_name = request.getParameter("mid");
		String last_name = request.getParameter("lname");
		String dob = request.getParameter("dob");
		String course = request.getParameter("course");
		String mobile = request.getParameter("mobile");
		String add = request.getParameter("add");
		String email = request.getParameter("email");
		
		System.out.println("email  : " + email);

		StudentDAO stdao = new StudentDAO();
		boolean ans = stdao.getSignupDetail(email);
		if (ans == true) {
			out.print("disallowed");} 
		else {
			out.print("allowed");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
