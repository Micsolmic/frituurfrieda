package be.vdab.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SauzenVerwijderenServlet
 */
@WebServlet("/verwijdersauzen")
public class SauzenVerwijderenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REDIRECT = "%s/sauzen";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("verwijder");
		
		
		
		
	//	request.setAttribute("test", ids[0]);
	//	request.getRequestDispatcher("/WEB-INF/JSP/test.jsp").forward(request, response);
		
		for(String id: ids) {
			
			long idLong = Long.valueOf(id);				
		SauzenServlet.allesauzen.removeIf(s -> s.getNummer() == idLong);
			
			}
		
		
	
			response.sendRedirect(String.format(REDIRECT, request.getContextPath()));
			
		}
	

}
