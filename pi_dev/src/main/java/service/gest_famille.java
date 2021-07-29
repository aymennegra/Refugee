/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Connexion.Myconnection;
import GUI.famille.FXML_connexion_familleController;
import GUI.famille.FXML_profil_familleController;
import entity.famille;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import static org.apache.velocity.texen.util.FileUtil.file;
import static org.apache.velocity.texen.util.FileUtil.file;

/**
 *
 * @author wadie
 */
public class gest_famille {
    
    
     Myconnection myc = Myconnection.getIstance();
    Connection cnx = myc.getConnection();
    
    
    
   
    
     public void ajouterFamille(famille fa,FileInputStream fis, File file) {
         String requete = "INSERT INTO ajout_famille (nom_db,prenom_db,email_db,tel_db,pays_db,login_db,add_db,mdp_db,quest_db,domaine_db,role_db,image_db) VALUES (?,?,?,?,?  , ?,? ,?,?,?,   ?,?)";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, fa.getNom_ff());
            pst.setString(2, fa.getPrenom_ff());
           
            pst.setString(3, fa.getEmail_ff());
             pst.setInt(4, fa.getTel_ff());
             pst.setString(5, fa.getPays_ff());

            pst.setString(6, fa.getLogin_ff());
            pst.setString(7, fa.getAdd_ff());

            pst.setString(8, fa.getMdp_ff());
            pst.setString(9, fa.getQuest_ff());
            pst.setString(10, fa.getDomaine_ff());
            pst.setString(11, fa.getRole());
            pst.setBinaryStream(12, (InputStream) fis, (int) file.length());

 
            pst.executeUpdate();
            System.out.println("Ajout Complete");
        } catch (SQLException ex) {
            System.out.println("erreur d'insertion");
            System.out.println(ex.getMessage());

        }
     }




     public void modifieFamille(famille fa ,FileInputStream fis, File file) {
      //   String requete = "INSERT INTO ajout_famille (nom_db,prenom_db,email_db,tel_db,pays_db,login_db,add_db,mdp_db,quest_db,domaine_db,role_db) VALUES (?,?,?,?  , ?,? ,?,?,?,   ?,?)";
        
      String requete = "UPDATE ajout_famille SET nom_db=?,prenom_db=?,email_db=?,tel_db=?,pays_db=?,login_db=?,add_db=?,mdp_db=?,quest_db=?,domaine_db=?,role_db=? ,image_db=? WHERE login_db='"+ FXML_connexion_familleController.ff+"';";
            //String sql="SELECT * FROM ajout_famille WHERE login_ff = '"+login_famille.getText()+"' AND mdp_ff = '"+pass_famille.getText()+"';";

         
         try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, fa.getNom_ff());
            pst.setString(2, fa.getPrenom_ff());
           
            pst.setString(3, fa.getEmail_ff());
             pst.setInt(4, fa.getTel_ff());
             pst.setString(5, fa.getPays_ff());

            pst.setString(6, fa.getLogin_ff());
            pst.setString(7, fa.getAdd_ff());

            pst.setString(8, fa.getMdp_ff());
            pst.setString(9, fa.getQuest_ff());
            pst.setString(10, fa.getDomaine_ff());
            pst.setString(11, fa.getRole());
            pst.setBinaryStream(12, (InputStream) fis, (int) file.length());

 
            pst.executeUpdate();
            System.out.println("Ajout Complete");
        } catch (SQLException ex) {
            System.out.println("erreur d'insertion");
            System.out.println(ex.getMessage());

        }
     }

}













//         public String login(String s,String password){
//    
//        
//     
//        //String json = getJSONFromUrl("http://localhost/fixitweb1/web/app_dev.php/login/" + cin1 + "/" + password1);
//        //System.out.println("fff  "+json);
//        String req1="select * from ajout_famille where login_ff= ?and mdp_ff= ?";
//       // String req2="select * from user where username="+cin1 +" and password="+password1+" and roles LIKE '%JOBEUR%'";
//       // String req3="select * from user where username="+cin1 +" and password="+password1+" and roles LIKE '%ADMIN%'";
//        String role = "fault";
//        
//        
//        
//         try {
//                         PreparedStatement pst = cnx.prepareStatement(req1);
//
//                            pst.setString(1, s);
//           
//            pst.setString(2, password);
//                         
//            ResultSet res=  pst.executeQuery(req1);
//            if (res.next()) {
//                role= "fault";
//            }
//           
//            
//            
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        System.out.println(role);
//        return role; 
//    }
//
//    }
 
   
        
        
