package citta;

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
	//CAMPI PER L'EVOLUZIONE DEL DISPLAY
	public final static String CONNECT = "Connect";
	public final static String DISCONNECT = "Disonnect";
	public final static String START = "Start";
	public final static String STOP = "Stop";
			
	private Display displayAscoltato = null;
	
	//CAMPI PER LA CONNESSIONE
	private Socket socket = null;
	private PrintWriter pw = null;
	private Scanner sc = null;
	
	//COSTRUTTORE
	public ClientListener(Display display) {
		this.displayAscoltato = display;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(CONNECT)) {
			//PARTE DI CONNESSIONE 
			try {
				this.setupConnection();
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "impossibile connettersi");
				return;
			}
			//PARTE DI EVOLUZIONE PULSANTI
			this.displayAscoltato.connected = true;
			this.displayAscoltato.setButtons();
			
		}else if(e.getActionCommand().equals(DISCONNECT)) {
			try {
				pw.println("DISCONNECT");
				pw.flush();
				this.closeConnection();
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "impossibile disconnettersi");
				return;
			}
			this.displayAscoltato.connected = false;
			this.displayAscoltato.setButtons();
			
		}else if(e.getActionCommand().equals(START)) {
			this.displayAscoltato.started = true;
			this.displayAscoltato.setButtons();
			//INVIO COMANDO AL SERVER
			pw.println("START");
			pw.flush();
			//THREAD DI RICEZIONE DATI
			ReceiverThread rt = new ReceiverThread(this.sc, this.displayAscoltato);
			Thread thread = new Thread(rt);
			thread.start();
			
		}else if(e.getActionCommand().equals(STOP)) {
			this.displayAscoltato.started = false;
			this.displayAscoltato.setButtons();
			//INVIO COMANDO AL SERVER
			pw.println("STOP");
			pw.flush();
		}
		
	}
	
	private void setupConnection() throws IOException {
		String stampaindirizzo = this.displayAscoltato.serveraddressfield.getText();
		String stampaport = this.displayAscoltato.portfield.getText();
		System.out.println(stampaindirizzo);
		System.out.println(stampaport);
		socket = new Socket(this.displayAscoltato.serveraddressfield.getText(), Integer.parseInt(this.displayAscoltato.portfield.getText()));
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		sc = new Scanner (socket.getInputStream());
	}
	private void closeConnection() throws IOException {
		sc.close();
		pw.close();
		socket.close();
	}

}