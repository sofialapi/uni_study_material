package scuole_elementari;

public class classe {
	private scuola scuola;
	private int modificaScuola=0;
	private String nome;
	private int modificaNome=0;
	insegnante[] insegnanti = new insegnante[3];
	int numeroAlunni;
	
	public classe(scuola scuola, String nome, insegnante[] insegnanti, int numeroAlunni) {
		this.scuola = scuola;
		this.nome = nome;
		this.insegnanti = insegnanti;
		this.numeroAlunni = numeroAlunni;
	}
	public void setScuola(scuola scuola) {
		if (this.modificaScuola == 0) {
			this.scuola = scuola;
			this.modificaScuola ++;
		}else {
			throw new RuntimeException("scuola non modificabile");
		}
	}
	public void setNome(String nome) {
		if (this.modificaNome == 0) {
			this.nome = nome;
			this.modificaNome ++;
		}else {
			throw new RuntimeException("nome non modificabile");
		}	
	}
	public void setInsegnanti(insegnante[] insegnanti) {
		this.insegnanti = insegnanti;
	}
	public void setNumeroAlunni(int numeroAlunni) {
		this.numeroAlunni = numeroAlunni;
	}
	
	public scuola getScuola() {
		return this.scuola;
	}
	public String getNome() {
		return this.nome;
	}
	public insegnante[] getInsegnanti() {
		return this.insegnanti;
	}
	public int getNumeroAlunni() {
		return this.numeroAlunni;
	}
	
	public void inserisciInsegnante(insegnante insegnante, int posizione) {
		this.insegnanti[posizione]=insegnante;
	}
	
	public void stampaScuolaClasse() {
		System.out.println(this.scuola.getNome());
	}
	public void stampaNomeClasse() {
		System.out.println(this.nome);
	}
	public void stampaInsegnantiClasse() {
		for (int i=0; i<3; i++) {
			if (this.insegnanti[i]!=null) {
				System.out.println(this.insegnanti[i].getNome());
			}
		}
	}
	public void stampaNumeroAlunni() {
		System.out.println(this.numeroAlunni);
	}
	
	public String toString() {
		return "Classe " + nome + ", insegnanti: " + insegnanti[0].getNome() + " " + insegnanti[0].getCognome()+ ", "
				+ insegnanti[1].getNome() + " " + insegnanti[1].getCognome()+ ", " + insegnanti[2].getNome() + " " + insegnanti[2].getCognome() +
				", scuola: " + scuola.getNome() + "," + numeroAlunni + " alunni";
	}

}
