package be.vdab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SauzenServlet
 */
@WebServlet("/sauzen")
public class SauzenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static List<Saus> allesauzen = new ArrayList<Saus>();
	static {
		
		

		allesauzen.add(new Saus(1, "cocktail", Arrays.asList("ei, zout, tomaatextract")));
		allesauzen.add(new Saus(2, "mayonnaise", Arrays.asList("ei, zout, mayo")));
		allesauzen.add(new Saus(3, "mosterdsos", Arrays.asList("mosterd, zout, azijn")));
		
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		request.setAttribute("sauzen", allesauzen);

		if (request.getParameterValues("ingredient") != null) {
			
			
			
			String[] ingredientQuery = request.getParameterValues("ingredient");
			
			if(ingredientQuery[0].isEmpty()) {request.setAttribute("fout","vul een queri in!"); request.getRequestDispatcher("/WEB-INF/JSP/sauzen.jsp").forward(request, response); }
			
			List<Saus> gevondenSauzen = new ArrayList<>();

			outerloop: for (Saus saus : allesauzen) {

				List<String> ingreds = saus.getIngredienten();

				for (String ingredient : ingreds) {

					if (ingredient.contains(ingredientQuery[0])) {
						gevondenSauzen.add(saus);
						continue outerloop;
					}

				}

			}

			request.setAttribute("gevondenSauzen", gevondenSauzen);
			
		

		}

		request.getRequestDispatcher("/WEB-INF/JSP/sauzen.jsp").forward(request, response);

	}

}
