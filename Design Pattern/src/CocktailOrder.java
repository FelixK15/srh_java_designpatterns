
public class CocktailOrder {
	private CocktailInterface m_Cocktail = null;
	private CocktailMixerInterface m_CocktailMixer = null;
	
	public CocktailOrder(CocktailInterface cocktail,CocktailMixerInterface cocktailMixer){
		m_Cocktail = cocktail;
		m_CocktailMixer = cocktailMixer;
	}
	
	CocktailInterface GetCocktail() {
		return m_Cocktail;
	}
	
	CocktailMixerInterface GetCocktailMixer() {
		return m_CocktailMixer;
	}
}
