import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/* Dieser ActionListener deaktivert den damit assozierten Button.
 * D.h. Wenn der Benutzer auf den Button drückt, wird dieser anschließend deaktiviert,
 * sodass die Funktion isEnabled() auf dem Button false zurück gibt.
 */

public class ButtonDisableListener implements ActionListener {

	JButton m_Button = null;
	
	public ButtonDisableListener(JButton button){
		m_Button = button;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		m_Button.setEnabled(false);
	}

}
