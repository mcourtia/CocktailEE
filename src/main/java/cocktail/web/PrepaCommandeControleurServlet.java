package cocktail.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cocktail.modele.Commande;
import cocktail.modele.FormulaireInvalide;
import cocktail.modele.ListeCommandes;

@WebServlet(urlPatterns = "/prepacommande", loadOnStartup = 0)
public class PrepaCommandeControleurServlet extends HttpServlet {

	private static final String VUE_PREPACOMMANDE = "/WEB-INF/jsp/prepacommande.jsp";
	private static final String VUE_LISTE = "/WEB-INF/jsp/listecommandes.jsp";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ListeCommandes listecommandes = getListeCommandes();
			Commande prepacommande = listecommandes.getFirstCommande();
			req.setAttribute("prepacommande", prepacommande);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(VUE_PREPACOMMANDE);
			rd.forward(req, resp);
		} catch (FormulaireInvalide e) {
			req.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher(VUE_LISTE).forward(req, resp);
		}
	}
	
	private ListeCommandes getListeCommandes() {
		return (ListeCommandes) getServletContext().getAttribute("objetListeCommandes");
	}
}