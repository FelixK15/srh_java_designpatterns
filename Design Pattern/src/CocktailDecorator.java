
/* Abstrakte Klasse, von der alle konkreten Cocktail Dekorierer erben müssen.*/

public abstract class CocktailDecorator implements CocktailInterface{
	protected CocktailInterface m_decoratedCocktail = null;
	
	public CocktailDecorator(CocktailInterface decoratedCocktail)
	{
		this.m_decoratedCocktail = decoratedCocktail;
	}
}
