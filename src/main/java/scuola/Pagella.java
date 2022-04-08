/**
 * Classe Pagella.java
 * 
 * @author Amato Fernando
 * @version 1.0
 */

package scuola;


public class Pagella 
{
    public Pagella(int numeroMaterie) 
    {
        this.numeroMaterie = numeroMaterie;
        this.numeroVotiInseriti = 0;
    }

    public Pagella(String[] materie) 
    {
        this.materie = materie;
        this.numeroMaterie = materie.length;
        this.numeroVotiInseriti = 0;
    }

    /**
     * @return materie se la posizione è valida se no ritorna null
     * @param pos la posizione
     */
    public String getMaterie(int pos) 
    {
        if (pos >= 0 && pos < numeroMaterie)
            return materie[pos];
        else
            return null;
    }

    public void SetMaterie(String[] materie, int numeroVotiInseriti)
    {
        this.materie = materie;
        this.numeroMaterie = numeroVotiInseriti;
    }

    public void SetVoti(int[] voti, int numeroVotiInseriti)
    {
        this.voti = voti;
        this.numeroVotiInseriti = numeroVotiInseriti;
    }

    public int getNumeroVotiInseriti() 
    {
        return this.numeroVotiInseriti;
    }

    public boolean isCompilata() 
    {
        return this.numeroMaterie > 0 && this.numeroVotiInseriti == this.numeroMaterie;
    }

    public float mediaVoti() 
    {
        int tot = 0;
        float media;
        
        for (int i = 0; i < numeroVotiInseriti; i++) 
        {
            tot += voti[i];
        }

        media = (float) tot / numeroVotiInseriti;
        return media;
    }

    public int numeroDebiti() 
    {
        int debiti = 0;
        
        for (int i = 0; i < this.numeroMaterie; i++) 
        {
            if (this.mediaVoti() < 6) 
            {
                debiti++;
            }
        }

        return debiti;
    }
    
    public int[] getVoti()
    {
        if (!this.isCompilata()) 
        {
            return null;
        } 

        return this.voti;
    }
    
    public void setVoti(int[] voti) 
    {
        this.voti = voti;
    }

    public void setVoto(String materia, int voto) 
    {
        boolean trovata = false;
    
        for (int i = 0; i < this.numeroMaterie && !trovata; i++) 
        {
            if (this.materie[i].equalsIgnoreCase(materia)) 
            {
                this.voti[i] = voto;
                trovata = true;
            }           
        }
    }

    public Studente getStudente() 
    {
        return this.studente;
    }

    /**
     * Restiruisce il voto conseguito in una data materia
     * @param materia
     * @return
     * @throws Exception 
     */
    public int getVoto(String materia) throws Exception 
    {
        for (int i = 0; i < this.numeroMaterie; i++) 
        {
            if (this.materie[i].equalsIgnoreCase(materia)) 
            {
                return this.voti[i];
            }           
        }

        throw new Exception();
    }


    @Override
    public String toString() 
    {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.numeroMaterie; i++) 
        {
            result.append(this.materie[i]).append(": ").append(this.voti[i]).append("\n");
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (!(obj instanceof Pagella))
            return false;

        Pagella other = (Pagella) obj;

        if (numeroMaterie != other.numeroMaterie)
            return false;

        if (numeroVotiInseriti != other.numeroVotiInseriti)
            return false;
        
        boolean result = true;

        for (int i = 0; i < numeroMaterie; i++) 
        {
            if (!materie[i].equals(other.materie[i])) 
            {
                result = false;
                break;
            }
        }
        
        for (int i = 0; i < numeroVotiInseriti; i++) {
            if (voti[i] != other.voti[i]) 
            {
                result = false;
                break;
            }
        }

        return result;
    }

    private static final int MAX_MATERIE = 10;
    private int numeroMaterie;
    private String[] materie;
    private int[] voti;
    private int numeroVotiInseriti;
    protected Studente studente;
}
