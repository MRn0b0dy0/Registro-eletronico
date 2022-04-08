package scuola;

/**
 *
 * @author ...
 */
public class LivelloContrattuale {
    
    //per figli a carico da decurtare dalle tasse (indipendentemente dalla mansione)
    
    public LivelloContrattuale(inquadramento livello) throws Exception 
    {
        if (livello != inquadramento.DOCENTE_SUPPLENTE && livello != inquadramento.DOCENTE_RUOLO && livello != inquadramento.DIRIGENTE) 
        {
            throw new Exception("Livello non previsto dall'attuale normativa del lavoro!");
        }

        this.livello=livello;
    }
    
    public static float getCompetenzeFisse() 
    {
            return LivelloContrattuale.competenze_fisse;
    }
       
    public float getCompetenzeAccessorie() 
    {
        this.competenze_accessorie=0;
        // FIXME: Duplicate condition: livello==inquadramento.DOCENTE_RUOLO
        if (this.livello==inquadramento.DOCENTE_RUOLO) 
            return (this.competenze_accessorie + 300); //euro in più
        else if (livello==inquadramento.DOCENTE_RUOLO)
            return (this.competenze_accessorie + 700); //euro in più
        return this.competenze_accessorie;
    }
    
    public static float getDetrazioniPerFiglioCarico() 
    {
        return LivelloContrattuale.detrazioni_figli_carico;
    }
 
    public float getTasse() 
    { 
        LivelloContrattuale.tasse=0;
        if (this.livello==inquadramento.DOCENTE_SUPPLENTE || this.livello==inquadramento.DOCENTE_RUOLO) 
            LivelloContrattuale.tasse = 20; //%
        else 
            LivelloContrattuale.tasse = 40; //%
        return LivelloContrattuale.tasse;
    }
    
    public float getDetrazioni(int numeroFigliACarico) 
    { //fino a 3 figli
        if (numeroFigliACarico > 3)
            numeroFigliACarico = 3;
        this.detrazioni_fiscali=numeroFigliACarico*100; //euro
        return this.detrazioni_fiscali;
    }

    public enum inquadramento {DOCENTE_SUPPLENTE, DOCENTE_RUOLO, DIRIGENTE}

    private inquadramento livello;  
    private static final float competenze_fisse = 1500; //mensili; compenso di funzione = per tutti i docenti
    private float competenze_accessorie;                //mensili
    private static final float detrazioni_figli_carico = 50; //mensili per ogni figlio
    private static float tasse;                         //in percentuale sullo stipendio lordo
    private float detrazioni_fiscali;   
}
