
public class CocktailListener implements CocktailListenerInterface{
	
	/* Wenn der Cocktail fertig ist, wird der einfach abgeholt und getrunken*/
	public void OnCocktailReady(int CocktailNumber) {
		CocktailFramework.GetAndDrinkCocktail(CocktailNumber);
	}
}
