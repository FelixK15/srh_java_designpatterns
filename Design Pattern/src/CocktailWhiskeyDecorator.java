
/*Cocktail Dekorierer für Whiskey*/

public class CocktailWhiskeyDecorator extends CocktailDecorator{

	public CocktailWhiskeyDecorator(CocktailInterface decoratedCocktail) {
		super(decoratedCocktail);
	}
	
	public String getDescription(){
		return m_decoratedCocktail.getDescription() + ", including Whiskey";
	}
	
	public double getPrice(){
		return m_decoratedCocktail.getPrice() + 1.50;
	}

	
}
