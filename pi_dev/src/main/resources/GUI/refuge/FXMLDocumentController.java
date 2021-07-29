/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refuge;

import crud.Refcrud;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import refuge.entities.Refugee;

/**
 *
 * @author Fabio
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button add;

    @FXML
    private Label label;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField cin;

    @FXML
    private TextField id;

    @FXML
    private TextField sexe;

    @FXML
    private TextField num_tel;
    
    @FXML
    private TextField d_naissance;

    @FXML
    private TextField ville;
    
     @FXML
    private Button ret;
     
    


void cleardata()
{
 nom.clear();
        prenom.clear();
        cin.clear();
       sexe.clear();
         num_tel.clear();
         d_naissance.clear();
        ville.clear();
}
    

    @FXML
   void addrefuge(ActionEvent event) {
        
        
        
           if (nom.getText().isEmpty() || prenom.getText().isEmpty() || cin.getText().isEmpty() || sexe.getText().isEmpty() || num_tel.getText().isEmpty() || d_naissance.getText().isEmpty() || ville.getText().isEmpty()) {
           
              Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("Error Dialog");
alert.setHeaderText("MISSING INFORMAtion");
alert.setContentText("Ooops, there was an error!");

alert.showAndWait();
        } else {
               String Nom = nom.getText();
        String Prenom = prenom.getText();
        int Cin = Integer.parseInt(cin.getText());
         String Sexe = sexe.getText();
         String Num_tel = num_tel.getText();
         String D_naissance = d_naissance.getText();
         String Ville = ville.getText();
               
                Refugee r = new Refugee(Nom,Prenom,Cin,0,Sexe,Num_tel,D_naissance,Ville);
            Refcrud udao = Refcrud.getInstance();
            udao.ajouterrefuge(r);
         
           Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Ajout refuge");
alert.setHeaderText("refuge a ete ajouté avec succes");
alert.setContentText("I have a great message for you!");

alert.showAndWait();
cleardata();
            
        }
   }
    @FXML
    void retm(ActionEvent event) {
        
         try {
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Stage stage = (Stage) ret.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
