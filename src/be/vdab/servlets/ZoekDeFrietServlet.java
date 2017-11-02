package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ZoekDeFrietServlet
 */
@WebServlet("/zoekdefriet")
public class ZoekDeFrietServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String[] startToestand = {"deurtoe","deurtoe","deurtoe","deurtoe","deurtoe","deurtoe","deurtoe"};
	private static final String VIEW = "/WEB-INF/JSP/zoekdefriet.jsp";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String[] toestand = startToestand;
		
		
			request.setAttribute("deuren", toestand);
			request.getRequestDispatcher(VIEW).forward(request, response);
	
		/*
			HttpSession session = request.getSession();
			toestand = (String[])session.getAttribute("toestand");	
			request.setAttribute("deuren", toestand);
			request.getRequestDispatcher(VIEW).forward(request, response);
		*/
		
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(request.getParameter("nieuwspel")!=null) {
			if(request.getSession()!=null) {
				session.invalidate();	
			}
			
			response.sendRedirect(request.getRequestURI());
		}
					
		String[] toestand;
				
		if(session.getAttribute("toestand")==null) {
			session.setAttribute("toestand", startToestand);
		}
		if(session.getAttribute("teRaden")==null) {
			session.setAttribute("teRaden", Math.floor(Math.random()*7));
		}
		
		toestand = (String [])session.getAttribute("toestand");
		
		if(request.getParameter("volgnummer")!=null){
			
			int volgnummer = Integer.valueOf(request.getParameterValues("volgnummer")[0]);
			
			if(volgnummer == (double)session.getAttribute("teRaden")) {
				toestand[volgnummer] = "gevonden";
				
			
				
			}else {
				toestand[volgnummer]= "deuropen";
			}
			
			
			
		}
		
		session.setAttribute("toestand", toestand);
		
		
		response.sendRedirect(request.getRequestURI());
		
	}

}
