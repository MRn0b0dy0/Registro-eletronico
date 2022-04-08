/**
 * Classe Ata.java
 * @version: 1.0
 * @author Jacopo Pellegrino
 */

package scuola;
import java.util.GregorianCalendar;


public class Ata extends Dipendente
{
    /**
     * primo metodo costruttore
     * @autor pellegrino jacopo
     * @param codiceFiscale
     * @param nome
     * @param cognome
     * @param sesso
     * @param data_nascita
     * @param ruolo
     * @return /
     */
    public Ata(String codiceFiscale, String nome, String cognome, char sesso, GregorianCalendar data_nascita, tipoRuolo ruolo)
    {
        super(codiceFiscale, nome, cognome, sesso, data_nascita);
        this.ruolo = ruolo;
    }

    /**
     * secondo metodo costruttore
     * @autor pellegrino jacopo
     * @param codiceFiscale
     * @param nome
     * @param cognome
     * @param sesso
     * @param gg_nascita
     * @param mm_nascita
     * @param aaaa_nascita
     * @return /
     */
    public Ata(String codiceFiscale, String nome, String cognome, char sesso, int gg_nascita, int mm_nascita, int aaaa_nascita)
    {
        super(codiceFiscale, nome, cognome, sesso, gg_nascita, mm_nascita, aaaa_nascita);
    }

    /**
     * terzo metodo costruttore
     * @autor pellegrino jacopo
     * @param codiceFiscale
     * @param nome
     * @param cognome
     * @return /
     */
    public Ata(String codiceFiscale, String nome, String cognome)
    {
        super(codiceFiscale, nome, cognome);
    }

    /**
     * metodo set
     * @autor pellegrino jacopo
     * @param /
     * @return tipoRuolo
     */
     public tipoRuolo setruolo()
     {
         return ruolo;
     }

    /**
     * metodo get
     * @autor pellegrino jacopo
     * @param ruolo
     * @return /
     */
     public void getruolo(tipoRuolo ruolo)
     {
        this.ruolo = ruolo;
     }

     /**
     * metodo per il calcolo dello stipendio
     * @autor pellegrino jacopo
     * @param /
     * @return /
     */
    @Override
    public void calcolaStipendio()
    {
        if (ruolo == tipoRuolo.COLLABORATORE)
            this.stipendio = 30 * oresettimanali;
        else if (ruolo == tipoRuolo.ASSISTENTE_LABORATORIO)
            this.stipendio = 40 * oresettimanali;
        else if (ruolo == tipoRuolo.SEGRETERIA)
            this.stipendio = 45 * oresettimanali;
    }

    @Override
    public float getStipendio()
    {
        return this.stipendio;
    }

    /**
     * metodo tostring
     * @autor pellegrino jacopo
     * @return string
     */
    @Override
    public String toString()
    {
       return super.toString() + "ruolo=" + this.ruolo;
    }

    /**
     * metodo equals
     * @autor pellegrino jacopo
     * @param Ata
     * @return boolean
     */
    public boolean equals(Object Ata)
    {
        if (this == Ata)
            return true;

        if (Ata == null)
            return false;

        if(!(Ata instanceof Ata))
            return false;

        Ata p = (Ata)Ata;

        return this.codiceFiscale == p.codiceFiscale;
    }

    private int oresettimanali;
    public enum tipoRuolo {COLLABORATORE, ASSISTENTE_LABORATORIO, SEGRETERIA};
    private tipoRuolo ruolo;
}
