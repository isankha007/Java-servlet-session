package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.*;
/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u= new User();
		HttpSession session = request.getSession();
		u.setFname(request.getParameter("fname"));
		u.setLname(request.getParameter("lname"));
		//u.setAge(request.getParameter("age"));
		//u.setEmail(request.getParameter("email"));
		//u.setContact(request.getParameter("contact"));
		//u.setCity(request.getParameter("city"));
		session.setAttribute("user", u);
		response.sendRedirect("Two.html");
		
		
		
		
	}

}
