package parole;

import java.util.Scanner;

public class ReceiverThread implements Runnable{
	//CAMPI
	private Display display;
	private Scanner scanner;
	
	public ReceiverThread(Display display, Scanner scanner) {
		this.display = display;
		this.scanner = scanner;
	}

	@Override
	public void run() {
		boolean running = true;
		while (running) {
			String cmd = scanner.nextLine();
			if (cmd.equals("END")) {
				running=false;
			}else if(cmd.equals("INTERRUPTED")) {
				running=false;
			}else if(cmd.equals("ERROR")) {
				running=false;
			}else {
				String attualeai = this.display.ai.getText();
				String attualejr = this.display.jr.getText();
				String attualesz = this.display.sz.getText();
				if ((cmd.compareTo("i")<0 || String.valueOf(cmd.charAt(0)).equals("i")) 
						&& (cmd.compareTo("a")>0 || String.valueOf(cmd.charAt(0)).equals("a"))) {
					display.ai.setText(attualeai + "\n" + cmd);
				}else if((cmd.compareTo("q")<0 || String.valueOf(cmd.charAt(0)).equals("q")) 
						&& (cmd.compareTo("j")>0 || String.valueOf(cmd.charAt(0)).equals("j"))) {
					display.jr.setText(attualejr + "\n" + cmd);
				}else {
					display.sz.setText(attualesz + "\n" + cmd);
				}
			}
		}
	}

}
