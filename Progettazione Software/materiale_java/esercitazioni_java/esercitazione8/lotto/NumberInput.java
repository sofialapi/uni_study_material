package lotto;

import javax.swing.JOptionPane;
import java.io.*;
import java.lang.*; 
import java.util.*;

public class NumberInput implements Reader {

	@Override
	public String read() {
		String digit = JOptionPane.showInputDialog("inserire numero: ");
		if (digit == null) {return null;}
		boolean correctDigit = false; //gestione car non validi
		while (!correctDigit) { //gestione car non validi
		  try {
		    while (Integer.parseInt(digit)<0 || Integer.parseInt(digit)>9) {
			    digit = JOptionPane.showInputDialog("inserire numero: ");
			    if (digit == null) {return null;}
		    }
		    correctDigit = true; //gestione car non validi
		  }catch(NumberFormatException e) {
			  digit = JOptionPane.showInputDialog("inserire numero: ");
			  //gestione car non validi
		  }
		}
		return digit;
	}

}