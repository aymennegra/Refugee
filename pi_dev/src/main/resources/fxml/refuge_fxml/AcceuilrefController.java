/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refuge;

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
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fabio
 */
public class AcceuilrefController implements Initializable {

    @FXML
    private Hyperlink logout;

    @FXML
    private Hyperlink profil;
    
    @FXML
    private Hyperlink contacta;

    @FXML
    private Hyperlink contactf;

    @FXML
    void dec(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("loginref.fxml"));
            Stage stage = (Stage) logout.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void prof(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("refprofile.fxml"));
            Stage stage = (Stage) logout.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void contactass(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("contactass.fxml"));
            Stage stage = (Stage) contacta.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void contactfam(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("contactfam.fxml"));
            Stage stage = (Stage) contactf.getScene().getWindow();
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
