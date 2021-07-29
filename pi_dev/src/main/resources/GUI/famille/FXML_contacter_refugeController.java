/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.famille;

import GUI.refuge.FXML_liste_refugeController;
import Connexion.Myconnection;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author wadie
 */
public class FXML_contacter_refugeController implements Initializable {

    @FXML
    private Label nom_ref;
    @FXML
    private Label nom_ref_db;
    @FXML
    private Button envo_i;
    @FXML
    private Label login_ref_db;
    @FXML
    private Button retour;
    @FXML
    private Label nom_ref1;
    @FXML
    private TextField contact_tx;

    /**
     * Initializes the controller class.
     */
   public String var_con="";
        public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //  FXML_ajout_refugeController r= new FXML_ajout_refugeController();
        //  FXML_connexion_familleController.ff
        //  if (var_con=FXML_connexion_familleController.ff){
         if (FXML_liste_refugeController.vv!=""){
             var_con=FXML_liste_refugeController.vv;
                     
             
         }
         else {var_con=FXML_connexion_familleController.ff;}
        
        
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

        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        
        
    }    
//   public void retourNom() {
//         

    @FXML
    private void btn_modifieProfil(ActionEvent event) {
    }

    @FXML
    private void retour(ActionEvent event) {
    }
    
}
