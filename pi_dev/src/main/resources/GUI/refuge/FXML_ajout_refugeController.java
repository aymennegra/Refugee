/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.refuge;

import entity.famille;
import entity.refuge;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.gest_famille;
import service.gest_refuge;

/**
 * FXML Controller class
 *
 * @author wadie
 */
public class FXML_ajout_refugeController implements Initializable {

    public static String nn = "";
    ObservableList<String> paysList = FXCollections.observableArrayList(
            " Afrique du Sud",
            "Albanie ",
            "Algérie",
            "Allemagne",
            "Argentine",
            "Arménie",
            "Australie",
            "Autriche",
            "Azerbaïdjan",
            "Belgique",
            "Biélorussie",
            "Bolivie",
            "Bosnie-Herzégovine",
            "Brésil",
            "Bulgarie",
            "Cameroun",
            "Canada",
            "Chili",
            "Chine",
            "Chypre",
            "Colombie",
            "Corée du Sud",
            "Costa Rica",
            "Croatie",
            "Côte d'Ivoire",
            "Danemark",
            "Espagne",
            "Estonie",
            "Finlande",
            "France",
            "Ghana",
            "Grèce",
            "Guatemala",
            "Géorgie",
            "Hong Kong",
            "Hongrie",
            "Inde",
            "Indonésie",
            "Irlande",
            "Islande",
            "Israël",
            "Italie",
            "Japon",
            "Kazakhstan",
            "Kenya",
            "Kirghizistan",
            "Lettonie",
            "Liechtenstein",
            "Lituanie",
            "Luxembourg",
            "Macédoine",
            "Madagascar",
            "Malaisie",
            "Malte",
            "Maroc",
            "Mexique",
            "Moldavie",
            "Mongolie",
            "Monténégro",
            "Namibie",
            "Nigeria",
            "Norvège",
            "Nouvelle-Zélande",
            "Népal",
            "Ouzbékistan",
            "Panama",
            "Pays-Bas",
            "Philippines",
            "Pologne",
            "Portugal",
            "Pérou",
            "Roumanie",
            "Royaume-Uni",
            "Russie",
            "République dominicaine",
            "République tchèque",
            "Salvador",
            "Serbie",
            "Singapour",
            "Slovaquie",
            "Slovénie",
            "Suisse",
            "Suède",
            "Sénégal",
            "Taïwan",
            "Thaïlande",
            "Togo",
            "Tunisie",
            "Turquie",
            "Ukraine",
            "Uruguay",
            "Venezuela",
            "Vietnam",
            "Zimbabwe",
            "Égypte",
            "Émirats arabes unis",
            "Équateur",
            "États-Unis ",
            "- Autre pays -");

    @FXML
    private RadioButton btn_rad1_i;
    @FXML
    private ToggleGroup mygroup;
    @FXML
    private Button btn_enregistrer;
    @FXML
    private RadioButton btn_rad2_i;
    @FXML
    private PasswordField confi_ff_i1;
    @FXML
    private TextField nom_r_i;
    @FXML
    private TextField email_r_i;
    @FXML
    private TextField prenom_r_i;
    @FXML
    private TextField tel_r_i;
    @FXML
    private ComboBox pays_r_i;
    @FXML
    private TextField login_r_i;
    @FXML
    private TextField add_r_i;
    @FXML
    private PasswordField mdp_r_i;
    @FXML
    private TextField file_image_p;

    private Desktop desktop = Desktop.getDesktop();
    private FileInputStream fis;
    private File file;
    @FXML
    private Button image_p_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Stage stage = new Stage();
        image_p_btn.setOnAction(e -> {
            stage.setTitle("File Chooser ");

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open image File");

            file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                file_image_p.setText(file.getAbsolutePath());
                System.out.println(file.getAbsolutePath());
                try {
                    fis = new FileInputStream(file);// file is selected using filechooser which is in last tutorial
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FXML_ajout_refugeController.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    //     Image image=  new Image(file.toURI().toString());
                    URL url1 = file.toURI().toURL();
                    System.out.println(new Image(url1.toExternalForm()));
                    //image_post.setImage(new Image(url1.toExternalForm()));
                } catch (MalformedURLException ex) {

                    Logger.getLogger(FXML_ajout_refugeController.class.getName()).log(Level.SEVERE, null, ex);

                }

            };

        });

        pays_r_i.setValue(" Afrique du Sud");
        pays_r_i.setItems(paysList);

    }

    @FXML
    private void handleBu(ActionEvent event) throws IOException {

        
        
        
        
        String nom_r_c = nom_r_i.getText();
        String prenom_r_c = prenom_r_i.getText();
        String email_r_c = email_r_i.getText();
        String add_r_c = add_r_i.getText();
        String mdp_r_c = mdp_r_i.getText();
        String login_r_c = login_r_i.getText();
        String role = "Refuge";
        String i = tel_r_i.getText();
        int tel_r_c = Integer.parseInt(i);
        String domaine_r_c = "none";
        String pays_r_cc = (String) pays_r_i.getValue();
        //retourNom();
        String image_rr = file_image_p.getText();
        String quest_c = "";
        if (btn_rad1_i.isSelected()) {
            quest_c += btn_rad1_i.getText();
        }
        if (btn_rad2_i.isSelected()) {
            quest_c += btn_rad2_i.getText();
        }

        gest_refuge refuge_service = new gest_refuge();
        refuge refuge_entity = new refuge(nom_r_c, prenom_r_c, email_r_c, tel_r_c, pays_r_cc, login_r_c, add_r_c, mdp_r_c, quest_c, domaine_r_c, role);

        refuge_service.ajouterRefuge(refuge_entity, fis, file);

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_connexion_famille.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();

    }

 public void retour (ActionEvent event) throws IOException {
              
                 Parent root=FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_acceuil1_famille.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();}  
   
//    public void retourNom() {
//        String s = nom_r_i.getText();
//        FXML_ajout_refugeController.nn = s;
//    }

}
