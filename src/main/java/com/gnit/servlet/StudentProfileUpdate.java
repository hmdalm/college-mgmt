package com.gnit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnit.pojo.StudentDO;
import com.gnit.service.StudentDAO;
import com.utility.CollegeUtil;

/**
 * Servlet implementation class StudentProfileUpdate
 */
@WebServlet("/StudentProfileUpdate")
public class StudentProfileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentProfileUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String first_name = request.getParameter("fname");
		String middle_name = request.getParameter("mid");
		String last_name = request.getParameter("lname");
		String dob = request.getParameter("dob");
		String course = request.getParameter("course");
		String mobile = request.getParameter("mobile");
		String add = request.getParameter("add");
		String email = request.getParameter("email");
		
		System.out.println("fname  :  " + first_name);
		System.out.println("mid  :  " + middle_name);
		System.out.println("lname  :  " + last_name);
		System.out.println("dob  :  " + dob);
		System.out.println("course  : " + course);
		System.out.println("mobile : " + mobile);
		System.out.println("add  : " + add);
		System.out.println("email  : " + email);
		

		StudentDAO stdao = new StudentDAO();

		int Student_id = CollegeUtil.getID();
		StudentDO sdo = new StudentDO(Student_id, first_name, middle_name, last_name, dob,
				CollegeUtil.getRollno(Student_id), course, add, email, mobile);
		stdao.updateStudent(sdo);

		out.print("<p>Congrats your account has been successfully updated");
		request.setAttribute("obj", sdo);

		RequestDispatcher rd = request.getRequestDispatcher("/StudentServlet");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
