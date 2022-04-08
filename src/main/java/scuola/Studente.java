/**
 * @author Latino Francesco
 * @author Serrone Fabio
 * Classe studente: implementà l'entità studente
 * */

package scuola;
import java.util.GregorianCalendar;


public class Studente extends Utente implements Comparable<Studente> {

    /**
     * @author Latino Francesco
     * @author Serrone Fabio
     * @param codiceFiscale
     * @param cognome
     * @param nome
     * @param sesso
     * @param data_nascita
     *
     *Costruttore partendo dal codice fiscale e dal nome, sesso e data di nascita come oggetto @see <a href= "https://docs.oracle.com/javase/7/docs/api/java/util/GregorianCalendar.html", richiama il costruttore della classe base.
     */
    public Studente(String codiceFiscale, String cognome, String nome, char sesso, GregorianCalendar data_nascita)
    {
        super(codiceFiscale, cognome, nome, sesso, data_nascita);
        assegnaMatricola();
    }

    /**
     * @author Latino Francesco
     * @author Serrone Fabio
     * @param codiceFiscale
     * @param cognome
     * @param nome
     * @param sesso
     * @param gg_nascita
     * @param mese_nascita
     * @param aaaa_nascita
     *
     *Costruttore partendo dal codice fiscale e dal nome, sesso, giorno mese e anno di nascita, richiama il costruttore della classe base.
     */
    public Studente(String codiceFiscale, String cognome, String nome, char sesso, int gg_nascita, int mese_nascita, int aaaa_nascita)
    {
        super(codiceFiscale, cognome, nome, sesso, new GregorianCalendar(aaaa_nascita, mese_nascita, gg_nascita));
        assegnaMatricola();
    }

    /**
     * @author Latino Francesco
     * @author Serrone Fabio
     * @param codiceFiscale
     * @param cognome
     * @param nome
     *
     * Costruttore partendo solo dal codice fiscale e dal nome e cognome, richiama il costruttore della classe base.
     */
    public Studente(String codiceFiscale, String cognome, String nome)
    {
        super(codiceFiscale, cognome, nome);
        assegnaMatricola();
    }

    /**
     * @author Latino Francesco
     * @author Serrone Fabio
     * @return parentela
     * Metodo get per l'oggetto Genitore, ritorna un puntatore a quest'ultimo
     */
    public Genitore[] getParentela()
    {
        return this.parentela;
    }

    /**
     * @author Latino Francesco
     * @author Serrone Fabio
     * @param parentela i genitori dello studente
     * Medoto set per l'oggetto Genitore, assegna il valore passato per parametro a parentela
     */
    public void setParentela(Genitore[] parentela)
    {
        this.parentela = parentela;
    }

    /**
     * @author Latino Francesco
     * @author Serrone Fabio
     * @return classe
     * Metodo get per l'oggetto Classe, ritorna un puntatore a quest'ultimo
     */
    public Classe getClasseAppartenenza()
    {
        return this.classe;
    }

    /**
     * @author Latino Francesco
     * @author Serrone Fabio
     * @return pagella
     * Metodo get per l'oggetto Pagella, ritorna un puntatore a quest'ultimo
     */
    public Pagella getPagella()
    {
        return this.pagella;
    }

    /**
     * @author Latino Francesco
     * @author Serrone Fabio
     * @param pagella
     * Medoto set per l'oggetto Pagella, assegna il valore passato per parametro a pagella
     */
    public void setPagella(Pagella pagella)
    {
        pagella.studente = this;
        this.pagella = pagella;
    }

    /**
     * @author Latino Francesco
     * @author Serrone Fabio
     * @return matricola
     * Metodo get per la proprietà matricola
     */
    public int getMatricola()
    {
        return this.matricola;
    }

    /**
     * @author Latino Francesco
     * @author Serrone Fabio
     * Medoto set per la proprietà matricola, assegna il valore passato per parametro a matricola
     */
    private void assegnaMatricola()
    {
        matricola = ++matricolaAttuale;
    }

    /**
     * @author Latino Francesco
     * @author Serrone Fabio
     * Ritorna lo stato di rappresentate
     */
    public boolean isRappresentante()
    {
        return this.rappresentante;
    }

    /**
     * @author Latino Francesco
     * @author Serrone Fabio
     * imposta lo stato di rappresentate a falso
     */
    public void resetRappresentante()
    {
        this.rappresentante = false;
    }

    /**
     * @author Latino Francesco
     * @author Serrone Fabio
     * imposta lo stato di rappresentante
     */
    public void setRappresentante()
    {
        this.rappresentante = true;
    }

    /**
     * @author Latino Francesco
     * @author Serrone Fabio
     * @return media voti
     * ritorna la media dei voti
    */
    public float mediaVoti()
    {
        return pagella.mediaVoti();
    }

    /**
     * Confronta per matricola, cognome, nome
     * @author Latino Francesco
     * @author Serrone Fabio
     * @param altroStudente
     */
    @Override
    public int compareTo(Studente altroStudente) {
        if (this.equals(altroStudente))
            return 0;
        int result = Integer.compare(matricola, altroStudente.matricola);
        if (result != 0)
            return result;
        result = cognome.compareTo(altroStudente.cognome);
        if (result != 0)
            return result;
        return nome.compareTo(altroStudente.nome);
    }

     /**
     * @author Latino Francesco
     * @author Serrone Fabio
     * ritorna una stringa con i parametri di un oggetto studente
     */
    @Override
    public String toString()
    {

        return "Matricola: " + getMatricola() + ", " + getCognome() + ", " + getNome();
    }

    /**
     * @author Latino Francesco
     * @author Serrone Fabio
     * @param altro
     * compara due oggetti studente richiamando il metodo equals della classe base
     */
    @Override
    public boolean equals(Object altro)
    {
        if (altro == this)
            return true;

        if (!(altro instanceof Studente))
            return false;

        Studente altroStudente = (Studente) altro;

        //Confronto per matricola in caso possiediamo il valore, la utilizzo come prima chiave e come seconda chiave il nome e cognome
        if (this.matricola != 0 && altroStudente.matricola != 0)
            return this.matricola == altroStudente.matricola;
        else
            return this.nome.equals(altroStudente.nome) && this.cognome.equals(altroStudente.cognome);
    }

    private static int matricolaAttuale = 0;
    private Genitore[] parentela;
    protected Classe classe;
    private Pagella pagella;
    private int matricola;
    private boolean rappresentante;
}
