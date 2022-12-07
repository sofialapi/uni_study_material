package scuole_elementari;

public class scuola {
	private String nome;
	private int modificaNome = 0;
	private String indirizzo;
	private int modificaIndirizzo = 0;
	private String provveditorato;
	private int modificaProvveditorato = 0;
	
	public scuola(String nome, String indirizzo, String provveditorato){
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.provveditorato = provveditorato;
	}
	
	public void setNome(String nome) {
		if (this.modificaNome == 0) {
			this.nome = nome;
			this.modificaNome ++;
		}else {
			throw new RuntimeException("nome non modificabile");
		}	
	}
	public void setIndirizzo(String indirizzo) {
		if (this.modificaIndirizzo == 0) {
			this.indirizzo = indirizzo;
			this.modificaIndirizzo ++;
		}else {
			throw new RuntimeException("indirizzo non modificabile");
		}	
	}
	public void setProvveditorato(String provveditorato) {
		if (this.modificaProvveditorato == 0) {
			this.provveditorato = provveditorato;
			this.modificaProvveditorato ++;
		}else {
			throw new RuntimeException("provveditorato non modificabile");
		}	
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getIndirizzo() {
		return this.indirizzo;
	}
	public String getProvveditorato() {
		return this.provveditorato;
	}	
	
	public void stampaNomeScuola() {
		System.out.println(this.nome);
	}
	public void stampaIndirizzoScuola() {
		System.out.println(this.indirizzo);
	}
	public void stampaProvveditoratoScuola() {
		System.out.println(this.provveditorato);
	}
	public String toString() {
		return "Scuola: " + nome + ", " + provveditorato + " in " + indirizzo;
	}
}
