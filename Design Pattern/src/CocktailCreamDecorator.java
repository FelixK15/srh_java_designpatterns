
/*Cocktail Dekorierer für Sahne*/

public class CocktailCreamDecorator extends CocktailDecorator {

	public CocktailCreamDecorator(CocktailInterface decoratedCocktail) {
		super(decoratedCocktail);
	}

	public String getDescription() {
		return m_decoratedCocktail.getDescription() + ", including Cream";
	}

	public double getPrice() {
		return m_decoratedCocktail.getPrice() + 0.50;
	}

}
