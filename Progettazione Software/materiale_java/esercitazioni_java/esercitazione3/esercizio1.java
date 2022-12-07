import java.util.*;

public class esercizio1 {
	public static void main(String[] args) {
		int righe;
	    int colonne;
		Scanner s = new Scanner( System.in );
	    System.out.print( "inserire numero di righe: " );
	    righe = s.nextInt();
	    System.out.print( "inserire numero di colonne: " );
	    colonne = s.nextInt();
	    double[][] matrice = new double[righe][colonne];
	    s.close();
	    Random rand = new Random();
	    for (int i=0; i<righe; i++) {
	    	for (int j=0; j<colonne; j++) {
	    		double double_random=rand.nextDouble();
	    		matrice[i][j]=double_random;
	    	}
	    	System.out.println(Arrays.toString(matrice[i]));
	    }
	    return;
	}
}