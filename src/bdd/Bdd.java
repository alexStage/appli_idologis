package bdd;

import java.net.Socket;
import java.sql.*;
    
public class Bdd {
    Connection connection;
    Statement statement;
    String SQL;
    
    String url;
    String username;
    String password;
    Socket client;
    String host;
        
    public Bdd(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
     public Connection connexionDatabase(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("erreur lors de la connexion");
            System.err.println(e.getMessage());
        }
        return connection;
    }  
    
    public String update(String sql){
        connexionDatabase();
        try{
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return sql;
    }
    
    public String delete(String nomTable, String id){
        connexionDatabase();
        SQL ="delete from "+nomTable+" where id= "+id+";";

        try{
            statement = connection.createStatement();
            statement.executeUpdate(SQL);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return SQL;
    }
    
    public String insert(String nomTable, String[] nomColonne, Object[] contenuTableau){
        connexionDatabase();
        int i;
        SQL = "INSERT INTO "+ nomTable +"(";

        for(i = 0; i <= nomColonne.length -1; i++){
            SQL += nomColonne[i];
            if(i < nomColonne.length -1){
                SQL += ",";
            }
        }
        
        SQL += ") VALUES(";
        
        for(i = 0; i <= contenuTableau.length -1; i++){
            SQL += "'"+ contenuTableau[i] +"'";
            if(i < contenuTableau.length -1){
                SQL += ",";
            }
        }
        SQL += ")";
        return this.update(SQL);
        
    }
    

        public String updateBien(String nomTable, String[] nomColonne, Object[] contenuTableau, String etat){
        connexionDatabase();
        int i;
        SQL = "UPDATE "+ nomTable +" SET ";
        
        for(i = 0; i <= nomColonne.length -1; i++){
            SQL += nomColonne[i]+ "='" + contenuTableau[i] +"'";
            if(i < nomColonne.length -1){
                SQL += ",";
            }
        }
        
        SQL += " WHERE " + etat;
        return this.update(SQL);
    }
    
    

}
    

