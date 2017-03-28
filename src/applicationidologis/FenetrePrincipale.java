/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationidologis;

import bdd.*;
import classes.Classe;
import classes.Utilisateur;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dhaene
 */
public class FenetrePrincipale extends javax.swing.JFrame {
    
    Bdd bdd = new Bdd(Parametres.LIEN, Parametres.UTILISATEUR, 
             Parametres.PASSWORD);
    Connection con = bdd.connexionDatabase();
    Statement stm;
    ResultSet rs;
    
    /**
     * Creates new form FenetrePrincipale
     * @throws java.sql.SQLException
     */
    public FenetrePrincipale() throws SQLException {
        initComponents();

        tblVentes.setModel(afficher("ventes"));
        tblLocations.setModel(afficher("locations"));
        table_vendeur.setModel(afficher("vendeur"));
        comboClasse();
        comboVendeur();
        
    }
    
    public void comboClasse() throws SQLException{
        ServiceClasse service = new ServiceClasse();
        ArrayList<Classe> liste = service.listeClasse();
        for(int i=0;i<liste.size();i++){
            cmb_classe.addItem(liste.get(i));
            v_cmb_classe.addItem(liste.get(i));
        }
    }
    
    public void comboVendeur() throws SQLException{
        ServiceUtilisateur service = new ServiceUtilisateur();
        ArrayList<Utilisateur> liste = service.listeUtilisateur();
        for(int i=0;i<liste.size();i++){
            cmb_utilisateur.addItem(liste.get(i));
            v_cmb_vendeur.addItem(liste.get(i));
        }
    }
    
