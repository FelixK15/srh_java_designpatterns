import java.util.Date;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/* Dies ist unser CocktailFramework, welches wir von einem imagin�ren Kunden bekommen haben, um daraus
 * eine "Cocktail-Bestell-Software" zu basteln.
 */

public class CocktailFramework {
	private static HashMap<Integer,Long> m_CocktailTimerMap = null;
	private static HashMap<Integer,CocktailOrder> m_CocktailMap = null;
	private static int m_HighestNumber = 0;
	
	/*Initialisiert das Framework, um es benutzen zu k�nnen.*/
	public static void InitializeFramework() {
		m_CocktailTimerMap = new HashMap<Integer,Long>();
		m_CocktailMap = new HashMap<Integer,CocktailOrder>();
	}
	
	/* Bestellt einen neuen Cocktail und gibt eine Bestellnr zur�ck mit der der Cocktail
	 * sp�ter "abgeholt" werden kann. �bergeben wird der Cocktail, welcher bestellt werden soll.
	 * (Cocktails brauchen 5 Sekunden um zubereitet zu werden).
	 */
	static int OrderCocktail(CocktailOrder cocktailOrder){
		m_HighestNumber++;
		m_CocktailTimerMap.put(m_HighestNumber,GetTime());
		m_CocktailMap.put(m_HighestNumber, cocktailOrder);
		return m_HighestNumber;
	}
	
	/* �ber diese Funktion kann man anfragen ob ein zuvor bestellter Cocktail (OrderCocktail()) 
	 * fertig ist, oder nicht. �bergeben wird die Bestellnr des Cocktails.
	 */
	static boolean CocktailReady(int number){
		/*Die Zeit seit der Bestellung wird gemessen. Ist der Zeitunterschied gleich oder gr��er
		 * als 5 Sekunden, wird der Cocktail als "fertig" makiert und true wird zur�ck gegeben (Ansonsten false).
		 */
		if(m_CocktailTimerMap.containsKey(number)){
			long curTime = GetTime();
			long cocktailInitialTime = m_CocktailTimerMap.get(number);
			long difference = curTime - cocktailInitialTime;
			
			return difference > 5000;
		}else{
			return false;
		}
	}
	
	/* �ber diese Funktion bekommt & trinkt man den Cocktail mit der zugewiesenen BestellNr (falls dieser fertig ist).
	 */
	static void GetAndDrinkCocktail(int number){
		boolean foundNumber = false;
		
		/*Existiert f�r die �bergebene nummer eine Bestellung und wenn ja, ist diese bereits fertig?*/
		if(m_CocktailMap.containsKey(number)){			
			if(CocktailReady(number)){
				foundNumber = true;
			}
		}
		
		/*Wenn eine Bestellung gefunden wurde (und diese fertig ist), wird der Cocktails ausgeben und eine Meldung wird angezeigt. 
		 * Gleichzeitig wird der Cocktail aus den internen HashMaps gel�scht. (Sozusagen aus dem Gehirn des Barkeepers gel�scht)
		 */
		if(foundNumber){
			CocktailOrder cocktailOrder = m_CocktailMap.get(number);
			
			String CocktailString = cocktailOrder.GetCocktailMixer().GetIngrediants() + "\n" + 
									cocktailOrder.GetCocktailMixer().MixCocktail() + "\n" +
									cocktailOrder.GetCocktailMixer().ServeCocktail() + "\n" + 
									"------\n" + "Enjoy your " + cocktailOrder.GetCocktail().getDescription() + "\n" + 
									"That'll be " + cocktailOrder.GetCocktail().getPrice() + "$.";
			
			JOptionPane.showMessageDialog(new JFrame(), CocktailString);

			m_CocktailMap.remove(number);
			m_CocktailTimerMap.remove(number);
		}
	}
	
	/*Diese Funktion wird nur intern genutzt um Zeitabst�nde zu messen*/
	static private long GetTime(){
		return new Date().getTime();
	}
}
