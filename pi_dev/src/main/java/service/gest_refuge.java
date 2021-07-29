/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Connexion.Myconnection;
import GUI.famille.FXML_connexion_familleController;
import entity.famille;
import entity.refuge;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static org.apache.velocity.texen.util.FileUtil.file;

/**
 *
 * @author wadie
 */
public class gest_refuge {
    
         Myconnection myc = Myconnection.getIstance();
    Connection cnx = myc.getConnection();
    
    
         public void ajouterRefuge(refuge ref, FileInputStream fis, File file) {
         String requete = "INSERT INTO ajout_famille (nom_db,prenom_db,email_db,tel_db,pays_db,login_db,add_db,mdp_db,quest_db,domaine_db,role_db,image_db) VALUES (?,?,?,?,?  , ?,? ,?,?,?,   ?,?)";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, ref.getNom_r());
            pst.setString(2, ref.getPrenom_r());
           
            pst.setString(3, ref.getEmail_r());
             pst.setInt(4, ref.getTel_r());
             pst.setString(5, ref.getPays_r());

            pst.setString(6, ref.getLogin_r());
            pst.setString(7, ref.getAdd_r());

            pst.setString(8, ref.getMdp_r());
            pst.setString(9, ref.getQuest_r());
            pst.setString(10, ref.getDomaine_r());
            pst.setString(11, ref.getRole());
            pst.setBinaryStream(12, (InputStream) fis, (int) file.length());

 
            pst.executeUpdate();
            System.out.println("Ajout Complete");
        } catch (SQLException ex) {
            System.out.println("erreur d'insertion");
            System.out.println(ex.getMessage());

        }
     }
 
  
               public List<refuge> displayRefuge() {
        List<refuge> myList = new ArrayList<>();

        try {
            String requete = "select * from ajout_famille ";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                refuge p = new refuge();
               // p.setId_p(rs.getInt("id_p"));
                p.setNom_r(rs.getString("nom_db"));
                 p.setPrenom_r(rs.getString("prenom_db"));
                   p.setEmail_r(rs.getString("email_db"));
                     p.setAdd_r(rs.getString("add_db"));
                     

                myList.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }
               
               
               
                 public void modifieRefuge(refuge ref ,FileInputStream fis, File file) {
      //   String requete = "INSERT INTO ajout_famille (nom_db,prenom_db,email_db,tel_db,pays_db,login_db,add_db,mdp_db,quest_db,domaine_db,role_db) VALUES (?,?,?,?  , ?,? ,?,?,?,   ?,?)";
        
       String requete = "UPDATE ajout_famille SET nom_db=?,prenom_db=?,email_db=?,tel_db=?,pays_db=?,login_db=?,add_db=?,mdp_db=?,quest_db=?,domaine_db=?,role_db=? ,image_db=? WHERE login_db='"+ FXML_connexion_familleController.ff+"';";
            //String sql="SELECT * FROM ajout_famille WHERE login_ff = '"+login_famille.getText()+"' AND mdp_ff = '"+pass_famille.getText()+"';";

         
         try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, ref.getNom_r());
            pst.setString(2, ref.getPrenom_r());
           
            pst.setString(3, ref.getEmail_r());
             pst.setInt(4, ref.getTel_r());
             pst.setString(5, ref.getPays_r());

            pst.setString(6, ref.getLogin_r());
            pst.setString(7, ref.getAdd_r());

            pst.setString(8, ref.getMdp_r());
            pst.setString(9, ref.getQuest_r());
            pst.setString(10, ref.getDomaine_r());
            pst.setString(11, ref.getRole());
            pst.setBinaryStream(12, (InputStream) fis, (int) file.length());

 
            pst.executeUpdate();
            System.out.println("Ajout Complete");
        } catch (SQLException ex) {
            System.out.println("erreur d'insertion");
            System.out.println(ex.getMessage());

        }
     }

}


    

