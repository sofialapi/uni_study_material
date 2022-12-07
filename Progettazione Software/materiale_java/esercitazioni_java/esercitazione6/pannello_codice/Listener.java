package pannello_codice;
import java.awt.event.*;
import javax.swing.*;

public class Listener implements ActionListener {
	private display frame;
	
	/* le due strighe mostra e cancella sono settate come static così da appartenere alla classe stessa 
	 * e non alle singole istanze. tutte le istanze di Listener (anche se ne usiamo una sola) avranno lo stesso
	 * oggetto/membro static in comune. 
	 */
	public final static String MOSTRABTN = "Mostra";
	public final static String CANCELLABTN = "Cancella";
	
	/* NOTA: per gestire la "password" inserita dall'utente tramite il tastierino, si utilizza
	 * una stringa che viene aggiornata ad ogni pressione di un tasto numerico.
	 */
	private String insertedText = "";

	public Listener(display aFrame) {
		frame = aFrame;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(MOSTRABTN)) {
			// e' stato premuto il bottone "mostra"
			frame.digitCodeText.setText(insertedText);
		}
		else if (e.getActionCommand().equals(CANCELLABTN)) {
			// e' stato premuto il bottone "c"
			int choice = JOptionPane.showConfirmDialog(frame,
					"Cancellare il testo digitato?", frame.getTitle(),
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (choice == JOptionPane.YES_OPTION) {
				insertedText = "";
				frame.digitCodeText.setText("");
				frame.passwordText.setText("");
			}
		}
		else {
			// e' stato premuto un bottone numerico
			try {
				Integer.parseInt(e.getActionCommand());
			}
			catch (NumberFormatException err) {
				throw (new IllegalArgumentException());
			}
			// usiamo l'ActionCommand come stringa
			insertedText = insertedText + e.getActionCommand();
			frame.passwordText.setText(insertedText);
		}
	}

}
