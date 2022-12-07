package figure_geometriche;

public class principale {
	public static double sommaAree(FiguraGeometrica[] af) {
		double somma = 0;
		for (int i = 0; i < af.length; i++) {
			somma = somma + af[i].area();
		}
		return somma;
	}
	
	public static void main(String[] args) {
		Triangolo triangolo = new Triangolo("lalala", 3,6,7);
		System.out.println(triangolo.perimetro());
		System.out.println(triangolo.area());
		System.out.println(triangolo.toString());
		
		FiguraGeometrica[] af = new FiguraGeometrica[10];
		for (int i = 0; i < af.length; i++) {
			if (Math.random() < 1.0 / 5.0){
				double l = Math.random()*10;
				af[i] = new Triangolo(l, 5*l/6, 2*l/3);
			}
			else if (Math.random() < 2.0 / 5.0)
				af[i] = new Cerchio(Math.random() * 10);
			else if (Math.random() < 3.0 / 5.0)
				af[i] = new Ellisse(Math.random() * 10, Math.random() * 10);
			else if (Math.random() < 4.0 / 5.0)
				af[i] = new Quadrato(Math.random() * 10);
			else
				af[i] = new Rettangolo(Math.random() * 10, Math.random() * 10);
			
			System.out.println(af[i]);
		}
		
		double s = sommaAree(af);
		System.out.println("Area totale = " + s);
		
	}
}
