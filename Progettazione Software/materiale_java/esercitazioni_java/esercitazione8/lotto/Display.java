package lotto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Display extends JFrame{
	//COMPONENTI
	private JButton startButton = new JButton("Start");
	JTextField ipAddressField = new JTextField("127.0.0.1");
	JTextField portField = new JTextField("4400");
	private JButton stopButton = new JButton("Stop");
	private JButton connectButton = new JButton("Connect");
	private JButton disconnectButton = new JButton("Disconnect");
	private JButton clear = new JButton("Clear");
	ColoredButton[] pulsantiera = new ColoredButton[5];
	
	//QUESTI DUE CAMPI BOOLEAN SERVONO SIA PER IL METODO
	//SET BUTTON CHE NEL CLIENT LISTENER
	public boolean connected = false;
	public boolean started = false;

	//COSTRUTTORE
	public Display() {
		super("Nome Cognome Matricola");
		JPanel northPanel = new JPanel();
		northPanel.add(startButton);
		northPanel.add(new JLabel("IP Address"));
		northPanel.add(ipAddressField);
		northPanel.add(new JLabel("Port"));
		northPanel.add(portField);
		northPanel.add(stopButton);
		this.getContentPane().add(northPanel, BorderLayout.NORTH);
		
		JPanel middlePanel = new JPanel(new GridLayout(1,5));
		for (int i=0; i<5; i++) {
			pulsantiera[i]=new ColoredButton(i+"", Color.LIGHT_GRAY);
			middlePanel.add(pulsantiera[i]);
		}
		//DEVI AGGIUNGERE SET PREFFERRED SIZE ALTRIMENTI VENGONO MINI
		middlePanel.setPreferredSize(new Dimension(600, 100));
		this.getContentPane().add(middlePanel, BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel();
		southPanel.add(connectButton);
		southPanel.add(disconnectButton);
		southPanel.add(clear);
		this.getContentPane().add(southPanel, BorderLayout.SOUTH);
		
		//PARTE DI EVENTI E LISTENER
		ClientListener cl = new ClientListener(this);
		startButton.addActionListener(cl);
		startButton.setActionCommand(ClientListener.START);
		stopButton.addActionListener(cl);
		stopButton.setActionCommand(ClientListener.STOP);
		connectButton.addActionListener(cl);
		connectButton.setActionCommand(ClientListener.CONNECT);
		disconnectButton.addActionListener(cl);
		disconnectButton.setActionCommand(ClientListener.DISCONNECT);
		clear.addActionListener(cl);
		clear.setActionCommand(ClientListener.CLEAR);
		
		//PARTE DI IMPOSTAZIONI VISIBILITà
		this.setSize(700, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setButtons();//VEDI METODO SOTTO
		this.setVisible(true); 
	}
	//METODO CENTRALIZZATO CHE GESTISCE I VARI STATI DELLA FINESTRA
	//STATO INIZIALE: CLIENT NON CONNESSO AL SERVER
	//STATO CONNESSIONE PRIMA DI PREMERE START
	//STATO CONNESSIONE DOPO LA PRESSIONE DI START
	public void setButtons() {
		if (!connected) {
			//la connessione non è ancora avvenuta
			//voglio solo i pulsanti connect e clear
			connectButton.setEnabled(true);
			clear.setEnabled(true);
			startButton.setEnabled(false);
			disconnectButton.setEnabled(false);
			stopButton.setEnabled(false);
		}else{
			connectButton.setEnabled(false);
			if (started) {
				startButton.setEnabled(false);
				stopButton.setEnabled(true);
				clear.setEnabled(false);
				disconnectButton.setEnabled(false);
				//non voglio disconnettermi a gioco iniziato
			}else {
				startButton.setEnabled(true);
				stopButton.setEnabled(false);
				clear.setEnabled(true);
				//posso cancellare ciò che ho inserito
				disconnectButton.setEnabled(true);
				//non sto giocando posso disconnettermi
			}
		}
	}
}
