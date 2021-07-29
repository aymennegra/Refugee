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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fabio
 */
public class RefprofileController implements Initializable {

    /**
     * Initializes the controller class.
     */
    String catchnom = LoginrefController.nomrecup1;
    String catchprenom = LoginrefController.prenomrecup1;
    String catchcin = LoginrefController.cinrecup1;
    String catchsexe = LoginrefController.sexerecup1;
    String catchnum = LoginrefController.num_telrecup1;
    String catchdate = LoginrefController.daterecup1;
    String catchville = LoginrefController.villerecup1;
    String catchemail = LoginrefController.emailrecup1;
    String catchpassword = LoginrefController.passwordrecup1;

    @FXML
    private Label labelnom;

    @FXML
    private Label labelprenom;

    @FXML
    private Label labelcin;

    @FXML
    private Label labelsexe;

    @FXML
    private Label labelnum;

    @FXML
    private Label labeldate;

    @FXML
    private Label labelemail;

    @FXML
    private Label labelpassword;

    @FXML
    private Label labelville;

    @FXML
    private Button retour;

    @FXML
    void btnretour(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("acceuilref.fxml"));
            Stage stage = (Stage) retour.getScene().getWindow();
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
        labelnom.setText(catchnom);
        labelprenom.setText(catchprenom);
        labelsexe.setText(catchsexe);
        labelcin.setText(catchcin);
        labelnum.setText(catchnum);
        labeldate.setText(catchdate);
        labelemail.setText(catchemail);
        labelpassword.setText(catchpassword);
        labelville.setText(catchville);
    }

}
