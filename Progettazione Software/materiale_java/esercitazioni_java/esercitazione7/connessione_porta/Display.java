package connessione_porta;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Display extends JFrame{
	//COMPONENTI
	JPanel pannellosopra = new JPanel();
	GridLayout griglial = new GridLayout(2,2);
	JPanel pannellosotto = new JPanel();
	BorderLayout borderl = new BorderLayout();
	BorderLayout borderl1 = new BorderLayout();
	BorderLayout borderl2 = new BorderLayout();
	BorderLayout borderl3= new BorderLayout();
	JLabel labmatricola = new JLabel("matricola");
	//USA JTEXTFIELD NON JTEXTAREA
	JTextField matricola = new JTextField();
	JLabel labindirizzo = new JLabel("IP address");
	JTextField indirizzo = new JTextField();
	JLabel labporta = new JLabel("porta");
	JTextField porta = new JTextField();
	JPanel packmatricola = new JPanel();
	JPanel packindirizzo = new JPanel();
	JPanel packporta = new JPanel();
	JButton connect = new JButton("connect");
	JButton disconnect = new JButton("disconnect");
	JButton start = new JButton("start");
	JButton stop = new JButton("stop");
	//COSTRUTTORE
	public Display() {
		super("");
		this.getContentPane().setLayout(new BorderLayout());
		packmatricola.setLayout(borderl1);
		packindirizzo.setLayout(borderl2);
		packporta.setLayout(borderl3);
		packmatricola.add(labmatricola, BorderLayout.NORTH);
		packmatricola.add(matricola, BorderLayout.SOUTH);
		packindirizzo.add(labindirizzo, BorderLayout.NORTH);
		packindirizzo.add(indirizzo, BorderLayout.SOUTH);
		packporta.add(labporta, BorderLayout.NORTH);
		packporta.add(porta, BorderLayout.SOUTH);
		pannellosopra.setLayout(griglial);
		pannellosopra.add(packmatricola);
		pannellosopra.add(packindirizzo);
		pannellosopra.add(packporta);
		pannellosotto.add(connect);
		pannellosotto.add(disconnect);
		pannellosotto.add(start);
		pannellosotto.add(stop);
		this.add(pannellosopra, BorderLayout.NORTH);
		this.add(pannellosotto, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//LISTENER E ACTION COMMANDS
		ActionListener listener = new Listener(this, matricola, indirizzo, porta);
		connect.addActionListener(listener);
		disconnect.addActionListener(listener);
		start.addActionListener(listener);
		stop.addActionListener(listener);
		connect.setActionCommand("connect");
		disconnect.setActionCommand("disconnect");
		start.setActionCommand("start");
		stop.setActionCommand("stop");
	}
	public void settaBottoni(boolean connesso, boolean trasmettendo) {
		if (connesso) {
			connect.setEnabled(false);
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			if (trasmettendo) {
				disconnect.setEnabled(false);
				stop.setEnabled(true);
				start.setEnabled(false);
			}else { //CONNESSO MA NON IN TRASMISSIONE
				stop.setEnabled(false);
				start.setEnabled(true);
				disconnect.setEnabled(true);
			}
		}else {//NON CONNESSO
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			connect.setEnabled(true);
			disconnect.setEnabled(false);
			start.setEnabled(false);
			stop.setEnabled(false);
		}
	}
}
