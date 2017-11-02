package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GeslachtServlet
 */
@WebServlet("/geslacht")
public class GeslachtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/meisjesjongens.jsp";
	private static int max_age = 30;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeslachtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getCookies()!=null){
			
			for(Cookie cookie: request.getCookies()) {
				
				if("geslacht".equals(cookie.getName())) {
					
					request.setAttribute("geslacht", cookie.getValue());
					break;
				}
				
				
			}
			
			
		}
		
		request.getRequestDispatcher(VIEW).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String geslacht = request.getParameter("geslacht");
		
		
		Cookie c = new Cookie("geslacht", geslacht);
		c.setMaxAge(max_age);
		response.addCookie(c);
		response.sendRedirect(request.getRequestURI());
		
		
		
	}

}
