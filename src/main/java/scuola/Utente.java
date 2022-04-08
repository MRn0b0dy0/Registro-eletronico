/**
 * Classe Utente.java
 * @version: 1.0
 * @author Tommaso Lazzari, Christian Landriscina
 */

package scuola;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utente
{
    protected String codiceFiscale;
    protected String cognome;
    protected Calendar data_nascita = new GregorianCalendar();
    protected String nome;
    protected char sesso;
    protected String email;
    protected String password;


    public Utente(String codiceFiscale, String cognome, String nome, char sesso, Calendar data_nascita){
        this.codiceFiscale=codiceFiscale;
        this.cognome=cognome;
        this.nome=nome;
        this.sesso=sesso;
        this.data_nascita=data_nascita;
    }

    public Utente(String codiceFiscale, String cognome, String nome, char sesso, int gg_nascita, int mm_nascita, int aaaa_nascita){
        this.codiceFiscale=codiceFiscale;
        this.cognome=cognome;
        this.nome=nome;
        this.data_nascita.set(aaaa_nascita, mm_nascita, gg_nascita);
    }

    public Utente(String codiceFiscale, String cognome, String nome){
        this.codiceFiscale=codiceFiscale;
        this.cognome=cognome;
        this.nome=nome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public Calendar getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(Calendar data_nascita) {
        this.data_nascita = data_nascita;
    }

    public int getGiornoNascita() {
        return data_nascita.get(Calendar.DAY_OF_MONTH);
    }

    public int getMeseNascita () {
         return data_nascita.get(Calendar.MONTH);
    }


    public int getAnnoNascita () {
        return data_nascita.get(Calendar.YEAR);
    }




    @Override
    public String toString() {
        return "nome=" + nome + ", cognome=" + cognome + ", data_nascita=" + data_nascita + ", sesso=" + sesso + ", codice_fiscale" + codiceFiscale;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Utente other = (Utente) obj;
        if (codiceFiscale == null) {
            if (other.codiceFiscale != null)
                return false;
        } else if (!codiceFiscale.equals(other.codiceFiscale))
            return false;
        if (cognome == null) {
            if (other.cognome != null)
                return false;
        } else if (!cognome.equals(other.cognome))
            return false;
        if (data_nascita == null) {
            if (other.data_nascita != null)
                return false;
        } else if (!data_nascita.equals(other.data_nascita))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (sesso != other.sesso)
            return false;
        return true;
    }


}
