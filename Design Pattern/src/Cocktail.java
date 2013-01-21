
/*Einfache implementation des CocktailInterface Interfaces. Wird als "Basis-Cocktail" benutzt.*/

public class Cocktail implements CocktailInterface {

	public String getDescription() {
		return "standard cocktail";
	}

	public double getPrice() {
		return 2.50;
	}

}
