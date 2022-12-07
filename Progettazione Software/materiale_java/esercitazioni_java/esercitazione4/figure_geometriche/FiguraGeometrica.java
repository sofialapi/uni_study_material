package figure_geometriche;

public abstract class FiguraGeometrica {
	//è ABSTRACT COSI NON POSSONO ESSERE CREATI OGGETTI DI TIPO FIGURA GEOMETRICA
	//MA SERVE DA STRUTTURA PER LE ALTRE CLASSI,
	//PER DEFINIRE UNO SCHELETRO COMUNE DI PROPRIETà E FUNZIONI
	String descrizione = "";
	
	public FiguraGeometrica() {
	}
	public FiguraGeometrica(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getDescrizione() {
		return this.descrizione;
	}
	
	public abstract double area();
	
	public abstract double perimetro();
	
	public abstract String toString();

}
