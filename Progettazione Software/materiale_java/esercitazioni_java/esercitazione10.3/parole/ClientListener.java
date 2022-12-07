package parole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ClientListener implements ActionListener{
	//COSTANTI
	public final static String CONNECT = "Connect";
	public final static String DISCONNECT = "Disconnect";
	public final static String GET = "Get";
	public final static String STOP = "Stop";
	//CAMPO DISPLAY
	private Display displayAscoltato = null;
	//CAMPI CONNESSIONE SERVER
	private Socket socket = null;
	private Scanner sc = null;
	private PrintWriter pw = null;
	
	//COSTRUTTORE
	public ClientListener(Display display) {
		displayAscoltato = display;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(CONNECT)) {
			try {
				this.setupConnection();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "impossibile connettersi");
			}
			this.displayAscoltato.connected = true;
			this.displayAscoltato.setButtons();
			
		}else if(e.getActionCommand().equals(DISCONNECT)) {
			try {
				pw.println("disconnect");
				pw.flush();
				this.closeConnection();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "impossibile disconnettersi");
			}
			this.displayAscoltato.connected = false;
			this.displayAscoltato.setButtons();
			
		}else if(e.getActionCommand().equals(GET)) {
			if (stringaVuota()) {
				JOptionPane.showMessageDialog(null, "la stringa richiesta non può essere vuota");
			}else {
				this.displayAscoltato.started = true;
				this.displayAscoltato.setButtons();
				//SVUOTO I CAMPI TESTO
				this.displayAscoltato.ai.setText("");
				this.displayAscoltato.jr.setText("");
				this.displayAscoltato.sz.setText("");
				//COMUNICO COL SERVER
				String richiesta = this.displayAscoltato.stringfield.getText();
				pw.println("get:"+richiesta);
				pw.flush();
				//FACCIO PARTIRE IL THREAD DI RICEZIONE
				ReceiverThread rt = new ReceiverThread(this.displayAscoltato, this.sc);
				Thread thread = new Thread(rt);
				thread.start();
			}
			
		}else if(e.getActionCommand().equals(STOP)) {
			this.displayAscoltato.started = false;
			this.displayAscoltato.setButtons();
			pw.println("stop");
			pw.flush();
		}	
	}
	
	public void setupConnection() throws IOException {
		String indirizzo = this.displayAscoltato.addressfield.getText();
		int port = Integer.parseInt(this.displayAscoltato.portfield.getText());
		socket = new Socket(indirizzo, port);
		sc = new Scanner(socket.getInputStream());
		pw = new PrintWriter(socket.getOutputStream());
	}
	public void closeConnection() throws IOException {
		sc.close();
		pw.close();
		socket.close();
	}
	public boolean stringaVuota() {
		boolean res;
		if (this.displayAscoltato.stringfield.getText().equals("")) {
			res = true;
		}else {
			res = false;
		}
		return res;
	}

}
