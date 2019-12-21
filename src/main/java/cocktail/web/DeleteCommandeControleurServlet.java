package cocktail.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cocktail.modele.FormulaireInvalide;
import cocktail.modele.ListeCommandes;

@WebServlet(urlPatterns = "/delete", loadOnStartup = 0)
public class DeleteCommandeControleurServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ListeCommandes listecommandes = getListeCommandes();
			listecommandes.deleteCommande();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/listecommandes");
			rd.forward(req, resp);
		} catch (FormulaireInvalide e) {
			req.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher("/listecommandes").forward(req, resp);
		}
	}
	
	private ListeCommandes getListeCommandes() {
		return (ListeCommandes) getServletContext().getAttribute("objetListeCommandes");
	}
}