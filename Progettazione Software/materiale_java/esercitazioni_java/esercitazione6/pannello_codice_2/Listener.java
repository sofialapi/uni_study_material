package pannello_codice_2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//LA CLASSE LISTENER DEVE IMPLEMENTARE ACTIONLISTENER
public class Listener implements ActionListener{
	/*DAL MOMENTO CHE LISTENER EREDITA I METODI DI ACTION LISTENER
	 * VA DEFINITO IL METODO ACTION PERFORMED
	 * CHE è UN METODO ASTRATTO NELLA CLASSE (ASTRATTA) ACTION LISTENER
	 * E CHE QUI è INVECE PUBLIC. 
	 */
	private Display interfacciaDaAscoltare;
	static final String CANCELLA = "C";
	static final String MOSTRA = "Mostra";
	private String codiceDigitato = "";
	
	//COSTRUTTORE
	public Listener(Display interfaccia) {
		interfacciaDaAscoltare = interfaccia;
	}
	
	//METODO ACTIONPERFORMED
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(CANCELLA)) {
			codiceDigitato = "";
			interfacciaDaAscoltare.pswfield.setText(codiceDigitato);
			interfacciaDaAscoltare.txtfield.setText(codiceDigitato);
		}else if(e.getActionCommand().equals(MOSTRA)) {
			interfacciaDaAscoltare.txtfield.setText(codiceDigitato);
		}else {
			try {
				Integer.parseInt(e.getActionCommand());
			}
			catch (NumberFormatException err) {
				throw (new IllegalArgumentException());
			}
			String nuovoDigit = e.getActionCommand();
			codiceDigitato = codiceDigitato + nuovoDigit;
			interfacciaDaAscoltare.pswfield.setText(codiceDigitato);
		}	
	}	
}