/**
 *
 * @author ...............
 */

package scuola;


 public class Insegnamento 
{
    /**
     * Costruisce un oggetto insegnamento
     * @param docente docente
     * @param classe in quale classe sta insegnado
     * @param materia quale materia sta insegnando
     */
    public Insegnamento(Docente docente,Classe classe,String materia)
    {
        this.docente=docente;
        this.classe=classe;
        this.materia=materia;
    }

    /**
     * Costruisce un oggetto insegnamento
     * @param docente docente
     * @param classe in quale classe sta insegnando
     * @param materia quale materia sta insegnando
     * @param ore quante ore deve insegnare
     */
    public Insegnamento(Docente docente,Classe classe,String materia,int ore)
    {
        this.docente=docente;
        this.classe=classe;
        this.materia=materia;
        this.ore=ore;
    }
    
    /**
     * Imposta il docente per l'oggetto corrente
     * @param docente docente
     */
    public void setDocente(Docente docente)
    {
        this.docente=docente;
    }

    /**
     * Ritorna il docente dell'oggetto insegnamento corrente
     * @return Ritorna il docente corrente
     */
    public Docente getDocente()
    {
        return this.docente;
    }

    /**
     * Imposta la classe per l'insegnamento corrente
     * @param classe classe
     */
    public void setClasse(Classe classe)
    {
        this.classe=classe;
    }

    /**
     * Ritorna la classe dell'oggetto insegnamento corrente
     * @return Ritorna la classe
     */
    public Classe getClasse()
    {
        return this.classe;
    }

    /**
     * Ritorna la materia che si sta insegnando
     * @return Materia
     */
    public String getMateria()
    {
        return this.materia;
    }

    /**
     * Ritorna le ore dell'oggetto insegnamento attuale
     * @return ore
     */
    public int getOre()
    {
        return this.ore;
    }

    /**
     * Imposta le le ore dell'oggetto insegnamento attuale
     * @param  ore insegnate da quel docente per quella materia in quella classe
     */
    public void setOre(int ore)
    {
        this.ore=ore; 
    }

    /**
     * Descrive l'oggetto insegnamento corrente
     * @return descrizione dell'insegnamento
     */
    @Override
    public String toString()
    {
        return docente.getCognome()+" "+docente.getNome()+" insegna "+this.materia+" in "+this.classe.getClasseSezione();
    }

    /**
     * Confronta due Insegnamenti sulla base dei dati che lo identificano: docente, classe e materia
     * @param o altro insegnamento da confrontare
     * @return true se sono uguali, false altrimenti
     */
    @Override
    public boolean equals(Object o)
    {
        if(o==null || !(o instanceof Insegnamento))
            return false;

        Insegnamento altro = (Insegnamento) o;

        return (this.docente.equals(altro.docente) && this.classe.equals(altro.classe) && this.materia.equalsIgnoreCase(altro.materia));
    }


    private Docente docente;
    private Classe classe;
    private String materia;
    private int ore;
}
