package com.gnit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnit.pojo.TeacherDO;
import com.gnit.service.TeacherDAO;
import com.utility.CollegeUtil;

/**
 * Servlet implementation class teacherProfileUpdate
 */
@WebServlet("/teacherProfileUpdate")
public class TeacherProfileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherProfileUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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

		System.out.println("fname  :  " + first_name);
		System.out.println("mid  :  " + middle_name);
		System.out.println("lname  :  " + last_name);
		System.out.println("dob  :  " + dob);
		System.out.println("course  : " + department);
		System.out.println("course  : " + qualification);
		System.out.println("mobile : " + mobile);
		System.out.println("add  : " + add);
		System.out.println("email  : " + email);

		TeacherDAO tdao = new TeacherDAO();

		int teacherId = CollegeUtil.getID();
		TeacherDO tdo = new TeacherDO(teacherId, first_name, middle_name, last_name, dob, department, qualification,
				add, email, mobile);
		tdao.updateTeacher(tdo);

		out.print("<p>Congrats your account has been successfully updated");
		request.setAttribute("obj", tdo);

		RequestDispatcher rd = request.getRequestDispatcher("/TeacherServlet");
		rd.forward(request, response);
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
