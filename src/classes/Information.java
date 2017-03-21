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
public class Information {
    
    private String adresse;
    private String tel;
    private String fax;
    private String denomination;
    private String cedex;
    private String email;
    private String RCS;

    public Information(String pAdresse, String pTel, String pFax, String pDenomination, String pCedex, String pEmail, String pRCS){
        this.adresse = pAdresse;
        this.tel = pTel;
        this.fax = pFax;
        this.denomination = pDenomination;
        this.cedex = pCedex;
        this.email =pEmail;
        this.RCS = pRCS;
    }
    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the denomination
     */
    public String getDenomination() {
        return denomination;
    }

    /**
     * @param denomination the denomination to set
     */
    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    /**
     * @return the cedex
     */
    public String getCedex() {
        return cedex;
    }

    /**
     * @param cedex the cedex to set
     */
    public void setCedex(String cedex) {
        this.cedex = cedex;
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
     * @return the RCS
     */
    public String getRCS() {
        return RCS;
    }

    /**
     * @param RCS the RCS to set
     */
    public void setRCS(String RCS) {
        this.RCS = RCS;
    }
    
    
}
