/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.livraison;

import entity.livraison;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import service.gest_livraison;

/**
 * FXML Controller class
 *
 * @author wadie
 */
public class FXML_dispo_livraisonController implements Initializable {

    @FXML
    private Label profil_liv;
    @FXML
    private Button retour;
    @FXML
    private DatePicker date2;
    @FXML
    private DatePicker date1;
    @FXML
    private Button btn_enreg;
    @FXML
    private Label lab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
     private void retour(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("/fxml/livraison_fxml/FXML_acceuil1_famille.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
    
        @FXML
    private void handleBu(ActionEvent event ) throws IOException {
    
      LocalDate locald = date1.getValue();
       LocalDate locald1 = date2.getValue();
       if (locald.compareTo(locald1) >0) { 
           String m = "corriger date";
           lab.setText(m);
       }
       else {   Date date = Date.valueOf(locald);
    String s = "wadie ";
            
                 
            Date date1 = Date.valueOf(locald);
    
            
            livraison  l = new livraison ( date , date1, s);
            gest_livraison li = new gest_livraison();
            li.dispo(l);
       }
          
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/livraison_fxml/FXML_acceuil1_famille.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
    
}
