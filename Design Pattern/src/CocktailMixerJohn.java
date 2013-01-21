
public class CocktailMixerJohn implements CocktailMixerInterface {

	@Override
	public String GetIngrediants() {
		return "John orders a waitress to put the ingrediants into the glas.";
	}

	@Override
	public String MixCocktail() {
		return "John stirres the cocktail.";
	}

	@Override
	public String ServeCocktail() {
		return "John serves the cocktail with a little cocktail cherry.";
	}

}
