/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import bdd.*;
import classes.Bien;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author dhaene
 */
public class ServiceBien {
    Bdd bdd;
    ResultSet rs;
    Statement stat;
    
    public ServiceBien() throws SQLException {
        bdd = new Bdd(Parametres.LIEN, Parametres.UTILISATEUR, 
             Parametres.PASSWORD);
        
        Connection con = bdd.connexionDatabase();
        stat = con.createStatement();
    }
    
    public ResultSet tousLesBiens() throws SQLException{
        rs = stat.executeQuery("SELECT * FROM biens");
        return rs;
    }
    
    public ArrayList listeCategorie(String pCategorie) throws SQLException{
        int idCateg = 0;
        ArrayList<Bien> liste;
        liste = new ArrayList();
        switch (pCategorie) {
            case "ventes":
                idCateg=1;
                break;
            case "locations":
                idCateg=2;
                break;
        }
        rs = stat.executeQuery("SELECT * FROM biens WHERE categorie_id = "+idCateg+";");
        while (rs.next()){
            liste.add(new Bien(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getInt(12)));
        }
        return liste;
    }
    
    public ResultSet tableauVentes() throws SQLException{
        rs = stat.executeQuery("SELECT secteur, surface, surfaceTerrain,chambres, pieces, types, prix, categorie_id, classe_id FROM biens WHERE categorie_id=1");
        return rs;
    }
    
}
