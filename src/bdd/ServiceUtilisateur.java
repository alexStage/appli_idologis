/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import classes.Utilisateur;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author dhaene
 */
public class ServiceUtilisateur {
    
    Connection con;
    ResultSet rs;
    Bdd bdd;
    Statement stat;
            
    public ServiceUtilisateur() throws SQLException {
        bdd = new Bdd(Parametres.LIEN, Parametres.UTILISATEUR, 
             Parametres.PASSWORD);
        
        con = bdd.connexionDatabase();
        stat = con.createStatement();
    }
    
    public ArrayList listeUtilisateur() throws SQLException{
        int idCateg = 0;
        ArrayList<Utilisateur> liste;
        liste = new ArrayList();
        
        rs = stat.executeQuery("SELECT id, name, prenom FROM users;");
        while (rs.next()){
            liste.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }
        return liste;
    }
    
    public boolean utilisateurExiste(String pPassword, String pIdentifiant) throws SQLException, NoSuchAlgorithmException{
        boolean existe = false;
        Statement stat =con.createStatement();
        rs = stat.executeQuery("select email, passwordmd5 from users;");
        
          byte[] uniqueKey = pPassword.getBytes();
	  byte[] hash = null;
	  try {
		hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
	  } catch (NoSuchAlgorithmException e) {
		throw new Error("no MD5 support in this VM");
	  }
	  StringBuffer hashString = new StringBuffer();
	  for ( int i = 0; i < hash.length; ++i ) {
		String hex = Integer.toHexString(hash[i]);
		if ( hex.length() == 1 ) {
		  hashString.append('0');
		  hashString.append(hex.charAt(hex.length()-1));
		} else {
		  hashString.append(hex.substring(hex.length()-2));
		}
	  }
          String password = hashString.toString();
        
        while(rs.next()){
            if(password.equals(rs.getString(2)) && pIdentifiant.equals(rs.getString(1))){
                existe = true;
            }
        }
        
        return existe;
    }
}
