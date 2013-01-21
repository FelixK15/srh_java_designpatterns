
/* Abstrakte Klasse, von der alle konkreten Cocktail Dekorierer erben m�ssen.*/

public abstract class CocktailDecorator implements CocktailInterface{
	protected CocktailInterface m_decoratedCocktail = null;
	
	public CocktailDecorator(CocktailInterface decoratedCocktail)
	{
		this.m_decoratedCocktail = decoratedCocktail;
	}
}
