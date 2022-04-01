/**
 * Classe Pagella.java
 * 
 * @author Amato Fernando
 * @version 1.0
 */
package scuola;

public class Pagella {

    private static final int MAX_MATERIE = 10;
    
    private int numeroMaterie;
    private String[] materie;
    private int[] voti;
    private int numeroVotiInseriti;
    private Studente studente;

    public Pagella(int numeroMaterie) {
        this.numeroMaterie = numeroMaterie;
    }

    public Pagella(String[] materie) {
        this.materie = materie;
        this.numeroMaterie=materie.length;
    }

    public String GetMaterie(int pos) {
        for (int i = 0; i < this.numeroMaterie; i++) {
            if (this.materie[i].equals(pos)) {
                return this.materie[i];
            }
        }
        return null;
    }

    public void SetMaterie(String[] materie) {
        this.materie = materie;
    }

    public void SetVoti(int[] voti, int numeroVotiInseriti) {
        this.voti[0] = this.voti[numeroVotiInseriti];
    }

    public int GetNumeroVotiInseriti() {
        return this.numeroVotiInseriti;
    }

    public boolean isCompilata() {
        return this.numeroMaterie>0 && this.numeroVotiInseriti==this.numeroMaterie;
    }

    public float mediaVoti() {
        int tot = 0;
        float media;
        for (int i = 0; i < this.numeroVotiInseriti; i++) {
            tot = tot + this.voti[i];
        }
        media = tot / this.numeroVotiInseriti;
        return media;
    }

    public int numeroDebiti() {
        int debiti = 0;
        for (int i = 0; i < this.numeroMaterie; i++) {
            if (this.mediaVoti() < 6) {
                debiti++;
            }
        }
        return debiti;
    }
    /**
     * Restiruisce il voto conseguito in una data materia
     * @param materia
     * @return
     * @throws Exception 
     */
    public int getVoto(String materia) throws Exception {
        for (int i = 0; i < this.numeroMaterie; i++) {
            if (this.materie[i].equalsIgnoreCase(materia)) {
                return this.voti[i];
            }           
        }
        //gestione eccezione personalizzata
        throw new Exception();
    }
    
    public int[] getVoti() {
        if (!this.isCompilata()) {
            return null;
        } 
        return this.voti;
    }
    
    public void setVoti(int[] voti) {
        this.voti = voti;
    }

    public void setVoto(String materia, int voto) {
        boolean trovata=false;
        for (int i = 0; i < this.numeroMaterie && !trovata; i++) {
            if (this.materie[i].equalsIgnoreCase(materia)) {
                this.voti[i]=voto;
                trovata=true;
            }           
        }
    }
    //!!!toString
    //!!!equals
}
