/*
 * Gestione di una segreteria didattica
 * Classe 4A, 2022
 */
package scuola;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import javax.print.attribute.SupportedValuesAttribute;

/**
 * Classe applicazione
 * @author classe 4A
 */
public class Scuola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here       
        final int MAX_CLASSI = 20;
               
        Classe[] classiFormate = new Classe[MAX_CLASSI];  
        PercorsoDidattico[] percorsi = new PercorsoDidattico[MAX_CLASSI];
        
        /**** importa dati segreteria   *****/
        //crea l'elenco delle classi formate 
        int numeroClassi=0;
        try {
            numeroClassi = GestioneFile.leggiClassi("classi.csv", classiFormate);
        } catch (FileNotFoundException e) {
            Video.scriviStringa("File on trovato!"); Video.aCapo();
        } catch (IOException e) {
            Video.scriviStringa("Errore di accesso al file"); Video.aCapo();
        }
        //carica percorsi didattici (indirizzi e relativi PIANI DI STUDIO) 
        int numPercorsi=0;
        try{
            numPercorsi=GestioneFile.leggiPercorsiDidattici("percorsi.csv",percorsi);
        } catch (FileNotFoundException e) {
            Video.scriviStringa("Errore! File non trovato!\n");
        } catch (IOException e){
            Video.scriviStringa("Errore nella lettura del file!\n");
        }
        //imposta percorsi per ogni classe
        boolean trovato;
        for(int i=0; i<numeroClassi; i++){
            trovato=false;
            for(int j=0; j<numPercorsi && !trovato; j++)
                if(classiFormate[i].getPercorso().equals(percorsi[j])) {
                   classiFormate[i].getPercorso().setMaterie(percorsi[j].getMaterie(),percorsi[j].getNumeroMaterie());
                   trovato=true;
                }
        }     
            
        //Visulizza dati anno scolastico corrente importati dalla segreteria 
        /*Video.scriviStringa("Piani di studio dell'offerta formativa: "); Video.aCapo();
        for(int i=0; i<numPercorsi; i++) {
            Video.scriviStringa(percorsi[i].toString()); Video.aCapo();
        }
        Video.aCapo();
        Video.scriviStringa("Classi formate: "); Video.aCapo();
        for(int i=0; i<numeroClassi; i++) { 
            Video.scriviStringa(classiFormate[i].toString()); Video.aCapo();
        }*/
        Video.aCapo();

        //mostra menu  
	char scelta=' ';
		
	do {
            Video.scriviStringa("\n\n        *** GESTIONE SEGRETERIA DIDATTICA ***\n\n");
            Video.scriviStringa("              I - ISCRIVI nuovo studente\n");
            Video.scriviStringa("              C - CAMBIA classe\n");
            Video.scriviStringa("              V - VISUALIZZA classe\n");
            Video.scriviStringa("              R - CERCA studente\n");
            Video.scriviStringa("              F - FORMAZIONE classi\n");
            Video.scriviStringa("              X - FINE\n\n");
			
            Video.scriviStringa("              Scelta => ");
            
            boolean scelta_ok=false;
            do {
                try {
                    scelta = Tastiera.leggiCarattere();
                    scelta_ok = true;
                } catch (IOException e) {
                    Video.scriviStringa("Scelta non valida!!!");
                }
            } while(!scelta_ok);
            
            switch(scelta) {
		case 'i':
		case 'I': //ISCRIVI studente e assegnalo ad una classe
                    {
                        try {
                            Video.scriviStringa("Iserisci anagrafica\n"); 
                            Video.scriviStringa("Cognome? "); 
                            String cognome = Tastiera.leggiStringa();
                            Video.scriviStringa("Nnome? "); 
                            String nome = Tastiera.leggiStringa();
                            Video.scriviStringa("Sesso? "); 
                            char sesso = Tastiera.leggiCarattere();
                            Video.scriviStringa("giorno nascita? "); 
                            int gg = Tastiera.leggiIntero();
                            Video.scriviStringa("mese nascita? "); 
                            int mm = Tastiera.leggiIntero();
                            Video.scriviStringa("anno nascita? "); 
                            int aaaa = Tastiera.leggiIntero();
                            Video.scriviStringa("CF? "); 
                            String cf = Tastiera.leggiStringa();
                            
                            Studente nuovo = new Studente(cf, cognome, nome, sesso, gg, mm, aaaa);
                            
                            Video.scriviStringa("In quale classe?");
                            int cla = Tastiera.leggiIntero();
                            Video.scriviStringa("In quale sezione?");
                            char sez = Tastiera.leggiCarattere();
                            
                            boolean trovata=false;
                            for (int i=0; i<numeroClassi && !trovata; i++) {
                                if (classiFormate[i].equals(cla, sez)) {
                                    trovata=true;    
                                    classiFormate[i].aggiungi(nuovo);
                                }
                            }
                            if (!trovata) {
                                Video.scriviStringa("Classe non formata!");
                            }                           
                        } catch (Exception e) {
                            Video.scriviStringa("Errore di input!");
                        }
                    break;
                    }	
                case 'c': 
                case 'C': //funzionalita' per gestire il trasferimento di un alunno in altra classe 
                    
                    break;

		
                case 'v':
		case 'V': //VISUALIZZA elenco degli studenti di una data classe, con cognome, nome
                    {     
                        try {
                            Video.scriviStringa("Classe?");
                            int cla = Tastiera.leggiIntero();
                            Video.scriviStringa("Sezione?");
                            char sez = Tastiera.leggiCarattere();
                            boolean trovata=false;
                            for (int i=0; i<numeroClassi && !trovata; i++) {
                                if (classiFormate[i].equals(cla, sez)) {
                                    trovata=true;    
                                    Set<Studente> elenco = classiFormate[i].getElenco();
                                    Video.scriviStringa(classiFormate[i].toString());
                                }
                            }
                            if (!trovata) {
                                Video.scriviStringa("Classe non formata!");
                            }      
                        } catch (Exception e) {
                            Video.scriviStringa("Errore di input!");
                        }            
                    break;
                    }
                case 'r':
		case 'R': 
        try {
            Video.scriviStringa("Inserisci matricola dello studente da ricercare: ");
            int matricola = Tastiera.leggiIntero();
            trovato=false;
            for (int i=0; i<numeroClassi && !trovato; i++) 
            {   
                Studente s = classiFormate[i].getStudenteDaMatricola(matricola);    
                if (s != null)
                {
                    Video.scriviStringa(s.toString());
                    trovato=true;
                }
            }
            if(!trovato) {
                Video.scriviStringa("Studente non trovato!");
            }
        }
         catch (Exception e) { 
            Video.scriviStringa("Errore di input!");
        }

                    break;

                case 'f':
		case 'F': //Visualizza la composizione di tutte le classi

                    break;

                 case 'x': 
		case 'X': 
		
                    break;
                    
                default:  Video.scriviStringa("ERRORE I/O: Scelta impropria!");		  
            }
			
	} while(scelta!='X' && scelta!='x');
	 	 
	Video.scriviStringa("\nBuon lavoro  ... "); 
    } 
    
}

