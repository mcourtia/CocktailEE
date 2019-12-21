package cocktail.modele;

import java.util.Calendar;
import java.util.TimeZone;

public class Commande {
	
	private Cocktail cocktail;
	private int numTable;
	private String date;
	
	public Commande(String idCocktail, String numTable) throws FormulaireInvalide {
		if (isBlank(idCocktail) || idCocktail.equals("0")) {
			throw new FormulaireInvalide("Veuillez choisir un cocktail !");
		}
		try {
			int id = Integer.valueOf(idCocktail);
			CocktailService cocktails = new CocktailService();
			this.cocktail = cocktails.getCocktail(id);
		} catch(NumberFormatException e) {
			throw new FormulaireInvalide("Cocktail non trouvé !");
		}
		
		if (isBlank(numTable)) {
			throw new FormulaireInvalide("Veuillez renseigné le numéro de table !");
		}
		try {
			this.numTable = Integer.valueOf(numTable);
			if (this.numTable <= 0) {
				throw new FormulaireInvalide("Le numéro de table être supérieur à 0 !");
			}
		} catch(NumberFormatException e) {
			throw new FormulaireInvalide("Le numéro de table n'est pas un nombre !");
		}
		
		setDate();
	}
	
	private static boolean isBlank(String valeur) {
		return valeur == null || "".equals(valeur);
	}
	
	private void setDate() {
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
		int Y = c.get(Calendar.YEAR);
		String M = checkZero(c.get(Calendar.MONTH) + 1);
		String D = checkZero(c.get(Calendar.DAY_OF_MONTH));
		String h = checkZero(c.get(Calendar.HOUR_OF_DAY));
		String m = checkZero(c.get(Calendar.MINUTE));
		String s = checkZero(c.get(Calendar.SECOND));
		this.date = D + "/" + M + "/" + Y + " " + h + ":" + m + ":" + s;
	}
	
	private static String checkZero(int n) {
		if (n < 10) {
			return "0" + Integer.toString(n);
		}
		else
			return Integer.toString(n);
	}

	public Cocktail getCocktail() {
		return cocktail;
	}

	public int getNumTable() {
		return numTable;
	}

	public String getDate() {
		return date;
	}
	
}
