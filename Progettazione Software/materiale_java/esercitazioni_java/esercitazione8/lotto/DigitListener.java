package lotto;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

final class DigitListener implements ActionListener {
	
	//listener per cambio cifra con il click
	protected DigitListener(){
		super();
	}
	
	public void actionPerformed(ActionEvent e) {
		ColoredButton cb = (ColoredButton) e.getSource();
		Reader r = new NumberInput();
		String digit = r.read();
		if (digit!=null) {
			cb.setTextDigit(""+digit);
			cb.changeColor(Color.LIGHT_GRAY);
		}
	}

}