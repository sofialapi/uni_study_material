package connessione_porta;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//PER SCRIVERE SUL LOG
import java.util.logging.*;

public class Listener implements ActionListener{
	//COMPONENTI
	private JTextField campomatricola = new JTextField();
	private JTextField campoindirizzo = new JTextField();
	private JTextField campoporta = new JTextField();
	private boolean connesso = false;
	private boolean trasmettendo = false;
	private Display displayDaAscoltare;
	
	//LOGGER 
	private static Logger logger = Logger.getLogger("logger esercitazione");
	
	//COSTRUTTORE
	public Listener(Display display, JTextField matricola, JTextField indirizzo, JTextField porta) {
		this.displayDaAscoltare = display;
		this.campomatricola = matricola;
		this.campoindirizzo = indirizzo;
		this.campoporta = porta;
	}
	//METODO ACTION PERFORMED
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("connect")) {
			scrittura();
			connesso = true;
			JOptionPane.showMessageDialog(null, "Connessione stabilita");
		}else if(e.getActionCommand().equals("start")) {
			trasmettendo = true;
			logger.log(Level.INFO, "start");
			System.out.println("start");
			JOptionPane.showMessageDialog(null, "Interazione avviata");
		}else if(e.getActionCommand().equals("stop")) {
			trasmettendo = false;
			logger.log(Level.INFO, "stop");
			System.out.println("stop");
			JOptionPane.showMessageDialog(null, "Interazione fermata");
		}else {
			//CASO DISCONNECT
			connesso = false;
			logger.log(Level.INFO, "disconnect");
			System.out.println("disconnect");
			JOptionPane.showMessageDialog(null, "Connessione chiusa");
		}
		displayDaAscoltare.settaBottoni(connesso, trasmettendo);
		
	}
	
	//METODO DI SCRITTURA NEL LOG
	private void scrittura() {
		logger.log(Level.INFO, "connesso con " +
				this.campoindirizzo.getText() + 
				"attraverso la porta : "+
				this.campoporta.getText());
		System.out.println("connesso con " +
				this.campoindirizzo.getText() + 
				"attraverso la porta : "+
				this.campoporta.getText());
	}

}
