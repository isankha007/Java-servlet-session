package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;

/**
 * Servlet implementation class SummaryServlet
 */
public class SummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SummaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		if(session!=null) {
			User u= (User)session.getAttribute("user");
			u.setContact(Long.parseLong( request.getParameter("contact")));
			u.setCity(request.getParameter("city"));
			session.setAttribute("user", u);
			response.sendRedirect("Two.html");
			
			PrintWriter out = response.getWriter();
			out.print("<h2> Hello "+u.getEmail()+"</h2>");
			out.print("<h3> Detail "+u+"</h3>");
			out.print("<h4> Session  created at "+session.getCreationTime()+"</h4>");
			out.print("<h4> SessionID "+session.getId()+"</h4>");
			session.invalidate();
		}
	}

}
