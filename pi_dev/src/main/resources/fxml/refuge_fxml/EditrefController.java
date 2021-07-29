/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refuge;

import crud.Refcrud;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import refuge.Connectiondb.ConnexionSingleton;
import refuge.entities.Refugee;

/**
 * FXML Controller class
 *
 * @author Fabio
 */
public class EditrefController implements Initializable {

    @FXML
    private TextField nomedit;

    @FXML
    private TextField prenomedit;

    @FXML
    private TextField cinedit;

    @FXML
    private TextField sexeedit;

    @FXML
    private TextField num_teledit;

    @FXML
    private DatePicker d_naissanceedit;

    @FXML
    private TextField villeedit;
    
    @FXML
    private TextField emailedit;

    @FXML
    private TextField passwordedit;

    @FXML
    private Button edit;

    @FXML
    private Button retourm;

    String nom_recup = AffichageController.nomrecup;
    String prenom_recup = AffichageController.prenomrecup;
    Integer cin_recup = AffichageController.cinrecup;
    String sexe_recup = AffichageController.sexerecup;
    String num_tel_recup = AffichageController.num_telrecup;
    String ville_recup = AffichageController.villerecup;
    String email_recup = AffichageController.emailrecup;

    void cleardata() {
        nomedit.clear();
        prenomedit.clear();
        cinedit.clear();
        sexeedit.clear();
        num_teledit.clear();
        villeedit.clear();
        emailedit.clear();
    }

    @FXML
    void editref(ActionEvent event) {

        if (nomedit.getText().isEmpty() || prenomedit.getText().isEmpty() || cinedit.getText().isEmpty() || sexeedit.getText().isEmpty() || num_teledit.getText().isEmpty() || villeedit.getText().isEmpty()) {

            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Ooops, Erreur de modification!");

            alert.showAndWait();
        } else {
            String Nom = nomedit.getText();
            String Prenom = prenomedit.getText();
            int Cin = Integer.parseInt(cinedit.getText());
            String Sexe = sexeedit.getText();
            String Num_tel = num_teledit.getText();
            LocalDate D_naissance = d_naissanceedit.getValue();
            Date daten = Date.valueOf(D_naissance);
            String Ville = villeedit.getText();
            String Email = emailedit.getText();
            String Password = passwordedit.getText();


            Refugee ref = new Refugee(Nom, Prenom, Cin, Sexe, Num_tel, daten, Ville,Email ,Password);
            Refcrud udao = Refcrud.getInstance();
            udao.update(ref);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Modification refuge");
            alert.setContentText("refuge a ete modifier avec succes!");

            alert.showAndWait();
            cleardata();

        }
    }

    @FXML
    void retourm(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("affichage.fxml"));
            Stage stage = (Stage) retourm.getScene().getWindow();
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

        nomedit.setText(nom_recup);
        prenomedit.setText(prenom_recup);
        cinedit.setText(String.valueOf(cin_recup));
        sexeedit.setText(sexe_recup);
        num_teledit.setText(num_tel_recup);
        villeedit.setText(ville_recup);
        emailedit.setText(email_recup);
        d_naissanceedit.setValue(LocalDate.now());

    }
}
