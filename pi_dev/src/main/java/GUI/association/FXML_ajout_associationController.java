/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.association;

import entity.assocaition;
import entity.famille;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;
import service.gest_assocation;
import service.gest_famille;

/**
 * FXML Controller class
 *
 * @author wadie
 */
public class FXML_ajout_associationController implements Initializable {

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
     ObservableList<String> domaineList = FXCollections.observableArrayList(  "a","b");
    
    
    @FXML
    private Button btn_enregistrer;
    @FXML
    private ComboBox domaine_a_i;
    @FXML
    private TextField nom_a_i;
    @FXML
    private TextField email_a_i;
    @FXML
    private TextField fax_a_i;
    @FXML
    private ComboBox pays_a_i;
    @FXML
    private TextField login_a_i;
    @FXML
    private TextField add_a_i;
    @FXML
    private PasswordField mdp_a_i;
    @FXML
    private PasswordField confi_a_i1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         pays_a_i.setValue(" Afrique du Sud");
        pays_a_i.setItems(paysList);
        
        
        domaine_a_i.setValue("a");
        domaine_a_i.setItems(domaineList);
        
    }    

    @FXML
    public void handleBu(ActionEvent event) throws IOException {
String role="Association";
String prenom ="none";
String quest ="none";
        String nom_a_c = nom_a_i.getText();  
     String email_a_c=email_a_i.getText();
       String add_a_c=add_a_i.getText();
       String mdp_a_c=mdp_a_i.getText();
       String login_a_c=login_a_i.getText();
    
       String i= fax_a_i.getText();  
      int fax_a_c = Integer.parseInt(i);
       
      String pays_a_c = (String) pays_a_i.getValue();
       String domaine_a_c = (String) domaine_a_i.getValue();
        gest_assocation assocaition_service = new gest_assocation();
        assocaition assocaition_entity = new assocaition(nom_a_c , prenom, email_a_c , fax_a_c , pays_a_c , login_a_c , add_a_c  , mdp_a_c, quest,domaine_a_c,role);
        //refugee r = new refugee(nom1);

      //  s.ajouterRefugee1(r);
        
        assocaition_service.ajouterAssociation(assocaition_entity);
      
      //  nom2.setCellValueFactory(new PropertyValueFactory<refugee, String>("nom"));
        
Parent root=FXMLLoader.load(getClass().getResource("/fxml/FXML_connexion_famille.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();              
        
    
     }
    
}
