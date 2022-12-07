package scuole_elementari;

public class insegnante {
	private String nome;
	private int modificaNome = 0;
	private String cognome;
	private int modificaCognome = 0;
	private int annoVincita;
	private int modificaAnnoVincita=0;
	scuola scuola;
	
	public insegnante(String nome, String cognome, int annoVincita, scuola scuola) {
		this.nome = nome;
		this.cognome = cognome;
		this.annoVincita = annoVincita;
		this.scuola = scuola;
	}
	
	public void setNome(String nome) {
		if (this.modificaNome == 0) {
			this.nome = nome;
			this.modificaNome ++;
		}else {
			throw new RuntimeException("nome non modificabile");
		}	
	}
	public void setCognome(String cognome) {
		if (this.modificaCognome == 0) {
			this.cognome = cognome;
			this.modificaCognome ++;
		}else {
			throw new RuntimeException("cognome non modificabile");
		}	
	}
	public void setAnnoVincita(int annoVincita) {
		if (this.modificaAnnoVincita == 0) {
			this.annoVincita = annoVincita;
			this.modificaAnnoVincita ++;
		}else {
			throw new RuntimeException("anno vincita non modificabile");
		}	
	}
	public void setScuola(scuola scuola) {
		this.scuola = scuola;
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getCognome() {
		return this.cognome;
	}
	public int getAnnoVincita() {
		return this.annoVincita;
	}
	public scuola getScuola() {
		return this.scuola;
	}
	
	public void stampaNomeInsegnante() {
		System.out.println(this.nome);
	}
	public void stampaCognomeInsegnante() {
		System.out.println(this.cognome);
	}
	public void stampaAnnoVincitaInsegnante() {
		System.out.println(this.annoVincita);
	}
	public void stampaScuolaInsegnante() {
		System.out.println(this.scuola.getNome());
	}
	
	public String toString() {
		return "Insegnante: " + nome + " " + cognome + ", dal " + annoVincita + " presso " + scuola.getNome();
	}

}
