/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.famille;

import Connexion.Myconnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author wadie
 */
public class FXML_connexion_familleController implements Initializable {
public static String ff="";
    @FXML
    private TextField login_famille;
    @FXML
    private Button btn_conn_famille;
    @FXML
    private PasswordField pass_famille;
    @FXML
    private Hyperlink creer_compte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void handleBu1(ActionEvent event) throws IOException {

                String s = login_famille.getText();
        FXML_connexion_familleController.ff = s;
        
        
        
        Statement statement = null;
        ResultSet resultSet = null;
        Myconnection myc = Myconnection.getIstance();
        Connection cnx = myc.getConnection();

        try {
            statement = cnx.createStatement();
            String sql = "SELECT * FROM ajout_famille WHERE login_db = '" + login_famille.getText() + "' AND mdp_db = '" + pass_famille.getText() + "';";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_acceuil1_famille.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();
            } else {

                JOptionPane.showMessageDialog(null, "non succée");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void redirection_famille(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_ajout_famille.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
//    }

    }

}
