package figure_geometriche;

public class Rettangolo extends FiguraGeometrica{
	private final double base, altezza;

	public Rettangolo(double base, double altezza) {
		this.base = base;
		this.altezza = altezza;
	}

	public Rettangolo(double base, double altezza, String descrizione) {
		super(descrizione);
		this.base = base;
		this.altezza = altezza;
	}

	public double getBase() {
		return base;
	}

	public double getAltezza() {
		return altezza;
	}

	public String toString() {
		return "Rettangolo " + getDescrizione() + "con base: " + this.getBase() + ", altezza: " +
			this.getAltezza() + ", area: " + area() + ", perimetro: " + perimetro();
	}

	public double area() {
		return this.getBase() * this.getAltezza();
	}

	public double perimetro() {
		return 2 * (this.getBase() + this.getAltezza());
	}

}
