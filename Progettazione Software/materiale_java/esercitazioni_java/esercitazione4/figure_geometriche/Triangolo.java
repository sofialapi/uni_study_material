package figure_geometriche;

public class Triangolo extends FiguraGeometrica{
	//NON è ABSTRACT ALTRIMENTI NON PUOI CREARE OGGETTI DI TIPO TRIANGOLO
	private final double lato1;
	private final double lato2;
	private final double lato3;
	
	public Triangolo(double lato1, double lato2, double lato3) {
		this.lato1 = lato1;
		this.lato2 = lato2;
		this.lato3 = lato3;
	}
	public Triangolo(String descrizione, double lato1, double lato2, double lato3) {
		super(descrizione);
		this.lato1 = lato1;
		this.lato2 = lato2;
		this.lato3 = lato3;
	}
	
	public double getLato1() {
		return this.lato1;
	}
	public double getLato2() {
		return this.lato2;
	}
	public double getLato3() {
		return this.lato3;
	}
	
	public double area() {
		return (lato1*lato2)/2;
	}
	
	public double perimetro() {
		return lato1+lato2+lato3;
	}
	
	public String toString() {
		return "Triangolo; descrizione: "+getDescrizione()+ 
				" con lati: "+this.getLato1()+", "
				+this.getLato2()+", "
				+this.getLato3()+
				". Perimetro: "+this.perimetro()+
				". Area: "+this.area();
	}
}
