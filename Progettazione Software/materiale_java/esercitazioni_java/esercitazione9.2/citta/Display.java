package citta;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Display extends JFrame {
	//CAMPI
	private JLabel serveraddresslabel = new JLabel("Server Address");
	JTextField serveraddressfield = new JTextField(30);
	private JLabel portlabel = new JLabel("Port");
	JTextField portfield = new JTextField(10);
	private JButton connect = new JButton("Connect");
	private JButton disconnect = new JButton("Disconnect");
	JTextArea usa = new JTextArea(5, 20);
	JTextArea italia = new JTextArea(5, 20);
	JTextArea log = new JTextArea(5, 20);
	private JScrollPane scrollusa;
	private JScrollPane scrollitalia;
	private JScrollPane scrolllog;
	private JButton start = new JButton("Start");
	private JButton stop = new JButton("Stop");
	public boolean connected = false;
	public boolean started = false;
	
	//COSTRUTTORE
	public Display() {
		super("Sofia Lapi 1837563");
		JPanel north = new JPanel();
		north.add(serveraddresslabel);
		north.add(serveraddressfield);
		north.add(portlabel);
		north.add(portfield);
		north.add(connect);
		north.add(disconnect);
		
		usa.setEditable(false);
		italia.setEditable(false);
		log.setEditable(false);
		scrollusa = new JScrollPane(usa);
		scrollitalia = new JScrollPane(italia);
		scrolllog = new JScrollPane(log);
		scrollusa.setBorder(BorderFactory.createTitledBorder("USA"));
		scrollitalia.setBorder(BorderFactory.createTitledBorder("Italia"));
		scrolllog.setBorder(BorderFactory.createTitledBorder("Log"));
		JPanel center = new JPanel();
		center.add(scrollusa);
		center.add(scrollitalia);
		center.add(scrolllog);
		
		JPanel south = new JPanel();
		south.add(start);
		south.add(stop);
		
		this.getContentPane().add(north, BorderLayout.NORTH);
		this.getContentPane().add(center, BorderLayout.CENTER);
		this.getContentPane().add(south, BorderLayout.SOUTH);
		
		//ASCOLTATORI
		ActionListener ascoltatore = new ClientListener(this);
		connect.addActionListener(ascoltatore);
		disconnect.addActionListener(ascoltatore);
		start.addActionListener(ascoltatore);
		stop.addActionListener(ascoltatore);
		connect.setActionCommand(ClientListener.CONNECT);
		disconnect.setActionCommand(ClientListener.DISCONNECT);
		start.setActionCommand(ClientListener.START);
		stop.setActionCommand(ClientListener.STOP);
		
		//PARTE DI VISIBILIT�
		this.setButtons();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	//METODO PER GESTIONE DI STATI 
	public void setButtons() {
		if (!connected) {
			connect.setEnabled(true);
			disconnect.setEnabled(false);
			start.setEnabled(false);
			stop.setEnabled(false);
		}else {
			connect.setEnabled(false);
			disconnect.setEnabled(true);
			start.setEnabled(true);
			stop.setEnabled(false);
			if (started) {
				start.setEnabled(false);
				stop.setEnabled(true);
				
			}else {
				stop.setEnabled(false);
				
			}
		}
		
	}

}