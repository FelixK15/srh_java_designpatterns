import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Dies ist der CocktailObserver, der all seine Listener (CocktailListener) aufruft, sobald der mit
 * diesem Listener assozierte Cocktail fertig ist.
 */

public class CocktailObserver {
	private HashMap<Integer,CocktailListenerInterface> m_Listener = null;
	
	public CocktailObserver(){
		m_Listener = new HashMap<Integer,CocktailListenerInterface>();
	}
	
	/*Beim Hinzufügen eines neuen Listeners muss zum einen der Listener angegeben werden, als auch der zu
	 * bestellende Cocktail.
	 */
	public void AddListener(CocktailListenerInterface Listener,CocktailOrder cocktailOrder){
		//Der Listener wird mit einer BestellNr assoziert und in der HashMap gespeichert.
		int CocktailOrderNumber = CocktailFramework.OrderCocktail(cocktailOrder);
		m_Listener.put(CocktailOrderNumber,Listener);
	}
	
	/* Diese Funktion geht alle Listener durch und prüft, ob die mit dem jeweiligen Listener
	 * assozierten Cocktails fertig sind. Falls ja, wird der Listener aufgerufen.
	 */
	public void UpdateListener(){
		Iterator<Map.Entry<Integer,CocktailListenerInterface>> iter = m_Listener.entrySet().iterator();
		
		while(iter.hasNext()){
			Map.Entry<Integer,CocktailListenerInterface> entry = iter.next();
			Integer OrderNumber = entry.getKey();
			
			if(CocktailFramework.CocktailReady(OrderNumber)){
				CocktailListenerInterface Listener = m_Listener.get(OrderNumber);
				Listener.OnCocktailReady(OrderNumber);
				iter.remove();
			}
		}
	}
}
