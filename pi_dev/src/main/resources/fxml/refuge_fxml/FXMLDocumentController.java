/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refuge;

import crud.Refcrud;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import refuge.entities.Refugee;
import refuge.sendmail;

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
    private ComboBox sexe;

    @FXML
    private TextField num_tel;

    @FXML
    private DatePicker d_naissance;

    @FXML
    private TextField ville;
    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Button ret;

    ObservableList<String> sexelist = FXCollections.observableArrayList("Homme", "Femme");

    void cleardata() {
        nom.clear();
        prenom.clear();
        cin.clear();
        num_tel.clear();
        ville.clear();
    }

    @FXML
    void addrefuge(ActionEvent event) throws IOException, Exception {

        if (nom.getText().isEmpty() || prenom.getText().isEmpty() || cin.getText().isEmpty() || num_tel.getText().isEmpty() || ville.getText().isEmpty()) {

            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Ooops, missing information!");

            alert.showAndWait();
        } else {
            String Nom = nom.getText();
            String Prenom = prenom.getText();
            int Cin = Integer.parseInt(cin.getText());
            String Sexe = sexe.getSelectionModel().getSelectedItem().toString();
            String Num_tel = num_tel.getText();
            LocalDate D_naissance = d_naissance.getValue();
            Date daten = Date.valueOf(D_naissance);
            String Ville = ville.getText();
            String Email = email.getText();
            String Password = password.getText();

            Refugee r = new Refugee(Nom, Prenom, Cin, Sexe, Num_tel, daten, Ville, Email, Password);
            Refcrud udao = Refcrud.getInstance();
            udao.ajouterrefuge(r);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ajout refuge");
            alert.setContentText("refuge a ete ajouté avec succes!");

            alert.showAndWait();
            cleardata();
            String mess = Email;
            sendmail.sendmail(mess);

        }
    }

    @FXML
    void retm(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("loginref.fxml"));
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
        sexe.setValue("Homme");
        sexe.setItems(sexelist);
    }

}
