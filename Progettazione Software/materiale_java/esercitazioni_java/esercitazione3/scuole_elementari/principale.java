package scuole_elementari;

public class principale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scuola scuola = new scuola("nome scuola default", "via default", "provveditorato default");
		scuola.stampaNomeScuola();
		scuola.setNome("nome scuola modificato");
		scuola.stampaNomeScuola();
		scuola.stampaIndirizzoScuola();
		
		insegnante insegnante = new insegnante("mario","rossi",1978,scuola);
		insegnante.stampaNomeInsegnante();
		insegnante.stampaScuolaInsegnante();
		insegnante.setAnnoVincita(1977);
		insegnante.stampaAnnoVincitaInsegnante();
		
		insegnante insegnante1 = new insegnante("primo","primi",1999,scuola);
		insegnante insegnante2 = new insegnante("secondo","secondi",1999,scuola);
		insegnante insegnante3 = new insegnante("terzo","terzi",1999,scuola);
		insegnante insegnante4 = new insegnante("quarto","quarti",1999,scuola);
		insegnante[] insegnanti = new insegnante[3];
		insegnanti[0] = insegnante1;
		insegnanti[1] = insegnante2;
		insegnanti[2] = insegnante3;
		
		classe classe = new classe(scuola, "V A", insegnanti, 13);
		classe.stampaInsegnantiClasse();
		classe.inserisciInsegnante(insegnante4, 0);
		classe.stampaInsegnantiClasse();
		
		System.out.println(scuola.toString());
		System.out.println(insegnante.toString());
		System.out.println(classe.toString());
		return;
		
	}

}
