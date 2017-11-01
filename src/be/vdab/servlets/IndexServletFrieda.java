package be.vdab.servlets;

import java.io.IOException;

import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServletFrieda
 */
@WebServlet(urlPatterns = "/index.htm", name = "indexservlet")
public class IndexServletFrieda extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTEXT_PARAM_TEL = "777-777-777";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String vandaag = LocalDateTime.now().getDayOfWeek().toString();

		String boodschap = vandaag.equals("MONDAY") || vandaag.equals("WEDNESDAY") ? "Wij zijn gesloten"
				: "Wij zijn open";
		request.setAttribute("boodschap", boodschap);

	
		if (vandaag.equals("WEDNESDAY")) {
			request.setAttribute("extra", "en tis goensjdag");
		}
		request.setAttribute("tel", this.getServletContext().getInitParameter("tel"));
		
		
		String telefono = (String)this.getServletContext().getAttribute("telefoon");
		request.setAttribute("novotel", telefono);
		
		request.getRequestDispatcher("WEB-INF/JSP/index.jsp").forward(request, response);
		
	}

	@Override
	public void init() throws ServletException { 
	this.getServletContext().setAttribute("telefoon", CONTEXT_PARAM_TEL); 
	}
}
