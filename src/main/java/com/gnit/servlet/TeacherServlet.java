package com.gnit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnit.pojo.TeacherDO;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.append("Served at: ").append(request.getContextPath());
		try {
			TeacherDO tdo = (TeacherDO) request.getAttribute("obj");
			response.setContentType("text/html");

			out.print("<h1>Welcome </h1>" );
			out.print("<p>Displaying the details of the Teacher given below :</p>");
			out.print("<p>Teacher ID :"+ tdo.getTeacherId()+"</p>");

			out.print("<p>Student First Name :"+ tdo.getFirstName()+"</p>");
			out.print("<p>Student Middle Name :"+ tdo.getMiddleName()+"</p>");
			out.print("<p>Student Last Name :"+ tdo.getLastName()+"</p>");
			out.print("<p>Student Date of Birth :"+ tdo.getDob()+"</p>");
			out.print("<p>Student Department :"+ tdo.getDepartment()+"</p>");
			out.print("<p>Student Qualification :"+ tdo.getQualification()+"</p>");
			out.print("<p>Student Address :"+ tdo.getAddress()+"</p>");
			out.print("<p>Student Email ID :"+ tdo.getEmail()+"</p>");
			out.print("<p>Student Mobile Number :"+ tdo.getMobile()+"</p>");
			
			out.print("<a href=\"update_teacher.html\"><b>update your details </b></a>");
		    




		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
