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
import com.gnit.pojo.TeacherDO;
import com.gnit.service.LoginDAO;
import com.gnit.service.TeacherDAO;
import com.utility.CollegeUtil;


@WebServlet("/HomeServletTeacher")
public class HomeServletTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServletTeacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.append("Served at:TeacherAcoount ").append(request.getContextPath());
		String first_name = request.getParameter("fname");
		String middle_name = request.getParameter("mid");
		String last_name = request.getParameter("lname");
		String dob = request.getParameter("dob");
		String department = request.getParameter("depart");
		String qualification = request.getParameter("qualif");

		String mobile = request.getParameter("mobile");
		String add = request.getParameter("add");
		String email = request.getParameter("email");
		String pass = request.getParameter("pword");
		String confpass = request.getParameter("confirmPwd");
		System.out.println("fname  :  " + first_name);
		System.out.println("mid  :  " + middle_name);
		System.out.println("lname  :  " + last_name);
		System.out.println("dob  :  " + dob);
		System.out.println("course  : " + department);
		System.out.println("course  : " + qualification);
		System.out.println("mobile : " + mobile);
		System.out.println("add  : " + add);
		System.out.println("email  : " + email);
		System.out.println("pword  : " + pass);
		System.out.println("confirmPwd : " + confpass);
		TeacherDAO tdao = new TeacherDAO();
		boolean ans = tdao.getTeacherlogin(email);
		if (ans == true) {
			out.print("<p>Teacher Does'nt exist please sign-Up first<p>");

			RequestDispatcher rd = request.getRequestDispatcher("Signup_Teacher.html");
			rd.include(request, response);

		} else {
			int teacherId = CollegeUtil.getID();
			TeacherDO tdo = new TeacherDO(teacherId, first_name, middle_name, last_name, dob, department, qualification,
					add, email, mobile);
			tdao.createTeacher(tdo);
			LoginDO logdo = new LoginDO(email, pass, confpass, "Teacher");
			LoginDAO logindao =new LoginDAO();
			logindao.createLogin(logdo);
			out.print("<p>Congrats your account has been successfully created");
			RequestDispatcher rd = request.getRequestDispatcher("college_home.html");
			rd.forward(request, response);
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
