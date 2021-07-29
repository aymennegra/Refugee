/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.livraison;

import Connexion.Myconnection;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author wadie
 */
public class FXML_profil_livraisonController implements Initializable {

    @FXML
    private Label nom_ref1;
    @FXML
    private Button retour;
    @FXML
    private Label nom_ref;
    @FXML
    private Label nom_ref2;
    @FXML
    private Label nom_ref21;
    @FXML
    private Label nom_liv_db;
    @FXML
    private Label prenom_liv_db;
    @FXML
    private Label email_liv_db;
    @FXML
    private Label add_liv_db;
    @FXML
    private Button modif;
    @FXML
    private ImageView im;
    @FXML
    private Label login_liv_db;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Statement statement = null;
        ResultSet resultSet = null;
        Myconnection myc = Myconnection.getIstance();
        Connection cnx = myc.getConnection();

        try {
            statement = cnx.createStatement();
            String sql = "SELECT * FROM ajout_famille WHERE nom_db = '" + FXML_connexion_livraisonController.ff + "' ";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // nom_ref.setText();

                // System.out.println(resultSet.getString("nom_db"));
                nom_liv_db.setText(resultSet.getString("nom_db"));
                prenom_liv_db.setText(resultSet.getString("prenom_db"));

                email_liv_db.setText(resultSet.getString("email_db"));

                add_liv_db.setText(resultSet.getString("add_db"));
                login_liv_db.setText(resultSet.getString("login_db"));
                
                
                Blob b =  resultSet.getBlob("image_db");
         InputStream istreamImage= b.getBinaryStream();
                Image i = new Image (istreamImage);        
            im.setImage(i);
            
//            
//              statement = cnx.createStatement();
//            String sql2 = "SELECT * FROM dispo_liv WHERE nom_liv = '" + FXML_connexion_livraisonController.ff + "' ";
//            resultSet = statement.executeQuery(sql2);
//             while (resultSet.next()) {
//               
//             if (resultSet.getDate("date_fin").compareTo(timeStamp)){}
//                
             //}
            
            }
            }catch (SQLException e) {
            e.printStackTrace();
        }
        
        

// TODO
        }

        @FXML
        private void retour(ActionEvent event) {
    }

    @FXML
    private void btn_contacter(ActionEvent event) {
    }
    
}
