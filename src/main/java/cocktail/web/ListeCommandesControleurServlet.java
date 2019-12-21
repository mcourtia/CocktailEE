package cocktail.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cocktail.modele.CocktailService;
import cocktail.modele.Commande;

@WebServlet(urlPatterns = "/listecommandes", loadOnStartup = 0)
public class ListeCommandesControleurServlet extends HttpServlet {

	private static final String VUE_LISTE = "/WEB-INF/jsp/listecommandes.jsp";

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(VUE_LISTE);
		rd.forward(req, resp);
	}
}
