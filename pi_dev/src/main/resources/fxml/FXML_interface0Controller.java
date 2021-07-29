/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

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
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wadie
 */
public class FXML_interface0Controller implements Initializable {

    @FXML
    private Button btn_espace_utilisateur;
    @FXML
    private Button btn_espace_association;
    @FXML
    private Button btn_espace_famille;
    @FXML
    private Hyperlink link_connexion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
     public void b_espace_utilisateur(ActionEvent event) throws IOException {
               Parent root=FXMLLoader.load(getClass().getResource("/fxml/FXML_connexion_utilisateur.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();   
    }
     
    @FXML
       public void b_espace_association(ActionEvent event) throws IOException {
               Parent root=FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_connexion_association.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();   
    }
    @FXML
         public void b_espace_famille(ActionEvent event) throws IOException {
               Parent root=FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_acceuil0_famille.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();   
    }

}
