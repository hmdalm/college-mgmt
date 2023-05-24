package com.gnit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnit.pojo.LoginDO;
import com.gnit.pojo.StudentDO;
import com.gnit.service.LoginDAO;
import com.gnit.service.StudentDAO;
import com.utility.CollegeUtil;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pwt = response.getWriter();
		pwt.append("Served at:~~Home Page~~ ").append(request.getContextPath());
		String first_name = request.getParameter("fname");
		String middle_name = request.getParameter("mid");
		String last_name = request.getParameter("lname");
		String dob = request.getParameter("dob");
		String course = request.getParameter("course");
		String mobile = request.getParameter("mobile");
		String add = request.getParameter("add");
		String email = request.getParameter("email");
		String pass = request.getParameter("pword");
		String confpass = request.getParameter("confirmPwd");
		System.out.println("fname  :  " + first_name);
		System.out.println("mid  :  " + middle_name);
		System.out.println("lname  :  " + last_name);
		System.out.println("dob  :  " + dob);
		System.out.println("course  : " + course);
		System.out.println("mobile : " + mobile);
		System.out.println("add  : " + add);
		System.out.println("email  : " + email);
		System.out.println("pword  : " + pass);
		System.out.println("confirmPwd : " + confpass);

		StudentDAO signup = new StudentDAO();

		//boolean ans = signup.getSignupDetail(email);
		/*
		 * if (ans == true) {
		 * pwt.print("<h2>This email already used try with unique email<h2>");
		 * 
		 * RequestDispatcher rd = request.getRequestDispatcher("Signup_Student.html");
		 * rd.include(request, response); } else {
		 */
			int Student_id = CollegeUtil.getID();

			StudentDO sdo = new StudentDO(Student_id, first_name, middle_name, last_name, dob,
					CollegeUtil.getRollno(Student_id), course, add, email, mobile);
			StudentDAO studentdao = new StudentDAO();

			studentdao.createStudent(sdo);
			String student="Student";
			LoginDO logdo = new LoginDO(email, pass, confpass,student);
			LoginDAO logindao =new LoginDAO();
			logindao.createLogin(logdo);

			pwt.print("<p>Congrats! yo have successfully created your account</p>");

			RequestDispatcher rd = request.getRequestDispatcher("college_home.html");
			rd.forward(request, response);
		}
	//}

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
