package com.filtering;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class FilterHmd
 */
public class FilterHmd extends HttpFilter implements Filter {

	public FilterHmd() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(request, response);
		PrintWriter out = response.getWriter();
		String pass = request.getParameter("pword");
		int a = pass.length();
		if (a < 1) {
			chain.doFilter(request, response);
			out.print("<p>Invalid password</P>");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/college-mgmt/login");
			rd.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
