package figure_geometriche;

public class Ellisse extends FiguraGeometrica {

	private final double semiasseMaggiore;
	private final double semiasseMinore;

	public Ellisse(double a, double b) {
		if (a > b) {
			this.semiasseMaggiore = a;
			this.semiasseMinore = b;
		} else {
			this.semiasseMaggiore = b;
			this.semiasseMinore = a;
		}
	}

	public Ellisse(double a, double b, String descrizione) {
		super(descrizione);
		if (a > b) {
			this.semiasseMaggiore = a;
			this.semiasseMinore = b;
		} else {
			this.semiasseMaggiore = b;
			this.semiasseMinore = a;
		}

	}

	public double getSemiasseMaggiore() {
		return semiasseMaggiore;
	}

	public double getSemiasseMinore() {
		return semiasseMinore;
	}

	public String toString() {
		return "Ellisse " + getDescrizione() + "con semiasse maggiore: " + this.getSemiasseMaggiore() 
		+ ", semiasse minore: "+ this.getSemiasseMinore() + ", area: " + this.area() + 
		" perimetro: " + this.perimetro();
	}

	public double area() {
		return Math.PI * this.getSemiasseMaggiore() * this.getSemiasseMinore();
	}

	public double perimetro() {
		return 2 * Math.PI * Math.sqrt((this.getSemiasseMaggiore() * this.getSemiasseMaggiore() + this.getSemiasseMinore() * this.getSemiasseMinore())/2);
	}
}