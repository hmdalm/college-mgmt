package com.gnit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnit.pojo.LoginDO;
import com.gnit.pojo.StudentDO;
import com.gnit.pojo.TeacherDO;
import com.gnit.service.LoginDAO;
import com.gnit.service.StudentDAO;
import com.gnit.service.TeacherDAO;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/login")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginPage() {
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
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String json = request.getParameter("json");
System.out.println("GET PARAMETERS" + request.getContentLength());
Map<String, String[]> aa =request.getParameterMap();
System.out.println(aa.size());
		System.out.println(email + "~~~" + pass + "~~~" + json);

		LoginDAO ldao = new LoginDAO();
		LoginDO logindo = ldao.getUser(email, pass);

		String userType = logindo.getUserType();
		
		System.out.println("type---" + userType);

		System.out.println(email + "      " + pass);

		if (logindo.getEmail() == null) {
			out.print("<h3>invalid user</h3>");
			System.out.println("check");

		} else {
			ObjectMapper Obj = new ObjectMapper();
			if (userType.equals("Student")) {
				StudentDAO stdao = new StudentDAO();
				StudentDO stdo = stdao.getStudent(email);

				if (json != null && json.equals("yes")) {

					try {
						// Converting the Java object into a JSON string
						String jsonStr = Obj.writeValueAsString(stdo);
						// Displaying Java object into a JSON string
						System.out.println("jsonStr" + jsonStr);

					//	System.out.println(jsonStr);
						out.print(jsonStr);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {

					request.setAttribute("obj", stdo);
					out.print("<h3>hello!!!</h3>");
					RequestDispatcher rd = request.getRequestDispatcher("/StudentServlet");
					rd.forward(request, response);
				}

			} else {
				TeacherDAO tdao = new TeacherDAO();
				TeacherDO tdo = tdao.getTeacher(email);

				if (json != null && json.equals("yes")) {
					try {
						// Converting the Java object into a JSON string
						String jsonStr = Obj.writeValueAsString(tdo);
						// Displaying Java object into a JSON string
						System.out.println("jsonStr" + jsonStr);

						System.out.println(jsonStr);
						out.print(jsonStr);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					out.print("<h3>Teacher login!!!</h3>");

					System.out.println("teacher mail id = " + email);
					request.setAttribute("obj", tdo);

					RequestDispatcher rd = request.getRequestDispatcher("/TeacherServlet");
					rd.forward(request, response);
				}

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost  method Executed");
		doGet(request, response);
		
	}

}
