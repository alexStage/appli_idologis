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
public class Bien {
    private final int id;
    private String photo;
    private String secteur;
    private String surface;
    private String surfaceTerrain;
    private int chambres;
    private int pieces;
    private String types;
    private int prix;
    private int user_id;
    private int categorie_id;
    private int classe_id;


    public Bien(int pId,String pPhoto, String pSecteur, String pSurface, String pSurfaceTerrain, int pChambres, int pPieces, String pTypes, int pPrix, int pUser_id, int pCategorie_id,int pClasse_id){
        this.id = pId;
        this.categorie_id = pCategorie_id;
        this.chambres = pChambres;
        this.classe_id = pClasse_id;
        this.photo = pPhoto;
        this.pieces = pPieces;
        this.prix = pPrix;
        this.secteur = pSecteur;
        this.surface = pSurface;
        this.surfaceTerrain = pSurfaceTerrain;
        this.types = pTypes;
        this.user_id = pUser_id;
    }
    
    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return the secteur
     */
    public String getSecteur() {
        return secteur;
    }

    /**
     * @param secteur the secteur to set
     */
    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    /**
     * @return the surface
     */
    public String getSurface() {
        return surface;
    }

    /**
     * @param surface the surface to set
     */
    public void setSurface(String surface) {
        this.surface = surface;
    }

    /**
     * @return the surfaceTerrain
     */
    public String getSurfaceTerrain() {
        return surfaceTerrain;
    }

    /**
     * @param surfaceTerrain the surfaceTerrain to set
     */
    public void setSurfaceTerrain(String surfaceTerrain) {
        this.surfaceTerrain = surfaceTerrain;
    }

    /**
     * @return the chambres
     */
    public int getChambres() {
        return chambres;
    }

    /**
     * @param chambres the chambres to set
     */
    public void setChambres(int chambres) {
        this.chambres = chambres;
    }

    /**
     * @return the pieces
     */
    public int getPieces() {
        return pieces;
    }

    /**
     * @param pieces the pieces to set
     */
    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    /**
     * @return the types
     */
    public String getTypes() {
        return types;
    }

    /**
     * @param types the types to set
     */
    public void setTypes(String types) {
        this.types = types;
    }

    /**
     * @return the prix
     */
    public int getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(int prix) {
        this.prix = prix;
    }

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the categorie_id
     */
    public int getCategorie_id() {
        return categorie_id;
    }

    /**
     * @param categorie_id the categorie_id to set
     */
    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    /**
     * @return the classe_id
     */
    public int getClasse_id() {
        return classe_id;
    }

    /**
     * @param classe_id the classe_id to set
     */
    public void setClasse_id(int classe_id) {
        this.classe_id = classe_id;
    }
    
    
}
