package citta;

import java.util.Scanner;

public class ReceiverThread implements Runnable{
	//CAMPI
	private Scanner scanner;
	private Display display;
	
	//COSTRUTTORE
	public ReceiverThread(Scanner scanner, Display display) {
		this.scanner = scanner;
		this.display = display;
	}
	
	@Override
	public void run() {
		boolean running = true;
		while (running) {
			String cmd = scanner.nextLine();
			String commands[] = cmd.split(":");
			if (commands[0].equals("START")) {
				continue;
			}else if (commands[0].equals("END")||commands[1].equals("END")) {
				//FINE TRASMISSIONE
				running = false;
				continue;
			}else if(commands[0].equals("INTERRUPTED")||commands[1].equals("INTERRUPTED")) {
				//TRASMISSIONE INTERROTTA
				running = false;
				continue;
			}else {
				//CASO RICEZIONE CITTA
				String attualeusa = display.usa.getText();
				String attualeitalia = display.italia.getText();
				String attualelog = display.log.getText();
				//mettere nel log
				String cittaRicevuta = commands[1];
				display.log.setText(attualelog + "\n" + cittaRicevuta);
				if(commands[0].equals("USA")) {
					//mettere in usa
					display.usa.setText(attualeusa + "\n" +cittaRicevuta);
				}else if(commands[0].equals("ITALIA")) {
					//mettere in ita
					display.italia.setText(attualeitalia + "\n" + cittaRicevuta);
				}
			}
		}
	}
}

