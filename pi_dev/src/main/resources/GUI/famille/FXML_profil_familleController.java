/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.famille;

import Connexion.Myconnection;
import com.sun.activation.viewers.ImageViewer;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
import GUI.refuge.FXML_ajout_refugeController;
import GUI.refuge.FXML_liste_refugeController;
import entity.refuge;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wadie
 */
public class FXML_profil_familleController implements Initializable {
    //public static String ff = "";

    @FXML
    private Label nom_ref;
    @FXML
    private ImageView im ;
    @FXML
    private Label nom_ref1;
    @FXML
    private Label nom_ref2;
    @FXML
    private Label nom_ref21;
    @FXML
    private Label nom_ref_db;
    @FXML
    private Label prenom_ref_db;
    @FXML
    private Label email_ref_db;
    @FXML
    private Label add_ref_db;
    @FXML
    private Label login_ref_db;
    /**
     * Initializes the controller class
     */
   // @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//        //  FXML_ajout_refugeController r= new FXML_ajout_refugeController();
//          
//          
//          
//      Statement statement=null ;
//    ResultSet resultSet = null ;
//    Myconnection myc = Myconnection.getIstance();
//   Connection cnx = myc.getConnection();
//        try {
//           statement=cnx.createStatement();
//            String sql="SELECT (nom_db ,image_db) FROM ajout_famille WHERE nom_db = '"+ FXML_ajout_refugeController.nn+"' ";
//             resultSet=statement.executeQuery(sql);
//        while(resultSet.next()){
//           // nom_ref.setText();
//           
//           // System.out.println(resultSet.getString("nom_db"));
//            nom_ref.setText(String.valueOf(resultSet));
//            
//           // im.resultSet.getImage("image_db");
//        }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    
//        
//        
//    }    
     public String var_con="";
        public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //  FXML_ajout_refugeController r= new FXML_ajout_refugeController();
        //  FXML_connexion_familleController.ff
        //  if (var_con=FXML_connexion_familleController.ff){
                 if ( FXML_modife_familleController.ll!=""){
             var_con=FXML_modife_familleController.ll;   } 
             
             else {var_con=FXML_connexion_familleController.ff;}

        
        
        
        
        
//        
//         if (FXML_liste_refugeController.vv!=""){
//             var_con=FXML_liste_refugeController.vv;
//                     
//             
//         }
//         else {var_con=FXML_connexion_familleController.ff;}
//        
        
      Statement statement=null ;
    ResultSet resultSet = null ;
    Myconnection myc = Myconnection.getIstance();
   Connection cnx = myc.getConnection();
   
        try {
           statement=cnx.createStatement();
            String sql="SELECT * FROM ajout_famille WHERE nom_db = '"+  var_con+"' ";
             resultSet=statement.executeQuery(sql);
        while(resultSet.next()){
           // nom_ref.setText();
           
           // System.out.println(resultSet.getString("nom_db"));
            nom_ref_db.setText(resultSet.getString("nom_db"));
                        prenom_ref_db.setText(resultSet.getString("prenom_db"));

                                    email_ref_db.setText(resultSet.getString("email_db"));

                                                add_ref_db.setText(resultSet.getString("add_db"));
                                                            login_ref_db.setText(resultSet.getString("login_db"));


                                                
Blob b =  resultSet.getBlob("image_db");
         InputStream istreamImage= b.getBinaryStream();
                Image i = new Image (istreamImage);        
            im.setImage(i);
           // im.resultSet.getImage("image_db");
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        
        
    }    
//   public void retourNom() {
//       
//    }
   
    public void btn_modifieProfil(ActionEvent event) throws IOException {
//         String s = login_ref_db.getText();
//        FXML_profil_familleController.ff = s;
        
               Parent root=FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_modife_famille.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();   
                     
    }
     public void btn_listeRef(ActionEvent event) throws IOException {
//         String s = login_ref_db.getText();
//        FXML_profil_familleController.ff = s;
        
               Parent root=FXMLLoader.load(getClass().getResource("/fxml/FXML_modife_famille.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();   
                
                
                
                
    }
     
     
     
 public void retour (ActionEvent event) throws IOException {
              
                 Parent root=FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_acceuil1_famille.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();}  
   
}
