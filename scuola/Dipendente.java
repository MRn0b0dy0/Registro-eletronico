/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Classe Dipendente
 * @author Passanisi Lorenzo Pio 4A
 */

package scuola;

import java.util.GregorianCalendar;

public abstract class Dipendente extends Utente {
    
    //Proprieta' 
    protected float stipendio; 
    
    //Costruttori
    /**
     * Inizializza lo stato iniziale di un'istanza Dipendente contestualmente alla sua creazione
     * @param codiceFiscale codice fiscale del dipendente creato
     * @param cognome cognome del dipendente creato
     * @param nome nome del dipendente creato
     * @param sesso sesso del dipendente creato
     * @param data_nascita data di nascita del dipendente creato
     */
    public Dipendente(String codiceFiscale, String cognome, String nome , char sesso, GregorianCalendar data_nascita) {
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
    public Dipendente(String codiceFiscale, String cognome, String nome, char sesso, int gg_nascita, int mm_nascita, int aaaa_nascita) {
        super(codiceFiscale, cognome, nome , sesso, gg_nascita, mm_nascita, aaaa_nascita);
    }
    
    /**
     * Inizializza lo stato iniziale di un'istanza Dipendente contestualmente alla sua creazione
     * @param codiceFiscale codice fiscale del dipendente creato
     * @param cognome cognome del dipendente creato
     * @param nome nome del dipendente creato
     */
    public Dipendente(String codiceFiscale, String cognome, String nome) {
        super(codiceFiscale, cognome, nome);
    }
    
    //Metodi
    public abstract void calcolaStipendio();
    
    public abstract float getStipendio();
    
    //Overriding dei metodi ereditati dalla classe Object
    /**
     * Fornisce una descrizione del dipendente
     * @return stringa con i dati anagrafici
     */
    @Override
    public String toString() {   
        return super.toString();        
    }
    
}