
/*Cocktail Dekorierer für Wodka*/

public class CocktailWodkaDecorator extends CocktailDecorator {

	public CocktailWodkaDecorator(CocktailInterface decoratedCocktail) {
		super(decoratedCocktail);
	}

	@Override
	public String getDescription() {
		return m_decoratedCocktail.getDescription() + ", including Wodka";
	}

	@Override
	public double getPrice() {
		return m_decoratedCocktail.getPrice() + 1.00;
	}

}
