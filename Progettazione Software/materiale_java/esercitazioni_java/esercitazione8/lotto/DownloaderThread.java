package lotto;

import java.awt.Color;
import java.util.Scanner;

import javax.swing.JOptionPane;

//QUESTO THREAD LEGGE I DATI E LI ANALIZZA
//CAMBIA I COLORI E MANDA UN MESSAGGIO DI CONSEGUENZA
public class DownloaderThread implements Runnable{
	private ColoredButton[] pulsantiera;
	private Scanner sc;
	private Display display;
	
	public DownloaderThread(ColoredButton[] pulsantiera,
			Scanner sc, Display display) {
		this.pulsantiera = pulsantiera;
		this.sc = sc;
		this.display = display;
	}

	@Override
	public void run() {
		//MENTRE RICEVIAMO I NUMERI DOBBIAMO DISABILITARE I PULSANTI
		setEnabled(false);
		boolean running = true;
		//USIAMO RUNNING PER CAPIRE QUANDO INTERROMPERE 
		//IL CICLO DI LETTURA
		boolean interrupted = false;
		//USIAMO INTERRUPTED PER TENERE IN MEMORIA SE ABBIAMO INTERROTTO
		//PERCHè VUOL DIRE CHE ABBIAMO PERSO
		while(running) {
			String cmd = sc.nextLine();
			//TOKENIZZAZIONE DEI COMANDI RICEVUTI
			String commands[] = cmd.split(";");
			//SPLIT DIVIDE SUL CARATTERE PASSATO
			//E RESTITUISCE UN ARRAY
			
			if (commands[0].equals("*") && commands[1].equals("*")) {
				//SIAMO ALLA FINE DEI DATI
				running = false;
				continue;
			}
			if (commands[0].equals("-1") && commands[1].equals("-1")) {
				//ABBIAMO PREMUTO DISCONNECT, ESTRAZIONE INTERROTTA
				running = false;
				interrupted = true;
				continue;
			}
			
			int posizione = Integer.parseInt(commands[0]);
			String numeroEstratto = commands[1];
			if (pulsantiera[posizione].getDigit().equals(numeroEstratto)) {
				pulsantiera[posizione].changeColor(Color.GREEN);
			}else {
				pulsantiera[posizione].changeColor(Color.RED);
			}	
		}
		
		if (interrupted) {
			//L'UTENTE HA PERSO
			JOptionPane.showMessageDialog(null, "you lost");
		}else {
			boolean greenFound = false;
			for (ColoredButton cb : pulsantiera) {
				if (cb.isGreen()) {
					greenFound = true;
				}
			}
			if (greenFound) {
				//L'UTENTE HA VINTO
				JOptionPane.showMessageDialog(null, "you won");
			}else {
				//L'UTENTE HA PERSO
				JOptionPane.showMessageDialog(null, "you lost");
			}
		}
		setEnabled(true);
		display.started = false;
		//ALLA FINE DEL THREAD METTO STARTED A FALSE 
		display.setButtons();
		//E RISETTO I PULSANTI
	}
	
	public void setEnabled(boolean state) {
		for (ColoredButton cb : pulsantiera) {
			cb.setEnabled(state);
		}
	}

}
