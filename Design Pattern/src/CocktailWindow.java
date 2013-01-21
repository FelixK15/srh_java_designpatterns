import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.Timer;

/* Dies ist die Haupt Fenster Klasse dieses Programmes. Diese Klasse
 * steht für das Hauptfenster, welches beim starten des Programms geöffnet wird.
 * 
 * Es wird das Framework initialisiert, der Observer angelegt und die Maske konfiguriert.
 */

public class CocktailWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private CocktailObserver m_CocktailObserver = null;		//Cocktail Observer
	private Timer m_CocktailTimer = null;					//Timer um den Zeitpunkt der Bestellung festzuhalten.
	private CocktailInterface m_Cocktail = null;			//Aktueller Cocktail
	private CocktailMixerInterface m_CocktailMixer = null;
	
	CocktailFactory m_Factory = null;						//Cocktail Factory zur effizienten Erstellung bekannter Cocktailimplementationen.
	
	/* Der Konstruktor macht nichts weiteres, als die Maske zu konfigurieren, den
	 * Timer zu starten und das CocktailFramework zu initialisieren.
	 */
	public CocktailWindow() {
		super("Cocktail Window");
		CocktailFramework.InitializeFramework();	//Initialisierung Framework.
		
		m_Factory = new CocktailFactory();
		m_Cocktail = new Cocktail();
		m_CocktailMixer = new CocktailMixerJohn();
		
		m_CocktailObserver = new CocktailObserver();
		m_CocktailTimer = new Timer(500,new CocktailTimerAction(m_CocktailTimer,m_CocktailObserver));	//Start des Timers.
		m_CocktailTimer.start();
		
		ConfigureFrame();	//Konfigurierung der Maske.
	}
	
	/* Diese Funktion wird nur intern benutzt um die Maske zu konfigurieren. 
	 * (Button erstellen, Labels erstellen, Layout wählen.)
	 */
	private void ConfigureFrame(){
	
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Was tun, wenn der Benutzer das Fenster schließt?
		
		//Button werden erstellt.
		JButton WhiskeyButton = new JButton("Whiskey - 1.50$");
		JButton WodkaButton = new JButton("Wodka - 1.00$");
		JButton CreamButton = new JButton("Cream - 0.50$");
		
		JButton WhiskeyCreamButton = new JButton("Order Whiskey with Cream.");
		JButton WodkaCreamButton = new JButton("Order Wodka with Cream.");
		JButton WhiskeyWodkaButton = new JButton("Order Wodka with Whiskey.");
		
		JButton JohnButton = new JButton("John shall mix the cocktail.");
		JButton JackButton = new JButton("Jack shall mix the cocktail.");
		
		JButton NaivButton = new JButton("Order Cocktail...The old way.");
		JButton ObserverButton = new JButton("Order Cocktail...The fancy way.");
		
		//Listener werden hinzugefügt.
		WhiskeyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				m_Cocktail = new CocktailWhiskeyDecorator(m_Cocktail);
			}
		});
		
		WodkaButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				m_Cocktail = new CocktailWodkaDecorator(m_Cocktail);
			}
		});
		
		CreamButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				m_Cocktail = new CocktailCreamDecorator(m_Cocktail);
			}
		});
		

		WhiskeyCreamButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				m_Cocktail = m_Factory.CreateCreamWhiskey();
			}
		});
		
		WodkaCreamButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				m_Cocktail = m_Factory.CreateCreamWodka();
			}
		});
		
		WhiskeyWodkaButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				m_Cocktail = m_Factory.CreateWhiskeyWodka();
			}
		});
		
		JohnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				m_CocktailMixer = new CocktailMixerJohn();
			}
		});
		
		JackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				m_CocktailMixer = new CocktailMixerJack();
			}
		});
		
		NaivButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int CocktailNumber = CocktailFramework.OrderCocktail(new CocktailOrder(m_Cocktail,m_CocktailMixer));
				
				/* Sobald der entsprechende Button gedrückt wird, wird in einer endlos-Schleife die Funktion CocktailReady aufgerufen,
				 * so lange bis diese true zurück liefert.
				 */
				while(!CocktailFramework.CocktailReady(CocktailNumber)){
					
				}
				
				CocktailFramework.GetAndDrinkCocktail(CocktailNumber);
				
				//Cocktail wird "zurück gesetzt"
				m_Cocktail = new Cocktail();
			}
		});
		
		ObserverButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				m_CocktailObserver.AddListener(new CocktailListener(),new CocktailOrder(m_Cocktail,m_CocktailMixer));
				
				//Cocktail wird "zurück gesetzt"
				m_Cocktail = new Cocktail();
			}
		});
		
		//Erstellen und hinzufügen der Labels.
		super.add(new JLabel("What kind of cocktail would you like to drink?"));
		super.add(new JLabel("You got a basic cocktail for 2.50$"));
		super.add(new JLabel("Choose from these ingredients:"));
		
		//Button werden dem Frame hinzugefügt.
		super.add(WhiskeyButton);
		super.add(WodkaButton);
		super.add(CreamButton);
		
		super.add(new JSeparator(JSeparator.HORIZONTAL));
		
		super.add(new JLabel("Or order from these predefined Cocktails:"));
		super.add(WhiskeyCreamButton);
		super.add(WodkaCreamButton);
		super.add(WhiskeyWodkaButton);
		
		super.add(new JSeparator(JSeparator.HORIZONTAL));
		
		super.add(new JLabel("Shall John or Jack mix the cocktail?"));
		super.add(JohnButton);
		super.add(JackButton);
		
		super.add(new JSeparator(JSeparator.HORIZONTAL));
		
		super.add(new JLabel("Ready to order some cocktails?"));
		
		super.add(NaivButton);
		super.add(ObserverButton);
		
		//Festlegen eines Layouts.
		super.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));
		super.pack();
	}
}
