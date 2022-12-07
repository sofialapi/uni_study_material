package lotto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ClientListener implements ActionListener{
	
	//ALCUNI CAMPI: COSTANTI PER GESTIRE GLI STATI
	public static final String START = "start";
	public static final String STOP = "stop";
	public static final String CONNECT = "connect";
	public static final String DISCONNECT = "disconnect";
	public static final String CLEAR = "clear";
	
	//CLIENT LISTENER HA BISOGNO DI ACCEDERE ALLE INFO DELLA FINESTRA
	//PER FARE QUESTO POSSIAMO IMPLEMENTARE DEI METODI PUBBLICI 
	//IN DISPLAY.JAVA OPPURE RENDERE NON PRIVATE I CAMPI DI INTERESSE
	//DEL DISPLAY COSI DA POTERVI ACCEDERE DA QUI
	//ipAddressField, portField, pulsantiera SONO DI INTERESSE
	//QUINDI TOLGO IL PRIVATE
	//FATTO QUESTO PASSO LA FINESTRA NEL COSTRUTTORE 
	
	//LA FINESTRA è QUINDI UN CAMPO
	private Display displayAscoltato = null;
	
	//CAMPI PER CONNESSIONE E LETTURA SCRITTURA 
	//CHE USI IN setupConnection() MA CHE TI SERVONO ANCHE FUORI
	//QUINDI INIZIALIZZI QUI
	private Socket sock = null;
	private PrintWriter pw = null;
	private Scanner sc = null;
	
	//COSTRUTTORE
	public ClientListener(Display display) {
		this.displayAscoltato = display;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(START)) {
			//GESTIONE RESET COLORE PULSANTIERA
			for (ColoredButton cb : this.displayAscoltato.pulsantiera) {
				cb.changeColor(Color.LIGHT_GRAY);
			}
			//GESTIONE CASO NON TUTTI I NUMERI SONO INSERITI
			for (ColoredButton cb : this.displayAscoltato.pulsantiera) {
				if (cb.getDigit().equals("")) {
					JOptionPane.showMessageDialog(null, "tutti i numeri devono essere inseriti");
					return;
				}
			}
			//GESTIONE VISIBILITà PULSANTI VANNO FATTE DOPO LE OPERAZIONI
			//DI VERIFICA SOPRA!!!
			this.displayAscoltato.started = true;
			this.displayAscoltato.setButtons();
			
			//INVIO COMANDO AL SERVER PER RICEVERE NUMERI
			pw.println("start");
			pw.flush();
			
			//LETTURA NUMERI IN INGRESSO CON THREAD 
			DownloaderThread dt = new DownloaderThread(displayAscoltato.pulsantiera, 
					sc, displayAscoltato);
			Thread thread = new Thread(dt);
			thread.start();
			
		}else if(e.getActionCommand().equals(STOP)){
			//GESTIONE VISIBILITà PULSANTI
			this.displayAscoltato.started = false;
			this.displayAscoltato.setButtons();
			
			//INVIO COMANDO AL SERVER PER INTERROMPERE NUMERI
			pw.println("interrompi");
			pw.flush();
			
		}else if(e.getActionCommand().equals(CONNECT)){
			try {
				//AVVIO CONNESSIONE CON SERVER
				this.setupConnection();
			}catch(IOException ex) {
				JOptionPane.showMessageDialog(null, "impossibile connettersi al server");
				return;
			}
			//GESTIONE VISIBILITà PULSANTI
			this.displayAscoltato.connected = true;
			this.displayAscoltato.setButtons();
			
			
		}else if(e.getActionCommand().equals(DISCONNECT)){
			try {
				//DISCONNESSIONE DA SERVER
				this.closeConnection();
			}catch(IOException ex) {
				JOptionPane.showMessageDialog(null, "impossibile disconnettersi dal server");
				return;
			}
			//GESTIONE VISIBILITà PULSANTI
			this.displayAscoltato.connected = false;
			this.displayAscoltato.setButtons();
			
		}else if(e.getActionCommand().equals(CLEAR)){
			//GESTIONE VISIBILITà PULSANTI
			for (ColoredButton cb : this.displayAscoltato.pulsantiera) {
				cb.changeColor(Color.LIGHT_GRAY);
				cb.setTextDigit("");
			}
			
		}
	}
	
	//METODI AUSILIARI
	private void setupConnection() throws IOException {
		//CREA SOCKET DI CONNESSIONE VERSO SERVER
		sock = new Socket(this.displayAscoltato.ipAddressField.getText(), 
				Integer.parseInt(this.displayAscoltato.portField.getText()));;
		//SU QUESTO SOCKET DEVO SIA SCRIVERE CHE LEGGERE
		pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
		sc = new Scanner(sock.getInputStream());
	}
	private void closeConnection() throws IOException {
		sc.close();
		pw.close();
		sock.close();
	}
}
