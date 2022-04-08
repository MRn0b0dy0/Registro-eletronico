/*
 * Gestione di una segreteria didattica
 * Classe 4A, 2022
 */
/*
  To Do:
  Sincoronizare pagella e studente
 */

package scuola;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *   Classe applicazione
 *   @author classe 4A
 */
public class Scuola {
  public static final String BASE_DIR = "src/main/resources/";

    private static int studentiIscritti = 0;

    public static int getStudentiIscritti() {
        return studentiIscritti;
    }

    public static void setStudentiIscritti(int studentiIscritti) {
        Scuola.studentiIscritti = studentiIscritti;
    }

    public static int incrementaStudentiIscritti() {
        return ++studentiIscritti;
    }

    public static int decrementaStudentiIscritti() {
        return --studentiIscritti;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        final int MAX_CLASSI = 20;
        Classe[] classiFormate = new Classe[MAX_CLASSI];
        PercorsoDidattico[] percorsi = new PercorsoDidattico[MAX_CLASSI];

        // importa dati segreteria
        //crea l'elenco delle classi formate
        int numeroClassi = 0;

        try
        {
            numeroClassi = GestioneFile.leggiClassi(BASE_DIR + "classi.csv", classiFormate);
        }
        catch (FileNotFoundException e)
        {
            Video.scriviStringa("File on trovato!"); Video.aCapo();
        }
        catch (IOException e)
        {
            Video.scriviStringa("Errore di accesso al file"); Video.aCapo();
        }

        try
        {
            GestioneFile.importaIscrizioniAlunni(BASE_DIR + "alunni.txt", classiFormate, numeroClassi);
        }
        catch (Exception e)
        {
            Video.scriviStringa("Errore di accesso al file\n");
        }



        //carica percorsi didattici (indirizzi e relativi PIANI DI STUDIO)
        int numPercorsi=0;

        try
        {
            numPercorsi = GestioneFile.leggiPercorsiDidattici(BASE_DIR + "percorsi.csv",percorsi);
        }
        catch (FileNotFoundException e)
        {
            Video.scriviStringa("Errore! File non trovato!\n");
        }
        catch (IOException e)
        {
            Video.scriviStringa("Errore nella lettura del file!\n");
        }

        //imposta percorsi per ogni classe
        boolean trovato = false;
        for(int i = 0; i < numeroClassi; i++)
        {
            trovato = false;
            for(int j = 0; j < numPercorsi && !trovato; j++)
            {
                if(classiFormate[i].getPercorso().equals(percorsi[j]))
                {
                   classiFormate[i].getPercorso().setMaterie(percorsi[j].getMaterie(),percorsi[j].getNumeroMaterie());
                   trovato = true;
                }

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
                Video.scriviStringa("              N - Nomina rappresentante di classe\n");
                Video.scriviStringa("              X - FINE\n\n");

                Video.scriviStringa("              Scelta => ");

                boolean scelta_ok = false;

                do
                {
                    try
                    {
                        scelta = Tastiera.leggiCarattere();
                        scelta_ok = true;
                    }
                    catch (IOException e)
                    {
                        Video.scriviStringa("Scelta non valida!!!");
                    }
                } while(!scelta_ok);

                switch(scelta) {
                    case 'i':
                    case 'I': //ISCRIVI studente e assegnalo ad una classe
                                {
                                    try
                                    {
                                        Video.scriviStringa("Iserisci anagrafica\n");
                                        Video.scriviStringa("Cognome? ");
                                        String cognome = Tastiera.leggiStringa();
                                        Video.scriviStringa("Nome? ");
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

                                        for (int i=0; i<numeroClassi && !trovata; i++)
                                        {
                                            if (classiFormate[i].equals(cla, sez))
                                            {
                                                trovata=true;
                                                classiFormate[i].aggiungi(nuovo);
                                            }
                                        }
                                        if (!trovata)
                                        {
                                            Video.scriviStringa("Classe non formata!");
                                        }
                                    }
                                    catch (Exception e)
                                    {
                                        Video.scriviStringa("Errore di input!");
                                    }
                                break;
                                }

                            case 'c':
                            case 'C': //funzionalita' per gestire il trasferimento di un alunno in altra classe
                                {
                                    try
                                    {
                                        Video.scriviStringa("\nInserire la matricola del studente da trasferire:");
                                        int matricola = Tastiera.leggiIntero();
                                        Video.scriviStringa("Inserire la nuova classe:");
                                        int nuovaClasse = Tastiera.leggiIntero();
                                        Video.scriviStringa("Inserire la nuova sezione:");
                                        char nuovaSezione = Tastiera.leggiCarattere();
                                        Studente s = null;
                                        Classe classeVecchia = null;

                                        trovato = false;

                                        for(int i = 0; i < numeroClassi && !trovato; i++)
                                        {
                                            s = classiFormate[i].getStudenteDaMatricola(matricola);
                                            if (s != null)
                                            {
                                                classeVecchia = classiFormate[i];
                                                trovato = true;
                                            }
                                        }

                                        if(trovato)
                                        {
                                            trovato = false;
                                            for(int i = 0; i < numeroClassi && !trovato; i++)
                                            {
                                                if(classiFormate[i].equals(nuovaClasse, nuovaSezione))
                                                {
                                                    classeVecchia.rimuovi(s);
                                                    classiFormate[i].aggiungi(s);
                                                    trovato = true;
                                                }
                                            }

                                            if(trovato)
                                            {
                                                Video.scriviStringa("\t\tInserimento riuscito!\n");
                                            }
                                            else
                                            {
                                                Video.scriviStringa("\t\t\tLa nuova classe non esiste!\n");
                                            }
                                        }
                                        else
                                        {
                                            Video.scriviStringa("\t\t\tLo studente non esiste!\n");
                                        }

                                    }
                                    catch (Exception e)
                                    {
                                        Video.scriviStringa("Errore di input!");
                                    }

                                    break;
                                }

                            case 'v':
                            case 'V': //VISUALIZZA elenco degli studenti di una data classe, con cognome, nome
                                {
                                    try {
                                        Video.scriviStringa("Classe?");
                                        int cla = Tastiera.leggiIntero();
                                        Video.scriviStringa("Sezione?");
                                        char sez = Tastiera.leggiCarattere();

                                        boolean trovata=false;

                                        for (int i=0; i<numeroClassi && !trovata; i++)
                                        {
                                            if (classiFormate[i].equals(cla, sez))
                                            {
                                                trovata = true;
                                                Video.scriviStringa(classiFormate[i].toString());
                                            }
                                        }
                                        if (!trovata)
                                        {
                                            Video.scriviStringa("Classe non formata!");
                                        }
                                    }
                                    catch (Exception e)
                                    {
                                        Video.scriviStringa("Errore di input!");
                                    }
                                    break;
                                }

                            case 'r':
                            case 'R': //Cerca gli studenti in base alla matricola o al nome e cognome
                                {
                                    try
                                    {
                                        Video.scriviStringa("\nCerca studente per matricola o nome e cognome? \n");
                                        Video.scriviStringa("Inserisci M per matricola o N per nome e cognome: ");
                                        char scelta_ricerca = Tastiera.leggiCarattere();

                                        if(scelta_ricerca == 'm' || scelta_ricerca == 'M')
                                        {
                                            Video.scriviStringa("Matricola? ");
                                            int matricola = Tastiera.leggiIntero();

                                            trovato = false;

                                            for(int i = 0; i < numeroClassi && !trovato; i++)
                                            {
                                                Studente s = classiFormate[i].getStudenteDaMatricola(matricola);
                                                if (s != null)
                                                {
                                                    Video.scriviStringa(s.toString());
                                                    trovato=true;
                                                }
                                            }

                                            if(!trovato)
                                            {
                                                Video.scriviStringa("Studente non trovato!");
                                            }
                                        }
                                        else if(scelta_ricerca == 'n' || scelta_ricerca == 'N')
                                        {
                                            Video.scriviStringa("Nome? ");
                                            String nome = Tastiera.leggiStringa();
                                            Video.scriviStringa("Cognome? ");
                                            String cognome = Tastiera.leggiStringa();
                                            int maches = 0;
                                            trovato = false;

                                            for(int i = 0; i < numeroClassi; i++)
                                            {
                                                int pos = classiFormate[i].getPosizione(new Studente(" ", cognome, nome));
                                                if (pos != -1)
                                                {
                                                    maches++;
                                                    Video.scriviStringa(maches + ": " + classiFormate[i].getStudente(pos).toString());
                                                    trovato=true;
                                                }
                                            }

                                            if(!trovato)
                                            {
                                                Video.scriviStringa("Studente non trovato!");
                                            }
                                        }
                                        else
                                        {
                                            Video.scriviStringa("Scelta non valida!");
                                        }
                                    }
                                    catch (Exception e)
                                    {
                                        Video.scriviStringa("Errore di input!");
                                    }

                                    break;
                                }

                            case 'f':
                            case 'F': //Visualizza la composizione di tutte le classi
                                {
                                    for(int i = 0; i < numeroClassi; i++)
                                    {
                                        Video.scriviStringa(classiFormate[i].toString());
                                    }
                                    break;
                                }
                            case 'n':
                            case 'N':
                                {
                                    try
                                    {

                                        Video.scriviStringa("\nInserisci la classe degli studenti da rendere rappresentati: \n");
                                        Video.scriviStringa("Classe?");
                                        int cla = Tastiera.leggiIntero();
                                        Video.scriviStringa("Sezione?");
                                        char sez = Tastiera.leggiCarattere();
                                        int i = 0;
                                        boolean trovata = false;
                                        for (; i<numeroClassi && !trovata; i++)
                                        {
                                            if (classiFormate[i].equals(cla, sez))
                                            {
                                                trovata = true;
                                                Video.scriviStringa(classiFormate[i].toString());
                                            }
                                        }
                                        i--;
                                        if (!trovata)
                                        {
                                            Video.scriviStringa("Classe non formata!");
                                            break;
                                        }

                                        Video.scriviStringa("Inserire le matricole dei due studenti da rendere rappresentanti: ");
                                        Video.scriviStringa("\nMatricola primo studente? ");
                                        int matricola1 = Tastiera.leggiIntero();
                                        Video.scriviStringa("Matricola secondo studente? ");
                                        int matricola2 = Tastiera.leggiIntero();

                                        if(classiFormate[i].getStudenteDaMatricola(matricola1) == null || classiFormate[i].getStudenteDaMatricola(matricola2) == null)
                                        {
                                            Video.scriviStringa("Uno degli studenti non esiste!");
                                            break;
                                        }

                                        for (var student : classiFormate[i].getElenco())
                                        {
                                            if (student.isRappresentante())
                                                student.resetRappresentante();
                                        }

                                        classiFormate[i].getStudenteDaMatricola(matricola1).setRappresentante();
                                        classiFormate[i].getStudenteDaMatricola(matricola2).setRappresentante();
                                        Video.scriviStringa("\nRappresentanti modificati!");
                                        /*
                                        Video.scriviStringa("\nInserire matricola dello studente da promuovere a rappresentante di classe:");
                                        int matricola = Tastiera.leggiIntero();
                                        trovato = false;

                                        for(int i = 0; i < numeroClassi && !trovato; i++)
                                        {
                                            Studente s = classiFormate[i].getStudenteDaMatricola(matricola);
                                            if (s != null)
                                            {
                                                for (var student : classiFormate[i].getElenco())
                                                {
                                                    if (student.isRappresentante())
                                                        student.resetRappresentante();
                                                }

                                                s.setRappresentante();
                                                System.out.println(s + " promosso a rappresentante di classe!\n");
                                                trovato = true;
                                            }
                                        }

                                        if(!trovato)
                                        {
                                            Video.scriviStringa("Studente non trovato!");
                                        }*/
                                    }
                                    catch (Exception e)
                                    {
                                        Video.scriviStringa("Errore di input!");
                                    }
                                    break;
                                }
                            case 'x':
                            case 'X':
                                {
                                    break;
                                }

                            default:  Video.scriviStringa("ERRORE I/O: Scelta impropria!");
                        }

        } while(scelta != 'X' && scelta != 'x');

	    Video.scriviStringa("\nBuon lavoro  ... ");
    }
}