    private DefaultTableModel afficher(String pCategorie){
        DefaultTableModel model=new DefaultTableModel();
        
        try{

            model.setRowCount(0);
            stm=con.createStatement();
            switch (pCategorie) {
                case "ventes":
                    model.addColumn("id");
                    model.addColumn("secteur");
                    model.addColumn("type");
                    model.addColumn("surface");
                    model.addColumn("surfaceTerrain");
                    model.addColumn("chambres");
                    model.addColumn("pieces");
                    model.addColumn("prix");
                    rs=stm.executeQuery("Select * from biens where categorie_id = 1");
                    while(rs.next()){
                        model.addRow(new Object[]{rs.getString("id"),rs.getString("secteur"),rs.getString("types"),
                        rs.getString("surface"),rs.getString("surfaceTerrain"),rs.getString("chambres"),rs.getString("pieces"),rs.getString("prix")});
                    }
                    break;
                case "locations":
                    model.addColumn("id");
                    model.addColumn("secteur");
                    model.addColumn("type");
                    model.addColumn("surface");
                    model.addColumn("surfaceTerrain");
                    model.addColumn("chambres");
                    model.addColumn("pieces");
                    model.addColumn("prix");
                    rs=stm.executeQuery("Select * from biens where categorie_id = 2");
                    while(rs.next()){
                        model.addRow(new Object[]{rs.getString("id"),rs.getString("secteur"),rs.getString("types"),
                        rs.getString("surface"),rs.getString("surfaceTerrain"),rs.getString("chambres"),rs.getString("pieces"),rs.getString("prix")});
                    }
                    break;
                case "vendeur":
                    model.addColumn("id");
                    model.addColumn("nom");
                    model.addColumn("prenom");
                    model.addColumn("email");
                    rs=stm.executeQuery("Select id, name, prenom, email from users");
                    while(rs.next()){
                        model.addRow(new Object[]{rs.getString("id"),rs.getString("name"),rs.getString("prenom"),
                        rs.getString("email")});
                    }
                    break;
                case "biens":
                    String id = String.valueOf(table_vendeur.getValueAt(table_vendeur.getSelectedRow(), 0));
                    model.addColumn("id");
                    model.addColumn("secteur");
                    model.addColumn("type");
                    model.addColumn("surface");
                    model.addColumn("surfaceTerrain");
                    model.addColumn("chambres");
                    model.addColumn("pieces");
                    model.addColumn("prix");
                    rs=stm.executeQuery("Select * from biens where categorie_id = "+id);
                    while(rs.next()){
                        model.addRow(new Object[]{rs.getString("id"),rs.getString("secteur"),rs.getString("types"),
                        rs.getString("surface"),rs.getString("surfaceTerrain"),rs.getString("chambres"),rs.getString("pieces"),rs.getString("prix")});
                    }
                    break;
            }
            

        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return model;
    }
    
    public void remplitChampsVentes() throws SQLException{
        
        rs = stm.executeQuery("select * from biens where id ="+String.valueOf(tblVentes.getValueAt(tblVentes.getSelectedRow(), 0))+";");
        rs.next();
        
        v_photo.setText(rs.getString(2));
        v_secteur.setText(rs.getString(3));
        v_type.setText(rs.getString(8));
        v_surface.setText(rs.getString(4));
        v_surfTerrain.setText(rs.getString(5));
        v_chambres.setValue(rs.getInt(6));
        v_pieces.setValue(rs.getInt(7));
        v_prix.setText(rs.getString(9));


    }
    
    public void remplitChampsLocations() throws SQLException{
        
        rs = stm.executeQuery("select * from biens where id ="+String.valueOf(tblLocations.getValueAt(tblLocations.getSelectedRow(), 0))+";");
        rs.next();
        
        l_photo.setText(rs.getString(2));
        l_secteur.setText(rs.getString(3));
        l_type.setText(rs.getString(8));
        l_surface.setText(rs.getString(4));
        l_surfTerrain.setText(rs.getString(5));
        l_chambres.setValue(rs.getInt(6));
        l_pieces.setValue(rs.getInt(7));
        l_prix.setText(rs.getString(9));
        cmb_classe.setSelectedItem(rs.getInt(11));
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        l_secteur = new javax.swing.JTextField();
        l_surface = new javax.swing.JTextField();
        l_surfTerrain = new javax.swing.JTextField();
        l_prix = new javax.swing.JTextField();
        l_btn_ajout = new javax.swing.JButton();
        l_btn_suppr = new javax.swing.JButton();
        l_btn_modif = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLocations = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        l_type = new javax.swing.JTextField();
        l_chambres = new javax.swing.JSpinner();
        l_pieces = new javax.swing.JSpinner();
        cmb_classe = new javax.swing.JComboBox<>();
        cmb_utilisateur = new javax.swing.JComboBox<>();
        l_fileChooser = new javax.swing.JFileChooser();
        l_photo = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_vendeur = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_biens = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVentes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        v_secteur = new javax.swing.JTextField();
        v_surface = new javax.swing.JTextField();
        v_surfTerrain = new javax.swing.JTextField();
        v_prix = new javax.swing.JTextField();
        v_btn_ajout = new javax.swing.JButton();
        v_btn_suppr = new javax.swing.JButton();
        v_btn_modif = new javax.swing.JButton();
        v_type = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        v_pieces = new javax.swing.JSpinner();
        v_chambres = new javax.swing.JSpinner();
        v_cmb_vendeur = new javax.swing.JComboBox();
        v_cmb_classe = new javax.swing.JComboBox();
        file_chooser = new javax.swing.JFileChooser();
        jLabel24 = new javax.swing.JLabel();
        v_photo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel12.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel12.setText("gestion des locations");

        jLabel13.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel13.setText("secteur:");

        jLabel14.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel14.setText("surface:");

        jLabel15.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel15.setText("surface terrain:");

        jLabel16.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel16.setText("nombre de chambre:");

        jLabel17.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel17.setText("nombre de pièces:");

        jLabel18.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel18.setText("prix:");

        jLabel19.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel19.setText("vendeur à charge:");

        jLabel20.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel20.setText("classe:");

        l_btn_ajout.setText("ajouter");
        l_btn_ajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_btn_ajoutActionPerformed(evt);
            }
        });

        l_btn_suppr.setText("supprimer");
        l_btn_suppr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_btn_supprActionPerformed(evt);
            }
        });

        l_btn_modif.setText("modifier");
        l_btn_modif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_btn_modifActionPerformed(evt);
            }
        });

        tblLocations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLocations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLocationsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLocations);

        jLabel23.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel23.setText("type:");

        l_fileChooser.setCurrentDirectory(new java.io.File("/home/denver/Images"));
        l_fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_fileChooserActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel25.setText("photo:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(jLabel12)
                .addContainerGap(767, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel25))
                                .addGap(62, 62, 62)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(l_photo)
                                    .addComponent(l_prix, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(l_pieces)
                                    .addComponent(cmb_classe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmb_utilisateur, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16))
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(l_surfTerrain, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                            .addComponent(l_surface, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                            .addComponent(l_chambres)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addGap(154, 154, 154))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(133, 133, 133)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(l_secteur)
                                            .addComponent(l_type, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(l_btn_ajout, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(l_btn_modif, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(l_btn_suppr, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(l_fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_btn_suppr)
                            .addComponent(l_btn_modif)
                            .addComponent(l_btn_ajout))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(l_secteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(l_photo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(l_pieces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(l_prix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(cmb_utilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(cmb_classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(l_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel14)
                                            .addComponent(l_surface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15))
                                    .addComponent(l_surfTerrain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(l_chambres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(l_fileChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("locations", jPanel2);

        table_vendeur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_vendeur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_vendeurMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_vendeur);

        table_biens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(table_biens);

        jLabel2.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel2.setText("liste des vendeurs");

        jLabel11.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel11.setText("biens à charge:");

        jLabel21.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel21.setText("attribuer des biens à des vendeurs");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel21))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("vendeurs", jPanel4);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel1.setText("gestion des ventes");

        tblVentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVentesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblVentes);

        jLabel3.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel3.setText("secteur:");

        jLabel4.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel4.setText("type:");

        jLabel5.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel5.setText("surface terrain:");

        jLabel6.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel6.setText("nombre de chambre:");

        jLabel7.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel7.setText("nombre de pièces:");

        jLabel8.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel8.setText("prix:");

        jLabel9.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel9.setText("vendeur à charge:");

        jLabel10.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel10.setText("classe:");

        v_btn_ajout.setText("ajouter");
        v_btn_ajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v_btn_ajoutActionPerformed(evt);
            }
        });

        v_btn_suppr.setText("supprimer");
        v_btn_suppr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v_btn_supprActionPerformed(evt);
            }
        });

        v_btn_modif.setText("modifier");
        v_btn_modif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v_btn_modifActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel22.setText("surface:");

        file_chooser.setCurrentDirectory(new java.io.File("/home/denver/Images"));
        file_chooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_chooserActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel24.setText("photo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(153, 153, 153)
                            .addComponent(jLabel1)
                            .addGap(485, 485, 485)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(v_btn_ajout, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(v_btn_modif, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(v_btn_suppr, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel24))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(v_prix)
                            .addComponent(v_pieces, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(v_cmb_vendeur, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(v_cmb_classe, 0, 175, Short.MAX_VALUE)
                            .addComponent(v_photo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel22))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(v_surfTerrain)
                            .addComponent(v_surface)
                            .addComponent(v_secteur)
                            .addComponent(v_type)
                            .addComponent(v_chambres, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addComponent(file_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(v_btn_suppr)
                                    .addComponent(v_btn_modif)
                                    .addComponent(v_btn_ajout))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(v_secteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(v_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(v_surface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5))
                                    .addComponent(v_surfTerrain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(v_chambres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(v_photo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(v_pieces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(v_prix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(v_cmb_vendeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(v_cmb_classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(file_chooser, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );

        jTabbedPane1.addTab("ventes", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblVentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVentesMouseClicked
        try {
            remplitChampsVentes();
        } catch (SQLException ex) {
            Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblVentesMouseClicked

    private void tblLocationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLocationsMouseClicked
        try {
            remplitChampsLocations();
        } catch (SQLException ex) {
            Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblLocationsMouseClicked

    private void v_btn_ajoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v_btn_ajoutActionPerformed

        String[] colonnes= {"photo","secteur", "types", "surface", "surfaceTerrain", "chambres", "pieces", "prix", "user_id","categorie_id","classe_id"};
        Classe classe = (Classe) v_cmb_classe.getSelectedItem();
        int classe_id = classe.getId();
        Utilisateur utilisateur = (Utilisateur) v_cmb_vendeur.getSelectedItem();
        int utilisateur_id = utilisateur.getId();
        Object[] contenu={v_photo.getText(),v_secteur.getText(),v_type.getText(), v_surface.getText(),v_surfTerrain.getText(),(int) v_chambres.getValue()
                ,(int) v_pieces.getValue(),v_prix.getText(),utilisateur_id,1,classe_id};
        System.out.println(bdd.insert("biens", colonnes, contenu));
        tblVentes.setModel(afficher("ventes"));
    }//GEN-LAST:event_v_btn_ajoutActionPerformed

    private void l_btn_ajoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_btn_ajoutActionPerformed
        String[] colonnes= {"photo","secteur", "types", "surface", "surfaceTerrain", "chambres", "pieces", "prix", "user_id","categorie_id","classe_id"};
        Classe classe = (Classe) cmb_classe.getSelectedItem();
        int classe_id = classe.getId();
        Utilisateur utilisateur = (Utilisateur) cmb_utilisateur.getSelectedItem();
        int utilisateur_id = utilisateur.getId();
        Object[] contenu={l_photo.getText(),l_secteur.getText(),l_type.getText(), l_surface.getText(),l_surfTerrain.getText(),(int) l_chambres.getValue()
                ,(int) l_pieces.getValue(),l_prix.getText(),utilisateur_id,2, classe_id};
        System.out.println(bdd.insert("biens", colonnes, contenu));
        tblLocations.setModel(afficher("locations"));
    }//GEN-LAST:event_l_btn_ajoutActionPerformed

    private void l_btn_supprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_btn_supprActionPerformed
       String id = String.valueOf(tblLocations.getValueAt(tblLocations.getSelectedRow(), 0));
       System.out.println(bdd.delete("biens", id));
       tblLocations.setModel(afficher("locations"));
    }//GEN-LAST:event_l_btn_supprActionPerformed

    private void v_btn_supprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v_btn_supprActionPerformed
        String id = String.valueOf(tblVentes.getValueAt(tblVentes.getSelectedRow(), 0));
        System.out.println(bdd.delete("biens", id));
        tblVentes.setModel(afficher("ventes"));
    }//GEN-LAST:event_v_btn_supprActionPerformed

    private void v_btn_modifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v_btn_modifActionPerformed
        String id = String.valueOf(tblVentes.getValueAt(tblVentes.getSelectedRow(), 0));
        String[] colonnes= {"photo","secteur", "types", "surface", "surfaceTerrain", "chambres", "pieces", "prix", "user_id","categorie_id","classe_id"};
        Classe classe = (Classe) v_cmb_classe.getSelectedItem();
        int classe_id = classe.getId();
        Utilisateur utilisateur = (Utilisateur) v_cmb_vendeur.getSelectedItem();
        int utilisateur_id = utilisateur.getId();
        Object[] contenu={v_photo.getText(),v_secteur.getText(),v_type.getText(), v_surface.getText(),v_surfTerrain.getText(),(int) v_chambres.getValue()
                ,(int) v_pieces.getValue(),v_prix.getText(),utilisateur_id,1,classe_id};
        System.out.println(bdd.updateBien("biens", colonnes, contenu, "id="+id));
        tblVentes.setModel(afficher("ventes"));
    }//GEN-LAST:event_v_btn_modifActionPerformed

    private void l_btn_modifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_btn_modifActionPerformed
        String id = String.valueOf(tblLocations.getValueAt(tblLocations.getSelectedRow(), 0));
        String[] colonnes= {"photo","secteur", "types", "surface", "surfaceTerrain", "chambres", "pieces", "prix", "user_id","categorie_id","classe_id"};
        Classe classe = (Classe) cmb_classe.getSelectedItem();
        int classe_id = classe.getId();
        Utilisateur utilisateur = (Utilisateur) cmb_utilisateur.getSelectedItem();
        int utilisateur_id = utilisateur.getId();
        Object[] contenu={l_photo.getText(),l_secteur.getText(),l_type.getText(), l_surface.getText(),l_surfTerrain.getText(),(int) l_chambres.getValue()
                ,(int) l_pieces.getValue(),l_prix.getText(),utilisateur_id,2,classe_id};
        System.out.println(bdd.updateBien("biens", colonnes, contenu, "id ="+id));
        tblVentes.setModel(afficher("locations"));
    }//GEN-LAST:event_l_btn_modifActionPerformed

    private void table_vendeurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_vendeurMouseClicked
        table_biens.setModel(afficher("biens"));
    }//GEN-LAST:event_table_vendeurMouseClicked

    private void file_chooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_chooserActionPerformed
        v_photo.setText(file_chooser.getSelectedFile().getName());
    }//GEN-LAST:event_file_chooserActionPerformed

    private void l_fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_fileChooserActionPerformed
        l_photo.setText(l_fileChooser.getSelectedFile().getName());
    }//GEN-LAST:event_l_fileChooserActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new FenetrePrincipale().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> cmb_classe;
    private javax.swing.JComboBox<Object> cmb_utilisateur;
    private javax.swing.JFileChooser file_chooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton l_btn_ajout;
    private javax.swing.JButton l_btn_modif;
    private javax.swing.JButton l_btn_suppr;
    private javax.swing.JSpinner l_chambres;
    private javax.swing.JFileChooser l_fileChooser;
    private javax.swing.JTextField l_photo;
    private javax.swing.JSpinner l_pieces;
    private javax.swing.JTextField l_prix;
    private javax.swing.JTextField l_secteur;
    private javax.swing.JTextField l_surfTerrain;
    private javax.swing.JTextField l_surface;
    private javax.swing.JTextField l_type;
    private javax.swing.JTable table_biens;
    private javax.swing.JTable table_vendeur;
    private javax.swing.JTable tblLocations;
    private javax.swing.JTable tblVentes;
    private javax.swing.JButton v_btn_ajout;
    private javax.swing.JButton v_btn_modif;
    private javax.swing.JButton v_btn_suppr;
    private javax.swing.JSpinner v_chambres;
    private javax.swing.JComboBox v_cmb_classe;
    private javax.swing.JComboBox v_cmb_vendeur;
    private javax.swing.JTextField v_photo;
    private javax.swing.JSpinner v_pieces;
    private javax.swing.JTextField v_prix;
    private javax.swing.JTextField v_secteur;
    private javax.swing.JTextField v_surfTerrain;
    private javax.swing.JTextField v_surface;
    private javax.swing.JTextField v_type;
    // End of variables declaration//GEN-END:variables
}
