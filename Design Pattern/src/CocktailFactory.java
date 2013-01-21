
public class CocktailFactory {
	
	CocktailFactory(){

	}
	
	CocktailInterface CreateCreamWhiskey(){
		CocktailInterface cocktail = new Cocktail();
		cocktail = new CocktailCreamDecorator(cocktail);
		cocktail = new CocktailWhiskeyDecorator(cocktail);
		
		return cocktail;
	}
	
	CocktailInterface CreateCreamWodka(){
		CocktailInterface cocktail = new Cocktail();
		cocktail = new CocktailCreamDecorator(cocktail);
		cocktail = new CocktailWodkaDecorator(cocktail);
		
		return cocktail;
	}
	
	CocktailInterface CreateWhiskeyWodka(){
		CocktailInterface cocktail = new Cocktail();
		cocktail = new CocktailWhiskeyDecorator(cocktail);
		cocktail = new CocktailWodkaDecorator(cocktail);
		
		return cocktail;
	}
}
