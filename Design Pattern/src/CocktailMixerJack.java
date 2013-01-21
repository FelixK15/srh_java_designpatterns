
public class CocktailMixerJack implements CocktailMixerInterface {

	@Override
	public String GetIngrediants() {
		return "Jack puts the ingrediants into the glas.";
	}

	@Override
	public String MixCocktail() {
		return "Jack shakes the cocktail.";
	}

	@Override
	public String ServeCocktail() {
		return "Jack serves the cocktail with a little cocktail umbrella.";
	}

}
