/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Connexion.Myconnection;
import static Connexion.Myconnection.cnx;
import entity.famille;
import entity.livraison;
import entity.refuge;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wadie
 */
public class gest_livraison {
    
           Myconnection myc = Myconnection.getIstance();
    Connection cnx = myc.getConnection();
    
    
     
    
     public void ajouterLivraison(livraison liv,FileInputStream fis, File file) {
         String requete = "INSERT INTO ajout_famille (nom_db,prenom_db,email_db,tel_db,pays_db,login_db,add_db,mdp_db,quest_db,domaine_db,role_db,image_db) VALUES (?,?,?,?,?  , ?,? ,?,?,?,   ?,?)";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, liv.getNom_liv());
            pst.setString(2, liv.getPrenom_liv());
           
            pst.setString(3, liv.getEmail_liv());
             pst.setInt(4, liv.getTel_liv());
             pst.setString(5, liv.getPays_liv());

            pst.setString(6, liv.getLogin_liv());
            pst.setString(7, liv.getAdd_liv());

            pst.setString(8, liv.getMdp_liv());
            pst.setString(9, liv.getQuest_liv());
            pst.setString(10, liv.getDomaine_liv());
            pst.setString(11, liv.getRole());
            pst.setBinaryStream(12, (InputStream) fis, (int) file.length());

 
            pst.executeUpdate();
            System.out.println("Ajout Complete");
        } catch (SQLException ex) {
            System.out.println("erreur d'insertion");
            System.out.println(ex.getMessage());

        }
     }

    
    
               public List<livraison> displayLivraison() {
        List<livraison> myList = new ArrayList<>();

        try {
            String requete = "select * from mission where date < CURDATE() ";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                livraison p = new livraison();
               // p.setId_p(rs.getInt("id_p"));
                 p.setNom_mission(rs.getString("nom_misison"));
                   p.setDescription_mission(rs.getString("description"));
                     p.setDate_mission(rs.getDate("date"));
                                     p.setNom_liv(rs.getString("nom_liv"));

 
    
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }
       
    
               
               
    
               public List<livraison> displayLivraison1() {
        List<livraison> myList = new ArrayList<>();

        try {
            String requete = "select * from mission where date > CURDATE() ";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                livraison p = new livraison();
               // p.setId_p(rs.getInt("id_p"));
                  p.setNom_mission(rs.getString("nom_misison"));
                   p.setDescription_mission(rs.getString("description"));
                     p.setDate_mission(rs.getDate("date"));
                                     p.setNom_liv(rs.getString("nom_liv"));
                     
 
    
                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }
               
               
               
               
               
               
               
               
               
     public void dispo(livraison liv) {
         String requete = "INSERT INTO dispo_liv (date_debut,date_fin,nom_liv) VALUES (?,?,?)";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
           
            pst.setDate(1, liv.getDate_dipo_debut());
         
            pst.setDate(2, liv.getDate_dispo_fin());
           
  pst.setString(3, liv.getNom_liv());
            pst.executeUpdate();
            System.out.println("Ajout Complete");
        } catch (SQLException ex) {
            System.out.println("erreur d'insertion");
            System.out.println(ex.getMessage());

        }
     }
            
               
               
               
               
               
               
               
               
               
}
