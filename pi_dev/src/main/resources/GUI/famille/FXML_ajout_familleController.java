/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.famille;

import entity.famille;
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
import javax.swing.JOptionPane;
import service.gest_famille;

/**
 * FXML Controller class
 *
 * @author wadie
 */
public class FXML_ajout_familleController implements Initializable {

    
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
"- Autre pays -"  );
    
    
    @FXML
    private TextField nom_ff_i;
    @FXML
    private TextField email_ff_i;
    @FXML
    private TextField prenom_ff_i;
    @FXML
    private TextField tel_ff_i;
    @FXML
    private ComboBox pays_ff_i;
    @FXML
    private TextField login_ff_i;
    @FXML
    private PasswordField mdp_ff_i;
    @FXML
    private TextField add_ff_i;
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

    
    
    

    private Desktop desktop = Desktop.getDesktop();
    private FileInputStream fis;
    private File file;
    @FXML
    private Button retour;
    @FXML
    private TextField txt_image;
    @FXML
    private Button btn_image;
    /**
     * Initializes the controller class.
     */
    @Override
      public void initialize(URL url, ResourceBundle rb) {
         
   
        pays_ff_i.setValue(" Afrique du Sud");
        pays_ff_i.setItems(paysList);
        // TODO
        
 Stage stage = new Stage();
        btn_image.setOnAction(e -> {
            stage.setTitle("File Chooser ");

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open image File");

            file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                txt_image.setText(file.getAbsolutePath());
                System.out.println(file.getAbsolutePath());
                try {
                    fis = new FileInputStream(file);// file is selected using filechooser which is in last tutorial
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FXML_ajout_familleController.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    //     Image image=  new Image(file.toURI().toString());
                    URL url1 = file.toURI().toURL();
                    System.out.println(new Image(url1.toExternalForm()));
                    //image_post.setImage(new Image(url1.toExternalForm()));
                } catch (MalformedURLException ex) {

                    Logger.getLogger(FXML_ajout_familleController.class.getName()).log(Level.SEVERE, null, ex);

                }

            };

        });

    }    
    
    
    
    
     @FXML
    public void handleBu(ActionEvent event) throws IOException {

        String nom_ff_c = nom_ff_i.getText();  
     String prenom_ff_c = prenom_ff_i.getText();
     String email_ff_c=email_ff_i.getText();
       String add_ff_c=add_ff_i.getText();
       String mdp_ff_c=mdp_ff_i.getText();
       String login_ff_c=login_ff_i.getText();
      String role="Famille";
       String i= tel_ff_i.getText();  
      int tel_ff_c = Integer.parseInt(i);
       String domaine_ff_c ="none";
      String pays_ff_cc = (String) pays_ff_i.getValue();
        String image_rr = txt_image.getText();
               
               String quest_c = "";
               if (btn_rad1_i.isSelected()){
               quest_c += btn_rad1_i.getText();
               }
                if (btn_rad2_i.isSelected()){
               quest_c += btn_rad2_i.getText();
               }
               
               
        gest_famille famille_service = new gest_famille();
        famille famille_entity = new famille(nom_ff_c , prenom_ff_c , email_ff_c , tel_ff_c , pays_ff_cc , login_ff_c , add_ff_c  , mdp_ff_c, quest_c,domaine_ff_c,role);

        //refugee r = new refugee(nom1);

      //  s.ajouterRefugee1(r);
        
        famille_service.ajouterFamille(famille_entity, fis, file);
      
      //  nom2.setCellValueFactory(new PropertyValueFactory<refugee, String>("nom"));
        
Parent root=FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_connexion_famille.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();              
        
    
     }
    @FXML
     public void retour (ActionEvent event) throws IOException {
              
                 Parent root=FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_acceuil0_famille.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();}
}
