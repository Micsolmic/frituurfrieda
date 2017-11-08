package be.vdab.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.entities.Saus;
import be.vdab.repositories.SausRepository;

/**
 * Servlet implementation class SauzenServlet
 */
@WebServlet("/sauzen")
public class SauzenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static List<Saus> allesauzen;
	static SausRepository repo = new SausRepository();
	static {
		
		
	
		
	
		//allesauzen = repo.getAlleSauzen().get();
		
		//allesauzen.add(new Saus(1, "cocktail", Arrays.asList("ei, zout, tomaatextract")));
	
		
		
	}
	
	
	@Resource(name=SausRepository.JNDI)
    void setDataSource(DataSource ds) {
		
		repo.setDataSource(ds);
		
	}
	
	
	
	

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		allesauzen = repo.getAlleSauzen().get();
		
		PrintWriter out = response.getWriter();
		
		for(Saus s: allesauzen) {
			
			out.println(s.getNaam());
			out.println(s.getNummer());
			
			
		}
		
		
	/*	
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
*/
	}

}
