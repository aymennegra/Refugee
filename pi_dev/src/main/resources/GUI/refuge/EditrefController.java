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
import javafx.scene.control.Button;
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
    private TextField d_naissanceedit;

    @FXML
    private TextField villeedit;

    @FXML
    private Button edit;

    @FXML
    private Button retourm;
    SimpleStringProperty nom_recup=AffichageController.nomrecup;
        SimpleStringProperty prenom_recup=AffichageController.prenomrecup;
            SimpleIntegerProperty cin_recup=AffichageController.cinrecup;

                SimpleStringProperty sexe_recup=AffichageController.sexerecup;
    SimpleStringProperty num_tel_recup=AffichageController.num_telrecup;
    SimpleStringProperty d_naissance_recup=AffichageController.d_naissancerecup;
    SimpleStringProperty ville_recup=AffichageController.villerecup;


    @FXML
    void editref(ActionEvent event) {
        String Nom = nomedit.getText();
        String Prenom = prenomedit.getText();
        int Cin = Integer.parseInt(cinedit.getText());
        String Sexe = sexeedit.getText();
        String Num_tel = num_teledit.getText();
        String D_naissance = d_naissanceedit.getText();
        String Ville = villeedit.getText();
        int pm = Integer.parseInt(AffichageController.ii);

        Refugee ref = new Refugee(Nom, Prenom, Cin, pm, Sexe, Num_tel, D_naissance, Ville);
        Refcrud udao = Refcrud.getInstance();
        udao.update(ref);
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
        

                nomedit.setText(nom_recup.get());
                prenomedit.setText(prenom_recup.get());
                cinedit.setText(String.valueOf(cin_recup.get()));
                sexeedit.setText(sexe_recup.get());
                num_teledit.setText(num_tel_recup.get());
                d_naissanceedit.setText(d_naissance_recup.get());
                villeedit.setText(ville_recup.get());
                       
    
}
}
    

