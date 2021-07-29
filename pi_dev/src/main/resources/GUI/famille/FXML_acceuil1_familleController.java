/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.famille;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wadie
 */
public class FXML_acceuil1_familleController implements Initializable {

    @FXML
    private Hyperlink redi_profil;
    @FXML
    private Hyperlink redi_don;
    @FXML
    private Hyperlink redi_lis_ref;
    @FXML
    private Hyperlink redi_lis_asso;
    @FXML
    private Label nom_ref21;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
     public void btn_lien_pro(ActionEvent event) throws IOException {
       
        
               Parent root=FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_profil_famille.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();   
                
                
    }
     
      public void btn_lien_don(ActionEvent event) throws IOException {
       
        
               Parent root=FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_connexion_famille.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();   
    }

    @FXML
 public void btn_lien_lis_ref(ActionEvent event) throws IOException {
       
        
               Parent root=FXMLLoader.load(getClass().getResource("/fxml/FXML_liste_refuge.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();   
    }
 public void btn_lien_lis_asso(ActionEvent event) throws IOException {
       
        
               Parent root=FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_connexion_famille.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();   
    }
}
