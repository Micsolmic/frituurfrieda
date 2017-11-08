package be.vdab.servlets;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StatistiekServlet
 */
@WebServlet("/statistiek.htm")
public class StatistiekServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/statistiek.jsp";
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		ConcurrentHashMap statistiek = (ConcurrentHashMap)request.getServletContext().getAttribute("statistiek");
		request.setAttribute("statistiek", statistiek);
		request.getRequestDispatcher(VIEW).forward(request, response);
	}


}
