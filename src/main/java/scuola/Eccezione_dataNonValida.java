/**
 * Eccezione di "data non valida"
 * @author nunzio.galati
 */

package scuola;


public class Eccezione_dataNonValida extends Exception 
{
	final int g;
	final int m;
	final int a;

	public Eccezione_dataNonValida(int g, int m, int a)
	{
		super();
		this.g = g;
		this.m = m;
		this.a = a;
	}

	public String strData() 
	{
		return g + "/" + m + "/" + a;
	}

	public String messaggioErrore() 
	{
		return "Data non valida!";
	}
}
