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
import cocktail.modele.FormulaireInvalide;
import cocktail.modele.ListeCommandes;

@WebServlet(urlPatterns = "/commande", loadOnStartup = 0)
public class CommandeControleurServlet extends HttpServlet {

	private static final String VUE_COMMANDE = "/WEB-INF/jsp/commande.jsp";
	private static final String VUE_RECAP = "/WEB-INF/jsp/recapcommande.jsp";

	@Override
	public void init() throws ServletException {
		CocktailService cocktailService = new CocktailService();
		getServletContext().setAttribute("cocktailService", cocktailService);
		getServletContext().setAttribute("listeCocktails", cocktailService.getListeCocktails());
		
		ListeCommandes listeCommandes = new ListeCommandes();
		getServletContext().setAttribute("objetListeCommandes", listeCommandes);
		getServletContext().setAttribute("listeCommandes", listeCommandes.getListe());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(VUE_COMMANDE);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		CocktailService cocktailService = getCocktailService();
		ListeCommandes listecommandes = getListeCommandes();
		req.setCharacterEncoding("utf-8");
		try {
			String id = req.getParameter("cocktail");
			String numTable = req.getParameter("table");
			Commande commande = new Commande(id, numTable);
			listecommandes.addCommande(commande);
			req.setAttribute("commande", commande);
			getServletContext().getRequestDispatcher(VUE_RECAP).forward(req, resp);
		} catch (FormulaireInvalide e) {
			req.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher(VUE_COMMANDE).forward(req, resp);
		}
	}

	private ListeCommandes getListeCommandes() {
		return (ListeCommandes) getServletContext().getAttribute("objetListeCommandes");
	}
	
//	private CocktailService getCocktailService() {
//		return (CocktailService) getServletContext().getAttribute("cocktailService");
//	}
}
