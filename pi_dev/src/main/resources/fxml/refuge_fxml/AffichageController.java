/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refuge;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import crud.Refcrud;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import refuge.entities.Refugee;

/**
 * FXML Controller class
 *
 * @author Fabio
 */
public class AffichageController implements Initializable {

    @FXML
    private TableView<Refugee> tablev;

    @FXML
    private TableColumn<Refugee, String> nom1;

    @FXML
    private TableColumn<Refugee, String> prenom1;

    @FXML
    private TableColumn<Refugee, Integer> cin1;

    @FXML
    private TableColumn<Refugee, String> sexe1;

    @FXML
    private TableColumn<Refugee, String> numtel1;

    @FXML
    private TableColumn<Refugee, Date> d_naissance1;

    @FXML
    private TableColumn<Refugee, String> ville1;
    @FXML
    private TableColumn<Refugee, String> email1;

    @FXML
    private Button btnretour;

    @FXML
    private TextField rech;

    @FXML
    private Button btnsupp;

    @FXML
    private Label rechlab;

    public static String nomrecup;
    public static String prenomrecup;
    public static Integer cinrecup;
    public static String sexerecup;
    public static String num_telrecup;
    public static Date d_naissancerecup;
    public static String villerecup;
    public static String emailrecup;

    @FXML
    private Button btnmodif;

    private final ObservableList<Refugee> datta = FXCollections.observableArrayList();

    private void settable() {

        Refcrud ref = new Refcrud();

        ArrayList<Refugee> refu = (ArrayList<Refugee>) ref.displayRefugee();
        ObservableList<Refugee> obs = FXCollections.observableArrayList(refu);
        tablev.setItems(obs);
        nom1.setCellValueFactory(new PropertyValueFactory<Refugee, String>("nom"));
        prenom1.setCellValueFactory(new PropertyValueFactory<Refugee, String>("prenom"));
        cin1.setCellValueFactory(new PropertyValueFactory<Refugee, Integer>("cin"));
        sexe1.setCellValueFactory(new PropertyValueFactory<Refugee, String>("sexe"));
        numtel1.setCellValueFactory(new PropertyValueFactory<Refugee, String>("num_tel"));
        d_naissance1.setCellValueFactory(new PropertyValueFactory<Refugee, Date>("d_naissance"));
        ville1.setCellValueFactory(new PropertyValueFactory<Refugee, String>("ville"));
        email1.setCellValueFactory(new PropertyValueFactory<Refugee, String>("email"));
        datta.addAll(refu);

    }

    @FXML
    void btnret(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Stage stage = (Stage) btnretour.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void btndel(ActionEvent event) throws IOException {
        
            Refugee ref = tablev.getSelectionModel().getSelectedItem();
            Refcrud udao = Refcrud.getInstance();
            udao.delete(ref);
            Notifications.create().title("Supression").text("Refugee supprimé").showConfirm();

       
    }

    @FXML
    void btnedit(ActionEvent event) throws IOException {

        Refugee E = tablev.getSelectionModel().getSelectedItem();

        AffichageController.nomrecup = E.getNom();
        AffichageController.prenomrecup = E.getPrenom();
        AffichageController.cinrecup = E.getCin();
        AffichageController.sexerecup = E.getSexe();
        AffichageController.num_telrecup = E.getNum_tel();
        AffichageController.villerecup = E.getVille();
        AffichageController.emailrecup = E.getEmail();

        Parent root = FXMLLoader.load(getClass().getResource("editref.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        settable();
        FilteredList<Refugee> filteredData = new FilteredList<>(datta, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        rech.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Refugee -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (Refugee.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (Refugee.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(Refugee.getCin()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Refugee> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tablev.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tablev.setItems(sortedData);

    }

}
