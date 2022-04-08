/**
 *  Video.java (per l'output su console)
 *
 *  @version 4.0 - feb 2017
 *  @author  N. Galati - ITI E.Mattei Maglie
 */
package scuola;

import java.text.*;

public class Video {    
	/**
	*  scrittura di una stringa a video (senza andare a capo)
        *  @param s
	*/
	public static void scriviStringa(String s) {
            System.out.print(s);
            System.out.flush();
	}	
	/**
	*  scrittura di un numero intero
        *  @param n numero da visualizzare
        */
	public static void scriviIntero(int n) {
            Integer x = n;
            System.out.print(x);
            System.out.flush();
	}	
	/**
	*  scrittura a video di un numero reale a singola precisione
        *  @param n numero da visualizzare
	*/
	public static void scriviReale(float n) {
            Float x = n;		  
            System.out.print(x);
            System.out.flush();
	}
        /**
	*  scrittura a video di un numero reale a doppia precisione
        *  @param n numero da visualizzare
	*/
	public static void scriviReale(double n) {
            Double x = n;
            System.out.print(x);
            System.out.flush();
	}
	/**
	*  scrittura di un numero reale con
        *  @param n numero da visualizzare
        *  @param d numero di cifre decimali
	*/
	public static void scriviReale(float n, int d) {	
            Float x = n;
            String pattern = "#.";
            for (int i=1; i<=d; i++)  	
                pattern=pattern.concat("#");
            DecimalFormat f = new DecimalFormat(pattern);
            System.out.print(f.format(x));
            System.out.flush();
	}
        /**
	*  scrittura di un numero formattato in euro (con due cifre decimali fisse)
        *  @param n numero da visualizzare
	*/
	public static void scriviEuro(float n) {	
            Float x = n;
            String pattern = "� #.00";
            DecimalFormat f = new DecimalFormat(pattern);
            System.out.print(f.format(x));
            System.out.flush();
	}
	/**
	*  porta il cursore a capo
	*/
	public static void aCapo() {
            System.out.println();
	}
} 
