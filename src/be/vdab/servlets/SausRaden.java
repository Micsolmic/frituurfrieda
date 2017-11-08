package be.vdab.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.entities.Saus;

/**
 * Servlet implementation class SausRaden
 */
@WebServlet("/sausraden")
public class SausRaden extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/sausraden.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get session of maak als onbestaande
		HttpSession session = request.getSession();

		// als het een nieuwe session is, set attributen
		if (session.getAttribute("sausTeRaden") == null) {

			List<Saus> sauzen = SauzenServlet.allesauzen;
			int randomIndex = new Random().nextInt(sauzen.size() - 1);
			String sausnaam = sauzen.get(randomIndex).getNaam();
			session.setAttribute("sausTeRaden", sausnaam);
			session.setAttribute("sausGeraden", getInitialSausGeraden(sausnaam));
			request.setAttribute("sausGeraden", getInitialSausGeraden(sausnaam));
			request.setAttribute("faal", new Integer(1));

		} else {

			request.setAttribute("sausGeraden", session.getAttribute("sausGeraden"));

		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//als nieuw spel aanvraag wis sessie en redirect 
		
		if(request.getParameter("nieuwspel")!=null) {
			
			
			session.invalidate();
			response.sendRedirect(request.getRequestURI());
		
		//als bestaand spel 
		}else {
			
			String letter = request.getParameter("sausinvoer");
			String sausTeRaden = (String) session.getAttribute("sausTeRaden");
			String sausGeraden = (String) session.getAttribute("sausGeraden");
			sausGeraden = openLetter(sausTeRaden, sausGeraden, letter)[0];
			session.setAttribute("sausGeraden", sausGeraden);
			request.setAttribute("sausGeraden", sausGeraden);
			if(!openLetter(sausTeRaden, sausGeraden, letter)[1].equals("success")) {
				
				Integer c = (Integer)session.getAttribute("faal");
				int cc = c.intValue();
				cc++;
				session.setAttribute("faal", new Integer(cc));
				request.setAttribute("faal", new Integer(cc));
			}
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
		
		
		

	}
	
	protected String getInitialSausGeraden(String sausTeRaden) {
		
		String s = "";
		
		for(int i=0;i<sausTeRaden.length();i++){
			
			s+=".";
			
		}
		
		return s;
		
	}
	
	
	protected String[] openLetter(String sausTeRaden, String sausGeraden, String letter){
		
		StringBuilder sb = new StringBuilder(sausGeraden);
		String sb2 = new String("");
	
		for(int i =0;i<sausGeraden.length();i++) {
			
			if(sausTeRaden.charAt(i)==letter.charAt(0)) {
				
				sb.setCharAt(i, letter.charAt(0));
				sb2+="success";
			}			
						
		
			
			
		} 
		
		String[] sa = {sb.toString(),sb2};
		return sa;
		
	}
	
	protected void verhoogFaalStadium(HttpSession s) {
		
		//DELETED CODE
		
	}


	
	
}