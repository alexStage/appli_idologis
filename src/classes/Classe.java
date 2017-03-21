/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author denver
 */
public class Classe {
    
    int id;
    String lettre;
    String description;

    public Classe(int id, String lettre, String description) {
        this.id = id;
        this.lettre = lettre;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getLettre() {
        return lettre;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLettre(String lettre) {
        this.lettre = lettre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "classe:"+ lettre ;
    }

    
    
    
}
