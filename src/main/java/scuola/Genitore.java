/**
 * Classe Genitore.java
 * @version: 1.0
 * @author Lorenzo Bramato, Alfredo Russo
 */

package scuola;
import java.util.GregorianCalendar;

public class Genitore extends Utente
{
    /**
     * Metodo costruttore della classe genitore
     * @param codiceFiscale
     * @param cognome
     * @param nome
     * @param sesso
     * @param data_nascita
     * @author Russo Alfredo
     * @author Bramato Lorenzo
     */
    public Genitore(String codiceFiscale, String cognome, String nome, char sesso, GregorianCalendar data_nascita, figura rapporto)
    {
        super(codiceFiscale, cognome, nome, sesso, data_nascita);
        this.rapporto = rapporto;
        this.numeroFigli=0;
    }

    /**
     * Metodo costruttore della classe genitore
     * @param codiceFiscale
     * @param cognome
     * @param nome
     * @param sesso
     * @param gg_nascita
     * @param mm_nascita
     * @param aaaa_nascita
     * @author Russo Alfredo
     * @author Bramato Lorenzo
     */
    public Genitore(String codiceFiscale, String cognome, String nome, char sesso, int gg_nascita, int mm_nascita, int aaaa_nascita, figura rapporto)
    {
        super(codiceFiscale, cognome, nome, sesso, gg_nascita, mm_nascita, aaaa_nascita);
        this.rapporto = rapporto;
        this.numeroFigli=0;
    }

    //Metodi get/set
    public static int getMaxFigli()
    {
        return Genitore.MAXFIGLI;
    }

    /**
     * Metodo getFigli
     * @return figli
     * @author Russo Alfredo
     * @author Bramato Lorenzo
     */
    public Studente[] getFigli()
    {
        return this.figli;
    }

    /**
     * Metodo getRapporto
     * @return rapporto
     * @author Russo Alfredo
     * @author Bramato Lorenzo
     */
    public figura getRapporto()
    {
        return this.rapporto;
    }

    /**
     * Metodo associa
     * @param studente
     * @author Russo Alfredo
     * @author Bramato Lorenzo
     */
    public void associa(Studente studente)
    {
        if (this.numeroFigli < Genitore.MAXFIGLI)
        {
            this.figli[this.numeroFigli] = studente;
            this.numeroFigli++;
        }
    }

    /**
     * Metodo associa
     * @param studenti
     * @author Russo Alfredo
     * @author Bramato Lorenzo
     */
    public void associa(Studente[] studenti)
    {
        this.figli = studenti;
        this.numeroFigli = this.figli.length;
    }

    /**
     * Metodo toString
     * @return genitore
     * @author Russo Alfredo
     * @author Bramato Lorenzo
     */
    @Override
    public String toString()
    {
        String genitore = super.toString() + " " + "\n" + this.rapporto + " di: ";

        for(int i = 0; i < this.numeroFigli; i++)
        {
            genitore += this.figli[i].toString() + ", ";
        }

        return genitore;
    }

    /**
     * Metodo equals
     * @param altro
     * @return true this e altro sono uguali, false se this e altro non sono uguali
     * @author Russo Alfredo
     * @author Bramato Lorenzo
     */
    @Override
    public boolean equals(Object altro)
    {
        if (altro instanceof Genitore)
            return super.equals((Utente)altro);
        else
            return false;
    }

    private static int MAXFIGLI = 10;
    public enum figura {PADRE, MADRE, TUTORE}
    private Studente[] figli = new Studente[MAXFIGLI];
    private figura rapporto;
    private int numeroFigli;
}
