package cocktail.modele;

import java.util.ArrayList;
import java.util.List;

public class ListeCommandes {

	private List<Commande> liste;
	
	public ListeCommandes() {
		liste = new ArrayList<Commande>();
	}
	
	public void addCommande(Commande commande) {
		liste.add(commande);
	}
	
	public void deleteCommande() throws FormulaireInvalide {
		if (liste.isEmpty()) {
			throw new FormulaireInvalide("Il n'y a pas de cocktail à préparer !");
		}
		liste.remove(0);
	}
	
	public Commande getFirstCommande() throws FormulaireInvalide {
		if (liste.isEmpty()) {
			throw new FormulaireInvalide("Il n'y a pas de cocktail à préparer !");
		}
		return liste.get(0);
	}

	public List<Commande> getListe() {
		return liste;
	}
}
