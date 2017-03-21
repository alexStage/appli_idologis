/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author dhaen
 */
public class Utilisateur {
    int id;
    String nom;
    String prenom;
    String email;
    String password;
    boolean admin;
    boolean vendeur;

    public Utilisateur(int aInt, String string, String string0) {
        this.setId(aInt);
        this.setNom(string);
        this.setPrenom(string0);
    }
    
    public void Utilisateur(int pId,String pNom, String pPrenom, String pEmail, String pPassword, boolean pAdmin, boolean pVendeur){
        this.setId(pId);
        this.setNom(pNom);
        this.setPrenom(pPrenom);
        this.setEmail(pEmail);
        this.setPassword(pPassword);
        this.setAdmin(pAdmin);
        this.setVendeur(pVendeur);
    }

    public int getId() {
        return id;
    }
     

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }
    

    /**
     * @param id
     */
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * @return the vendeur
     */
    public boolean isVendeur() {
        return vendeur;
    }

    /**
     * @param vendeur the vendeur to set
     */
    public void setVendeur(boolean vendeur) {
        this.vendeur = vendeur;
    }

    @Override
    public String toString() {
        return nom + " " + prenom ;
    }
    
    
}
