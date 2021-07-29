/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refuge;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import refuge.Connectiondb.ConnexionSingleton;
import refuge.entities.Refugee;

/**
 * FXML Controller class
 *
 * @author Fabio
 */
public class LoginrefController implements Initializable {

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Button SeConnecter;

    @FXML
    private Button signu;

    public static String nomrecup1;
    public static String prenomrecup1;
    public static String cinrecup1;
    public static String sexerecup1;
    public static String num_telrecup1;
    public static String daterecup1;
    public static String villerecup1;
    public static String emailrecup1;
    public static String passwordrecup1;

    @FXML
    void SeConn(ActionEvent event) throws SQLException {

        String lo = email.getText();
        String psw = password.getText();
        Refugee u = new Refugee();

        String req = "SELECT * FROM refuge WHERE `email`='" + lo + "' AND `password`='" + psw + "'";
        PreparedStatement stm;

        try {
            stm = ConnexionSingleton.getInstance().getCnx().prepareStatement(req);
            ResultSet rs = stm.executeQuery(req);
            if (rs.next() == true) {

                int est_admin = rs.getInt("status");
                LoginrefController.nomrecup1 = rs.getString("nom");
                LoginrefController.prenomrecup1 = rs.getString("prenom");
                LoginrefController.cinrecup1 = rs.getString("cin");
                LoginrefController.sexerecup1 = rs.getString("sexe");
                LoginrefController.num_telrecup1 = rs.getString("num_tel");
                LoginrefController.villerecup1 = rs.getString("ville");
                LoginrefController.daterecup1 = rs.getString("d_naissance");
                LoginrefController.emailrecup1 = rs.getString("email");
                LoginrefController.passwordrecup1 = rs.getString("password");

                if (est_admin == 1) {

                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                        Stage stage = (Stage) SeConnecter.getScene().getWindow();
                        stage.close();
                        Scene scene = new Scene(root);

                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("acceuilref.fxml"));
                        Stage stage = (Stage) SeConnecter.getScene().getWindow();
                        stage.close();
                        Scene scene = new Scene(root);

                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Informations incorrectes");
                alert.setContentText("\"Vérifiez votre identifiant EMAIL et votre mot de passe\"!");
                alert.showAndWait();
                password.clear();

            }

        } catch (SQLException ex) {

            Logger.getLogger(LoginrefController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    void signup(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Stage stage = (Stage) SeConnecter.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
