/**
 * Classe Dipendente
 * @author Passanisi Lorenzo Pio 4A
 */

package scuola;
import java.util.GregorianCalendar;


public abstract class Dipendente extends Utente 
{        
    /**
     * Inizializza lo stato iniziale di un'istanza Dipendente contestualmente alla sua creazione
     * @param codiceFiscale codice fiscale del dipendente creato
     * @param cognome cognome del dipendente creato
     * @param nome nome del dipendente creato
     * @param sesso sesso del dipendente creato
     * @param data_nascita data di nascita del dipendente creato
     */
    public Dipendente(String codiceFiscale, String cognome, String nome , char sesso, GregorianCalendar data_nascita) 
    {
        super(codiceFiscale, cognome, nome , sesso, data_nascita);
    }
    
    /**
     * Inizializza lo stato iniziale di un'istanza Dipendente contestualmente alla sua creazione
     * @param codiceFiscale codice fiscale del dipendente creato
     * @param cognome cognome del dipendente creato
     * @param nome nome del dipendente creato
     * @param sesso genere del dipendente
     * @param gg_nascita giorno di nascita del dipendente creato
     * @param mm_nascita mese di nascita del dipendente creato
     * @param aaaa_nascita anno di nascita del dipendente creato
     */
    public Dipendente(String codiceFiscale, String cognome, String nome, char sesso, int gg_nascita, int mm_nascita, int aaaa_nascita) 
    {
        super(codiceFiscale, cognome, nome , sesso, gg_nascita, mm_nascita, aaaa_nascita);
    }
    
    /**
     * Inizializza lo stato iniziale di un'istanza Dipendente contestualmente alla sua creazione
     * @param codiceFiscale codice fiscale del dipendente creato
     * @param cognome cognome del dipendente creato
     * @param nome nome del dipendente creato
     */
    public Dipendente(String codiceFiscale, String cognome, String nome) 
    {
        super(codiceFiscale, cognome, nome);
    }
    
    //abstract method calcola lo stipendio
    public abstract void calcolaStipendio();

    //abstract method ritorna lo stipendio lo stimpendio
    public abstract float getStipendio();
    
    /**
     * Fornisce una descrizione del dipendente
     * @return stringa con i dati anagrafici
     */
    @Override
    public String toString() 
    {   
        return super.toString();        
    }
 

    protected float stipendio; 
}