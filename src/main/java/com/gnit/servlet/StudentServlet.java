package com.gnit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnit.pojo.StudentDO;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pt = response.getWriter();
		pt.append("Served at:@@GNIT@@ ").append(request.getContextPath());
		try {
			StudentDO stdo = (StudentDO) request.getAttribute("obj");
			response.setContentType("text/html");

			pt.print("<h1>Welcome </h1>" );
			pt.print("<p>Displaying the details of the Student given below :</p>");
			pt.print("<p>Student ID :"+ stdo.getStudentId()+"</p>");

			pt.print("<p>Student First Name :"+ stdo.getFirstName()+"</p>");
			pt.print("<p>Student Middle Name :"+ stdo.getMiddleName()+"</p>");
			pt.print("<p>Student Last Name :"+ stdo.getLastName()+"</p>");
			pt.print("<p>Student Date of Birth :"+ stdo.getDob()+"</p>");
			pt.print("<p>Student Roll Number :"+ stdo.getRollNo()+"</p>");
			pt.print("<p>Student Course :"+ stdo.getCourse()+"</p>");
			pt.print("<p>Student Address :"+ stdo.getAddress()+"</p>");
			pt.print("<p>Student Email ID :"+ stdo.getEmail()+"</p>");
			pt.print("<p>Student Mobile Number :"+ stdo.getMobile()+"</p>");

			pt.print("<a href=\"UpdateStudent.html\"><b>update your details </b></a>");



		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO: handle exception
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
