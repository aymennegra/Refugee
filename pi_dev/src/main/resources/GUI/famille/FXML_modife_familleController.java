/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.famille;

import Connexion.Myconnection;
import GUI.refuge.FXML_ajout_refugeController;
import GUI.famille.FXML_connexion_familleController;
import GUI.famille.FXML_connexion_familleController;
import GUI.refuge.FXML_liste_refugeController;
import entity.famille;
import entity.refuge;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class FXML_modife_familleController implements Initializable {

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
    private RadioButton btn_rad1_i;
    @FXML
    private ToggleGroup mygroup;
    @FXML
    private Button btn_enregistrer;
    @FXML
    private RadioButton btn_rad2_i;
    @FXML
    private PasswordField mdp_r_i;
    @FXML
    private PasswordField confi_ff_i1;
    @FXML
    private TextField file_image_p;
    @FXML
    private Button image_p_btn;
   private Desktop desktop = Desktop.getDesktop();
    private FileInputStream fis;
    private File file;
    @FXML
public static String ll="";
    /**
     * Initializes the controller class.
     */
  public String var_con="";
    @Override
        public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //  FXML_ajout_refugeController r= new FXML_ajout_refugeController();
        //  FXML_connexion_familleController.ff
        //  if (var_con=FXML_connexion_familleController.ff){
         if (FXML_liste_refugeController.vv!=""){
             var_con=FXML_liste_refugeController.vv;    
         }
         else {var_con=FXML_connexion_familleController.ff;}

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
                    Logger.getLogger(FXML_modife_familleController.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    //     Image image=  new Image(file.toURI().toString());
                    URL url1 = file.toURI().toURL();
                    System.out.println(new Image(url1.toExternalForm()));
                    //image_post.setImage(new Image(url1.toExternalForm()));
                } catch (MalformedURLException ex) {

                    Logger.getLogger(FXML_modife_familleController.class.getName()).log(Level.SEVERE, null, ex);

                }

            };

        });

        pays_r_i.setValue(" Afrique du Sud");
        pays_r_i.setItems(paysList);
        // TODO

        Statement statement = null;
        ResultSet resultSet = null;
        Myconnection myc = Myconnection.getIstance();
        Connection cnx = myc.getConnection();
        try {
            statement = cnx.createStatement();
            String sql = "SELECT * FROM ajout_famille WHERE nom_db = '" + var_con + "' ";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // nom_ref.setText();

                // System.out.println(resultSet.getString("nom_db"));
                nom_r_i.setText(resultSet.getString("nom_db"));
                prenom_r_i.setText(resultSet.getString("prenom_db"));

                email_r_i.setText(resultSet.getString("email_db"));
                tel_r_i.setText(resultSet.getString("tel_db"));
                add_r_i.setText(resultSet.getString("add_db"));
                login_r_i.setText(resultSet.getString("login_db"));

//                                                
//Blob b =  resultSet.getBlob("image_db");
//         InputStream istreamImage= b.getBinaryStream();
//                Image i = new Image (istreamImage);        
//            im.setImage(i);
                // im.resultSet.getImage("image_db");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

 public void retour (ActionEvent event) throws IOException {
              
                 Parent root=FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_ajout_famille.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();}  
   
    public void handleBu(ActionEvent event) throws IOException {

        String nom_ff_c = nom_r_i.getText();
        String prenom_ff_c = prenom_r_i.getText();
        String email_ff_c = email_r_i.getText();
        String add_ff_c = add_r_i.getText();
        String mdp_ff_c = mdp_r_i.getText();
        String login_ff_c = login_r_i.getText();
        String role = "Famille";
        String i = tel_r_i.getText();
        int tel_ff_c = Integer.parseInt(i);
        String domaine_ff_c = "none";
        String pays_ff_cc = (String) pays_r_i.getValue();
         String image_rr = file_image_p.getText();
        String quest_c = "";
        if (btn_rad1_i.isSelected()) {
            quest_c += btn_rad1_i.getText();
        }
        if (btn_rad2_i.isSelected()) {
            quest_c += btn_rad2_i.getText();
        }

        gest_famille famille_service = new gest_famille();
        famille famille_entity = new famille(nom_ff_c, prenom_ff_c, email_ff_c, tel_ff_c, pays_ff_cc, login_ff_c, add_ff_c, mdp_ff_c, quest_c, domaine_ff_c, role);

        //refugee r = new refugee(nom1);
        //  s.ajouterRefugee1(r);
        
        
        famille_service.modifieFamille(famille_entity, fis, file);

             //   String s = login_famille.getText();
        FXML_modife_familleController.ll = login_ff_c;
        
        //  nom2.setCellValueFactory(new PropertyValueFactory<refugee, String>("nom"));



        Parent root = FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_acceuil1_famille.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();

    }

}
