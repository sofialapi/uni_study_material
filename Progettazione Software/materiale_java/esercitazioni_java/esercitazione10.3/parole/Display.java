package parole;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Display extends JFrame{
	//COMPONENTI GRAFICI
	private JLabel addresslabel = new JLabel("Server Address");
	JTextField addressfield = new JTextField(20);
	private JLabel portlabel = new JLabel("Port");
	JTextField portfield = new JTextField(6);
	private JButton connect = new JButton("Connect");
	private JButton disconnect = new JButton("Disconnect");
	JTextArea ai = new JTextArea(10, 15);
	JTextArea jr = new JTextArea(10, 15);
	JTextArea sz = new JTextArea(10, 15);
	private JScrollPane scrollai ;
	private JScrollPane scrolljr ;
	private JScrollPane scrollsz ;
	private JLabel stringlabel = new JLabel("Inserisci la Stringa");
	JTextField stringfield = new JTextField(15);
	private JButton get = new JButton("Get");
	private JButton stop = new JButton("Stop");
	//COMPONENTI BOOLEAN PER LO STATO
	boolean connected = false;
	boolean started = false;
	
	//COSTRUTTORE
	public Display() {
		super("Sofia Lapi 1837563");
		JPanel north = new JPanel();
		north.add(addresslabel);
		north.add(addressfield);
		north.add(portlabel);
		north.add(portfield);
		north.add(connect);
		north.add(disconnect);
		
		ai.setEditable(false);
		jr.setEditable(false);
		sz.setEditable(false);
		scrollai = new JScrollPane(ai);
		scrolljr = new JScrollPane(jr);
		scrollsz = new JScrollPane(sz);
		scrollai.setBorder(BorderFactory.createTitledBorder("A-I"));
		scrolljr.setBorder(BorderFactory.createTitledBorder("J-R"));
		scrollsz.setBorder(BorderFactory.createTitledBorder("S-Z"));
		JPanel center = new JPanel();
		center.add(scrollai);
		center.add(scrolljr);
		center.add(scrollsz);
		
		JPanel south = new JPanel();
		south.add(stringlabel);
		south.add(stringfield);
		south.add(get);
		south.add(stop);
		
		this.getContentPane().add(north, BorderLayout.NORTH);
		this.getContentPane().add(center, BorderLayout.CENTER);
		this.getContentPane().add(south, BorderLayout.SOUTH);
		
		//ASCOLTATORE E COMANDI
		ActionListener ascoltatore = new ClientListener(this);
		connect.addActionListener(ascoltatore);
		disconnect.addActionListener(ascoltatore);
		get.addActionListener(ascoltatore);
		stop.addActionListener(ascoltatore);
		connect.setActionCommand(ClientListener.CONNECT);
		disconnect.setActionCommand(ClientListener.DISCONNECT);
		get.setActionCommand(ClientListener.GET);
		stop.setActionCommand(ClientListener.STOP);
		
		this.setButtons();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	//METODO SETBUTTONS
	public void setButtons() {
		if (!connected) {
			connect.setEnabled(true);
			disconnect.setEnabled(false);
			get.setEnabled(false);
			stop.setEnabled(false);
		}else {
			connect.setEnabled(false);
			disconnect.setEnabled(true);
			get.setEnabled(true);
			stop.setEnabled(false);
			if (started) {
				get.setEnabled(false);
				stop.setEnabled(true);
			}else {
				//get.setEnabled(true);
				stop.setEnabled(false);
			}
		}
	}

}
