/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.livraison;

import entity.livraison;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.gest_livraison;

/**
 * FXML Controller class
 *
 * @author wadie
 */
public class FXML_mission_livraisonController implements Initializable {

    @FXML
    private Label profil_liv;
    @FXML
    private Button retour;
    @FXML
    private TableView<livraison> tab1;
    @FXML
    private TableColumn nom_mission1;
    @FXML
    private TableColumn date_mission1;
    @FXML
    private TableColumn desc1;
    @FXML
    private TableColumn nom_mission2;
    @FXML
    private TableColumn date2;
    @FXML
    private TableColumn desc2;
    @FXML
    private TableView<livraison> tab2;
    @FXML
    private TableColumn nom_liv1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        gest_livraison ref = new gest_livraison();

        ArrayList<livraison> refu = (ArrayList<livraison>) ref.displayLivraison();
        ObservableList<livraison> obs = FXCollections.observableArrayList(refu);
        tab1.setItems(obs);
        nom_mission1.setCellValueFactory(new PropertyValueFactory<livraison, String>("nom_mission"));
        desc1.setCellValueFactory(new PropertyValueFactory<livraison, String>("description_mission"));
        date_mission1.setCellValueFactory(new PropertyValueFactory<livraison, Date>("date_mission"));
        //     nom_liv1.setCellValueFactory(new PropertyValueFactory<livraison, String>("nom_liv"));

          //tab2.managedProperty().bind(tab2.visibleProperty());
        //tab2.visibleProperty().bind(Bindings.isEmpty(tab2.getItems()).not());

        ArrayList<livraison> refu1 = (ArrayList<livraison>) ref.displayLivraison1();
        ObservableList<livraison> obs1 = FXCollections.observableArrayList(refu1);
        tab2.setItems(obs1);
        nom_mission2.setCellValueFactory(new PropertyValueFactory<livraison, String>("nom_mission"));
        desc2.setCellValueFactory(new PropertyValueFactory<livraison, String>("description_mission"));
        date2.setCellValueFactory(new PropertyValueFactory<livraison, Date>("date"));
        //   nom_liv2.setCellValueFactory(new PropertyValueFactory<livraison, String>("nom_liv"));
        //a();
        // contact();
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("/fxml/livraison_fxml/FXML_acceuil1_famille.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }

}
