import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/* Diese Klasse wird benutzt um bei Ablauf des in CocktailWindow verwendeten Timers
 * die CocktailObserver Klasse zu updaten.
 */

public class CocktailTimerAction implements ActionListener{
	
	private CocktailObserver m_Observer = null;
	
	public CocktailTimerAction(Timer timer,CocktailObserver observer) {
		m_Observer = observer;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		m_Observer.UpdateListener();
	}

}
