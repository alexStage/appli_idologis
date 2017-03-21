/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import bdd.*;
import classes.Bien;
import classes.Classe;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author denver
 */
public class ServiceClasse {
    Bdd bdd;
    ResultSet rs;
    Statement stat;
    
    public ServiceClasse() throws SQLException {
        bdd = new Bdd(Parametres.LIEN, Parametres.UTILISATEUR, 
             Parametres.PASSWORD);
        
        Connection con = bdd.connexionDatabase();
        stat = con.createStatement();
    }
    
    public ArrayList listeClasse() throws SQLException{
        int idCateg = 0;
        ArrayList<Classe> liste;
        liste = new ArrayList();
        
        rs = stat.executeQuery("SELECT * FROM classes;");
        while (rs.next()){
            liste.add(new Classe(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }
        return liste;
    }
}
