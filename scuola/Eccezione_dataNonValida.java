package scuola;

/**
 * Eccezione di "data non valida"
 * @author nunzio.galati
 */
public class Eccezione_dataNonValida extends Exception {
    
	int g;
	int m;
	int a;
	public Eccezione_dataNonValida(int g, int m, int a){
		super();
		this.g = g;
		this.m = m;
		this.a = a;
	}
	public String strData() {
		return g+"/"+m+"/"+a;
	}
	public String messaggioErrore() {
		return "Data non valida!";
	}
}
