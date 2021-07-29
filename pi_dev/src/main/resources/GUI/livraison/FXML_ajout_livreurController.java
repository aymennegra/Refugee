/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.livraison;

import entity.famille;
import entity.livraison;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static org.apache.velocity.texen.util.FileUtil.file;
import service.gest_livraison;

/**
 * FXML Controller class
 *
 * @author wadie
 */
public class FXML_ajout_livreurController implements Initializable {

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
    private TextField nom_liv_i;
    @FXML
    private TextField email_liv_i;
    @FXML
    private TextField prenom_liv_i;
    @FXML
    private TextField tel_liv_i;
    @FXML
    private ComboBox pays_liv_i;
    @FXML
    private TextField login_liv_i;
    @FXML
    private TextField add_liv_i;
    @FXML
    private Button btn_enregistrer_liv;
    @FXML
    private PasswordField mdp_liv_i;
    @FXML
    private PasswordField confi_liv_i;
    @FXML
    private Button retour;
    @FXML
    private TextField txt_image_liv;
    @FXML
    private Button btn_image_liv;

    private Desktop desktop = Desktop.getDesktop();
    private FileInputStream fis;
    private File file;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        pays_liv_i.setValue(" Afrique du Sud");
        pays_liv_i.setItems(paysList);
        // TODO

        Stage stage = new Stage();
        btn_image_liv.setOnAction(e -> {
            stage.setTitle("File Chooser ");

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open image File");

            file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                txt_image_liv.setText(file.getAbsolutePath());
                System.out.println(file.getAbsolutePath());
                try {
                    fis = new FileInputStream(file);// file is selected using filechooser which is in last tutorial
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FXML_ajout_livreurController.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    //     Image image=  new Image(file.toURI().toString());
                    URL url1 = file.toURI().toURL();
                    System.out.println(new Image(url1.toExternalForm()));
                    //image_post.setImage(new Image(url1.toExternalForm()));
                } catch (MalformedURLException ex) {

                    Logger.getLogger(FXML_ajout_livreurController.class.getName()).log(Level.SEVERE, null, ex);

                }

            };

        });

    }

    @FXML
    private void handleBu(ActionEvent event) throws IOException {

        String nom_liv_c = nom_liv_i.getText();
        String prenom_liv_c = prenom_liv_i.getText();
        String email_liv_c = email_liv_i.getText();
        String add_liv_c = add_liv_i.getText();
        String mdp_liv_c = mdp_liv_i.getText();
        String login_liv_c = login_liv_i.getText();
        String role = "livreur";
        String i = tel_liv_i.getText();
        int tel_liv_c = Integer.parseInt(i);
        String domaine_liv_c = "none";
        String pays_liv_cc = (String) pays_liv_i.getValue();
        String image_rr = txt_image_liv.getText();

        String quest_c = "none";

        gest_livraison livraison_service = new gest_livraison();
        livraison livraison_entity = new livraison(nom_liv_c, prenom_liv_c, email_liv_c, tel_liv_c, pays_liv_cc, login_liv_c, add_liv_c, mdp_liv_c, quest_c, domaine_liv_c, role);

        //refugee r = new refugee(nom1);
        //  s.ajouterRefugee1(r);
        livraison_service.ajouterLivraison(livraison_entity, fis, file);

        //  nom2.setCellValueFactory(new PropertyValueFactory<refugee, String>("nom"));
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_connexion_famille.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void retour(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_acceuil0_famille.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
}
