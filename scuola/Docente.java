/**
 * Docente
 * di Emanuele Serafini e Donato Ciardo 4°A
 */

package scuola;
import java.util.GregorianCalendar;


public class Docente extends Dipendente /*INIZIALIZZARE L'OGGETTO livello_retributivo*/
{
    /**
     * Metodo costruttore
     * @param cf
     * @param cognome
     * @param nome
     * @param sesso
     * @param data_nascita
     * @param ruolo
     */
    public Docente (String cf, String cognome, String nome, char sesso, GregorianCalendar data_nascita, tipoRuolo ruolo) 
    {
        super(cf, cognome, nome, sesso, data_nascita);
        this.ruolo=ruolo;
    }

    /**
     * Metodo Costruttore
     * @param cf
     * @param cognome
     * @param nome
     * @param sesso
     * @param giorno_nascita
     * @param mese_nascita
     * @param anno_nascita
     * @param ruolo
     */
    public Docente (String cf, String cognome, String nome, char sesso, int giorno_nascita, int mese_nascita, int anno_nascita, tipoRuolo ruolo) 
    {
        super(cf, cognome, nome, sesso, giorno_nascita, mese_nascita, anno_nascita);
        this.ruolo=ruolo;
    }

    /**
     * Metodo Costruttore
     * @param cf
     * @param cognome
     * @param nome
     */
    public Docente (String cf, String cognome, String nome) 
    {
        super(cf, cognome, nome);
    }

    /**
     * Metodo Get per il numero delle materie insegnate
     * @return numero materie insegnate
     */
    public int getNumMaterieInsegnate() 
    {
        return this.numMaterieInsegnate;
    }

    /**
     * Metodo Set per il numero delle materie insegnate 
     * @param numMaterieInsegnate Quante materie insegnate
     */

    public void setNumMaterieInsegnate(int numMaterieInsegnate) 
    {
        this.numMaterieInsegnate = numMaterieInsegnate;
    }

    /**
     * Metodo Get per le materie insegnate
     * @return Array di string delle materie insegnate
     */
    public String[] getMaterie() 
    {
        return this.materie;
    }

    /**
     * Metodo Set per le materie insegnate
     * @param materie Array di String con le materie che il docente insegna
     */
    public void setMaterie(String[] materie) 
    {
        this.materie = materie;
    }

    /**
     * Metodo Get per ruolo docente
     * @return Ruolo del docente
     */
    public tipoRuolo getRuolo() 
    {
        return this.ruolo;
    }

    /**
     * Metodo Set per ruolo docente
     * @param ruolo Ruolo del docente
     */
    public void setRuolo(tipoRuolo ruolo) 
    {
        this.ruolo = ruolo;
    }

    /**
     * Aggiungere abilitazione di una materia
     * @param material Nome materia da aggiungere
     */
    public void aggiungiAbilitazione(String material) 
    {
        if (numMaterieInsegnate < MAX_MATERIE) 
        {
            this.materie[numMaterieInsegnate] = material;
            numMaterieInsegnate++; 
        }
    }

    /**
     * Rimuovere abilitazione di una materia
     * @param material Nome materia da rimuovere
     * @return vero se rimossa
     */
    public boolean rimuoviAbilitazione(String material) 
    {
        int posizione = 0;
        boolean trovata = false;
        
        for (int i = 0; i<numMaterieInsegnate && posizione == 0 && !trovata; i++) 
        {
            if (this.materie[i].equals(material)) 
            {
                posizione = i + 1;
                trovata = true;
            }
        }

        if (trovata == true) 
        {
            for (int i = posizione -1 ; i < this.numMaterieInsegnate - 1; i++) 
            {
                this.materie[i]=this.materie[i+1];
            }
            numMaterieInsegnate--;
        }

        return trovata;
    }

    /**
     * Metodo get per il livello retributivo
     * @return Livello retributivo
     */
    public LivelloContrattuale getLivello_retributivo() 
    {
        return this.livello_retributivo;
    }

    /**
     * Metodo set per il livello retributivo
     * @param livello_retributivo Livello retributivo
     */
    public void setLivello_retributivo(LivelloContrattuale livello_retributivo) 
    {
        this.livello_retributivo = livello_retributivo;
    }

    /**
     * Metodo get per il numero di figli
     * @return Numero di figli
     */
    public int getNumero_figli() 
    {
        return this.numero_figli;
    }

    /**
     * Metodo set per il numero di figli
     * @param numero_figli Numero di figli
     */
    public void setNumero_figli(int numero_figli) 
    {
        this.numero_figli = numero_figli;
    }

    public void setLivelloRetributivo(LivelloContrattuale.inquadramento livello, int nFilgi) throws Exception
    {
        try 
        {
            this.livello_retributivo = new LivelloContrattuale(livello);
            this.numero_figli = nFilgi;
        }
        catch (Exception e) 
        {
            System.out.println("Non valido");
        }
    }


    @Override
    protected void calcolaStipendio() 
    {
        float totale = LivelloContrattuale.getCompetenzeFisse() + livello_retributivo.getCompetenzeAccessorie();
        float tasse = this.livello_retributivo.getTasse() * totale / 100;
        tasse -= this.livello_retributivo.getDetrazioni(this.numero_figli);
        this.stipendio = totale - tasse;
    }
    
    @Override
    public float getStipendio() 
    {
        return this.stipendio;
    }

    /**
     * Metodo toString per stampare i dati e le caratteristiche del docente
     * @return Stringa con tutti i dati
     */
    @Override
    public String toString() 
    {
        String stampa = super.toString() + " " + this.ruolo + " " + this.numMaterieInsegnate + " ";
        for (int i=0; i < numMaterieInsegnate; i++) 
        {
            stampa += materie[i] + "," + " ";
        }
        return stampa;
    }

    /**
     * Metodo equals per confrontare docenti
     * @return ritorna vero se l'uguaglianza è vera
     */
    @Override
    public boolean equals (Object altro) 
    {
        return super.equals(altro);
    }    

    final static int MAX_MATERIE=10;
    public enum tipoRuolo {TEORIA, LABORATORIO}
    
    private tipoRuolo ruolo;
    private int numMaterieInsegnate;
    private String materie[] = new String[MAX_MATERIE];
    private LivelloContrattuale livello_retributivo;
    private int numero_figli;
}
