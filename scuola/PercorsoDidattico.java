
package scuola;

public class PercorsoDidattico {
    
   final public int MAX_MATERIE=10;
   
   final private int annoCorso;
   final private String indirizzo;
   private String[] materie;
   private int numeroMaterie;
   private int[] monteOre;

   public PercorsoDidattico(int annoCorso, String indirizzo, String[] materie, int numeroMaterie , int[] monteOre){
       this.annoCorso=annoCorso;
       this.indirizzo=indirizzo;
       this.materie=materie;
       this.numeroMaterie=numeroMaterie;
       this.monteOre=monteOre;
 
   }
   
   public PercorsoDidattico(int annoCorso,String indirizzo){
       this.annoCorso=annoCorso;
       this.indirizzo=indirizzo;
   }

   public int getannoCorso(){
       return annoCorso;

   }

   public String[] getMaterie(){
        return materie;

   }

   /**
     * Imposta le materie
     * @param materie vettore di materie
     * @param numeroMaterie numero materie
     */
    public void setMaterie(String[] materie,int numeroMaterie){
        this.materie=materie;
        this.numeroMaterie=numeroMaterie;
    }
 
   public String getIndirizzo(){
       return indirizzo;

   }

   public int getNumeroMaterie(){
       return numeroMaterie;
   }

   public void setNumeroMaterie(int numeroMaterie){
       this.numeroMaterie=numeroMaterie;
   }

   public int[] getMonteOre(){
       return monteOre;
   }
   
   public void setMonteOre(int[] monteOre){
       this.monteOre=monteOre;
   }

   public String getMaterie(int i){
    return materie[i];

   }

   public int getMonteOre(int i){
       return monteOre[i];
   }

   public int getMonteOre(String materia){
       int materia_selezionata;
       for(int i=0; i<materie.length; i++ ){
           
           if(materie[i]==materia){
                materia_selezionata=i;

                return materia_selezionata;
               
       }

   }

   return -1;
    
 
   }

   public void aggiungiMateriaOre(String materia, int Ore){

    int n_elementi=0;
    boolean trovato=false;

    for(int i=0;trovato!=true && i<1000;i++){
        if(this.materie[i]==null){
            n_elementi=i;
            trovato=true;
        }
        this.materie[n_elementi]=materia;
        this.monteOre[n_elementi]=Ore;

    }
}

    public  boolean equals(Object o){

        
     if(o instanceof PercorsoDidattico){
         PercorsoDidattico an= (PercorsoDidattico) o;
         if(an.annoCorso==this.annoCorso){
             return true;
         }
        if(an.indirizzo==this.indirizzo){
            return true;
         }
     }
     return false;

   }

}






   
