/**
 * Classe libreria GestioneFile 
 *
 * Classe di libreria GestioneFile.java
 * Contiene i metodi per "importare" i dati di segreteria
 * 
 * @author nunzio.galati
 * @version 1.0
 */

package scuola;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class GestioneFile 
{
    
    /**
     * Importa l'elenco delle classi da un file di testo e li carica in un array
     * @param nomeFile nome del file di testo contenente le classi
     * @param classi nome dell'array nel quale caricare le classi 
     * @return il numero delle classi lette dal file
     * @throws FileNotFoundException 
     */
    public static int leggiClassi(String nomeFile, Classe[] classi) throws FileNotFoundException, IOException 
    {
        
        BufferedReader br = null;
	    String riga = "";
        
        // Carico le classi dal file
        int i=0;
        
        try {
            br = new BufferedReader(new FileReader(nomeFile)); 
            while ((riga = br.readLine()) != null) {
                String[] campi = riga.split(",");
                // campi[0] => classe
                // campi[1] => sezione
                // campi[2] => indirizzo
                //Video.scriviStringa("" + campi[0] + " " + campi[1]); Video.aCapo();
                Classe nuova = new Classe(Integer.parseInt(campi[0]), campi[1].charAt(0), campi[2]);
                classi[i] = nuova;
                i++;
            }
	} catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException("Errore di accesso al file");
	} finally {
            if (br != null) {
		try {
                    br.close();
		} catch (IOException e) {
                    throw new IOException("Errore durante chiusura del file");	
                }
            } 
        }
        return i;
    }
    /**
     * Importa l'elenco dei docenti da un file di testo e li carica in un array
     * @param nomeFile nome del file di testo contenente i dati dei docenti
     * @param docenti nome dell'array nel quale caricare i dati dei docenti letti dal file
     * @return il numero di docenti letti dal file
     * @throws FileNotFoundException 
     */
    public static int leggiOrganico(String nomeFile, Docente[] docenti) throws FileNotFoundException, IOException {
        
        BufferedReader br = null;
	String riga = "";
        
        // Carico i docenti dal file
        int i=0;
        
        try {
            br = new BufferedReader(new FileReader(nomeFile)); 
            while ((riga = br.readLine()) != null) {
                String[] campi = riga.split(",");
                // campi[0] => codice fiscale
                // campi[1] => cognome
                // campi[2] => nome
                // campi[3] => sesso
                Docente nuovo = new Docente(campi[0], campi[1], campi[2]);
                nuovo.setSesso(campi[3].charAt(0));
                docenti[i] = nuovo;
                i++;
            }
	} catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException("Errore di accesso al file");
	} finally {
            if (br != null) {
		try {
                    br.close();
		} catch (IOException e) {
                    throw new IOException("Errore durante chiusura del file");	
               }
            } 
        }
        return i;
    }  
    /**
     * Importa le cattedre 
     * @param nomeFile nome del file di testo contenente i dati relativi ai docenti, 
     *                 in quali classi insegnano, quale materiee per quante ore.
     * @param docenti  elenco (array) dei docenti esistenti
     * @param cattedre elenco (array) delle cattedre da caricare 
     * @return il numero di insegnamenti (associazione docente-classe) lette dal file
     * @throws FileNotFoundException 
     */
    public static int leggiCattedre(String nomeFile, Docente[] docenti, Insegnamento[] cattedre) throws FileNotFoundException, IOException {
        
        BufferedReader br = null;
	String riga = "";
        
        // Carico i docenti dal file
        int i=0;
        
        try {
            br = new BufferedReader(new FileReader(nomeFile)); 
            while ((riga = br.readLine()) != null) {
                String[] campi = riga.split(",");
                // campi[0] => codice fiscale docente
                // campi[1] => materia
                // campi[2] => classe
                // campi[3] => sezione
                // campi[4] => ore
                //cerca docente che ha la matricola in esame
                Docente d=null;
                boolean trovato = false;
                for(int k=0; k<docenti.length  && !trovato; k++)
                    if(docenti[k].getCodiceFiscale().equalsIgnoreCase(campi[0])) {
                       d = docenti[k];
                       trovato = true;
                    }
                Insegnamento nuovo;
                if (trovato) {
                    Classe c = new Classe(Integer.valueOf(campi[2]),campi[3].charAt(0),null);
                    nuovo = new Insegnamento(d, c, campi[1]);
                    nuovo.setOre(Integer.parseInt(campi[4]));
                    cattedre[i] = nuovo;
                    i++;
                }
            }
	} catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException("Errore di accesso al file");
	} finally {
            if (br != null) {
		try {
                    br.close();
		} catch (IOException e) {
                    throw new IOException("Errore durante chiusura del file");	
                }
            } 
        }
        return i;
    }
    /**
     * Importa le materie in cui ogni docente e' abilitato 
     * @param nomeFile nome del file di testo contenente i dati relativi ai docenti, 
     *                 in quali classi insegnano, quale materiee per quante ore.
     * @param IDdocenti  array che verra' caricato con i cf dei docenti
     * @param materie    array parallelo al precedente che verra' caricato con le materie
     * @return il numero di righe lette dal file
     * @throws FileNotFoundException 
     */
    public static int leggiAbilitazioni(String nomeFile, String[] IDdocenti, String[] materie) throws FileNotFoundException, IOException {
        
        BufferedReader br = null;
	String riga = "";
        
        // Carico i docenti dal file
        int i=0;
        
        try {
            br = new BufferedReader(new FileReader(nomeFile)); 
            while ((riga = br.readLine()) != null) {
                String[] campi = riga.split(",");
                // campi[0] => codice fiscale docente
                // campi[1] => materia
                IDdocenti[i] = campi[0]; 
                materie[i] = campi[1];
                i++;
            }
	} catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException("Errore di accesso al file");
	} finally {
            if (br != null) {
		try {
                    br.close();
		} catch (IOException e) {
                    throw new IOException("Errore durante chiusura del file"); 	
                }
            } 
        }
        return i;
    }
    /**
     * Legge i percorsi didattici da File (supponendo che siano già ordinati in base all'indirizzo)
     * @param nomeFile nome del file
     * @param percorsi vettore di percorsi didattici da impostare
     * @return Ritorna il numero di percorsi letti e associati alle classi
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static int leggiPercorsiDidattici(String nomeFile,PercorsoDidattico[] percorsi) throws FileNotFoundException, IOException{
        BufferedReader br = null;
        String riga;
        int i=0;//indice vettori paralleli
        int k;//contatore materie per percorso
        int j;//indice percorsi
        
        int numRighe = GestioneFile.contaRigheFile(nomeFile);//leggo il file per capire da quante righe è composto
        String[] indirizzi = new String[numRighe];
        String[] materie = new String[numRighe];
        int[] ore= new int[numRighe];

        try{//apertura file
            br=new BufferedReader(new FileReader(nomeFile));

            while((riga=br.readLine())!=null){
                //salva la stringa in vettori paralleli
                for(j=2,k=0;j<riga.split(";").length-1;j+=2,k++){
                    materie[k]=riga.split(";")[j];
                    ore[k]=Integer.parseInt(riga.split(";")[j+1]);
                }
                //Crea il percorso
                percorsi[i]=new PercorsoDidattico(Integer.parseInt(riga.split(";")[0]),riga.split(";")[1],materie.clone(),k,ore.clone());    
                i++;
            } 
        }catch(FileNotFoundException e){
            throw new FileNotFoundException();
        }catch(IOException e){
            throw new IOException();
        }finally{//esegue in ogni caso  
            //chiusura file
            try{
                br.close();
            }catch(IOException e){//eccezione nella chiusura del file
                throw new IOException();
            }
        }
        return i;
    }
    /**
     * Legge il numero di righe contenute in un file
     * @param nomeFile nome del file
     * @return Ritorna il numero di righe che compongono il file
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private static int contaRigheFile(String nomeFile) throws FileNotFoundException, IOException{
        int righe=0;
        String riga="";
        BufferedReader br = null;
        try{//apertura file
            br=new BufferedReader(new FileReader(nomeFile));
            righe=0;
            while((riga=br.readLine())!=null){//conta righe file
                 righe++;   
            }
        }catch(FileNotFoundException e){
            throw new FileNotFoundException();
        }catch(IOException e){
            throw new IOException();
        }finally{//esegue in ogni caso  
            //chiusura file
            try{
                br.close();
            }catch(IOException e){//eccezione nella chiusura del file
                throw new IOException();
            }
        }
        return righe;
    }
    /**
     * Importa l'elenco dei docenti da un file di testo e li carica in un array
     * @param nomeFile nome del file di testo contenente i dati degli alunni iscritti
     * @param classi nome dell'array con le classi formate 
     * @param nclassi numero di classi 
     * @return numero di alunni importati dal file
     * @throws FileNotFoundException, IOException problemi con la lettura del file
     *         IndexOutOfBoundsException problemi di inserimento dell'alunno nella classe specificata
     *         Exception problemi con la data di nasciita dello studente
     */
    public static int importaIscrizioniAlunni(String nomeFile, Classe[] classi, int nclassi) throws FileNotFoundException,IOException,IndexOutOfBoundsException,Exception {
        
        BufferedReader br = null;
	String riga = "";  
        // Carico le iscrizioni effettuate dagli alunni dal file
        int iscrizioni=0;
        try {
            br = new BufferedReader(new FileReader(nomeFile)); 
            while ((riga = br.readLine()) != null) {
                String[] campi = riga.split(",");
                // campi[0] => cf
                // campi[1] => cognome
                // campi[2] => nome
                // campi[3] => sesso
                // data nascita: campi[4] => giorno campi[5] => mese campi[6] => anno
                // campi[7] => classe campi[8] => sezione 
                Studente nuovo = new Studente(campi[0],campi[1],campi[2],campi[3].charAt(0),Integer.valueOf(campi[4]),Integer.valueOf(campi[5]),Integer.valueOf(campi[6]));
                nuovo.setSesso(campi[2].charAt(0));
                Classe classe_scelta = new Classe(Integer.parseInt(campi[7]), campi[8].charAt(0),null);
                for(int i=0; i<nclassi; i++)
                    //trova la classe
                    if(classi[i].equals(classe_scelta))
                        //aggiungilo alla classe
                        try {
                            nuovo.assegnaMatricola();
                            classi[i].aggiungi(nuovo);
                        } catch(IndexOutOfBoundsException e) {
                            throw new IndexOutOfBoundsException();
                        }
                iscrizioni++;
            }
	} catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException("Errore di accesso al file");
	} catch (Exception e) {
            throw new Exception("Errore generico durante importazione alunni (probabile data non valida nel file)");
	}finally {
            if (br != null) {
		try {
                    br.close();
		} catch (IOException e) {
                    throw new IOException("Errore durante chiusura del file"); 	
                }
            } 
        }
        return iscrizioni;
    }
}
