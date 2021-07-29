/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.livraison;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author wadie
 */

public class FXML_connexion_livraisonController implements Initializable {
public static String ff = "";
    @FXML
    private TextField login_livraison;
    @FXML
    private Button btn_conn_famille;
    @FXML
    private Hyperlink creer_compte;
    @FXML
    private PasswordField pass_famille;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleBu1(ActionEvent event) {
        
        String s = login_livraison.getText();
        FXML_connexion_livraisonController.ff=s ;
    }

    @FXML
    private void redirection_famille(ActionEvent event) {
    }
    
}
