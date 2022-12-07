package pannello_codice_2;

import java.awt.*;
import javax.swing.*;

public class Display extends JFrame{
	final JPanel pannello1 = new JPanel();
	final JPanel pannello2 = new JPanel();
	final JPasswordField pswfield = new JPasswordField();
	final JPanel pannello3 = new JPanel();
	final JLabel etichetta = new JLabel("codice digitato:");
	final JTextArea txtfield = new JTextArea(3, 30); 
	final JButton btn1 = new JButton("1");
	final JButton btn2 = new JButton("2");
	final JButton btn3 = new JButton("3");
	final JButton btn4 = new JButton("4");
	final JButton btn5 = new JButton("5");
	final JButton btn6 = new JButton("6");
	final JButton btn7 = new JButton("7");
	final JButton btn8 = new JButton("8");
	final JButton btn9 = new JButton("9");
	final JButton btn0 = new JButton("0");
	final JButton btnC = new JButton("C");
	final JButton btnM = new JButton("Mostra");
	
	final GridLayout gridl = new GridLayout(4,3);
	final BorderLayout borderl = new BorderLayout();
	final BorderLayout borderl2 = new BorderLayout();
	
	public Display(){
		super("Pannello Digitale");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new FlowLayout());
		
		pannello3.setLayout(gridl);
		pannello3.add(btn1);
		pannello3.add(btn2);
		pannello3.add(btn3);
		pannello3.add(btn4);
		pannello3.add(btn5);
		pannello3.add(btn6);
		pannello3.add(btn7);
		pannello3.add(btn8);
		pannello3.add(btn9);
		pannello3.add(btnC);
		pannello3.add(btn0);
		pannello3.add(btnM);
		pannello1.setLayout(borderl);
		pswfield.setEditable(false);
		pannello1.add(pswfield, BorderLayout.NORTH);
		pannello1.add(pannello3, BorderLayout.SOUTH);
		pannello2.setLayout(borderl2);
		pswfield.setBorder(BorderFactory.createLineBorder(Color.black));
		pannello2.add(etichetta, BorderLayout.NORTH);
		txtfield.setEditable(false);
		txtfield.setBorder(BorderFactory.createLineBorder(Color.black));
		pannello2.add(txtfield, BorderLayout.SOUTH);
		this.add(pannello1);
		this.add(pannello2);
		this.pack();
		this.setVisible(true);
		
		/*LISTENER E ACTION COMMANDS
		 * NOTA LA PRIMA RIGA IN CUI DICHIARI
		 * IL NUOVO OGGETTO ASCOLTATORE CHE TI SERVE PER TUTTI
		 * GLI OGGETTI BOTTONE
		 */
		Listener ascoltatore = new Listener(this);
		btn1.setActionCommand("1");
		btn1.addActionListener(ascoltatore);
		btn2.setActionCommand("2");
		btn2.addActionListener(ascoltatore);
		btn3.setActionCommand("3");
		btn3.addActionListener(ascoltatore);
		btn4.setActionCommand("4");
		btn4.addActionListener(ascoltatore);
		btn5.setActionCommand("5");
		btn5.addActionListener(ascoltatore);
		btn6.setActionCommand("6");
		btn6.addActionListener(ascoltatore);
		btn7.setActionCommand("7");
		btn7.addActionListener(ascoltatore);
		btn8.setActionCommand("8");
		btn8.addActionListener(ascoltatore);
		btn9.setActionCommand("9");
		btn9.addActionListener(ascoltatore);
		btn0.setActionCommand("0");
		btn0.addActionListener(ascoltatore);
		btnC.setActionCommand("C");
		btnC.addActionListener(ascoltatore);
		btnM.setActionCommand("Mostra");
		btnM.addActionListener(ascoltatore);
	}
}
