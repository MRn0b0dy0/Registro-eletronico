/**
 * Classe PercorsoDidattico.java
 * @version: 1.0 
 * @author Lorenzo Musardo, Giuseppe Angelini, Gabriele De Santis 
 */

package scuola;

public class Account{

    private String password;
    private String email;

    public Account(String email){
        this.email=email;

    }

    public Account(String email, String password){
        this.email=email;
        this.password=password;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String newpassword){
        this.password=newpassword;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String newemail){
        this.email=newemail;
    }

    public void associa(Utente altro){
        altro.password=this.password;
        altro.email=this.email;
    }
   

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "email=" + email + ", password=" + password;
    }

    

    


}