/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refuge;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;
import crud.Refcrud;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import refuge.Connectiondb.ConnexionSingleton;
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
    private TableColumn<Refugee, Number> cin1;

    @FXML
    private TableColumn<Refugee, Number> id1;

    @FXML
    private TableColumn<Refugee, String> sexe1;

    @FXML
    private TableColumn<Refugee, String> numtel1;

    @FXML
    private TableColumn<Refugee, String> d_naissance1;

    @FXML
    private TableColumn<Refugee, String> ville1;

    @FXML
    private Button btnretour;
    @FXML
    private TextField rech;

    @FXML
    private Button btnsupp;
    
    @FXML
    private Label rechlab;
      @FXML
    private Button tr;
@FXML
    private Label var_vv;
@FXML
    private Label id;
public static String vv="";
public static String ii="";
public static SimpleStringProperty nomrecup;
public static SimpleStringProperty prenomrecup;
public static SimpleIntegerProperty cinrecup;
public static SimpleStringProperty sexerecup;
public static SimpleStringProperty num_telrecup;
public static SimpleStringProperty d_naissancerecup;
public static SimpleStringProperty villerecup;



    @FXML
    private Button btnmodif;
    public static String s = "";
    private final ListData listdata = new ListData();
    private final ObservableList<Refugee> datta = FXCollections.observableArrayList();

    private void settable() {

        tablev.setItems(listdata.getUsers());
        nom1.setCellValueFactory(cell -> cell.
                getValue().getNomProperty());
        prenom1.setCellValueFactory(cell -> cell.
                getValue().getPrenomProperty());
        cin1.setCellValueFactory(cell -> cell.
                getValue().getCinProperty());
        id1.setCellValueFactory(cell -> cell.
                getValue().getIdProperty());
        sexe1.setCellValueFactory(cell -> cell.
                getValue().getSexeProperty());
        numtel1.setCellValueFactory(cell -> cell.
                getValue().getNum_telProperty());
        d_naissance1.setCellValueFactory(cell -> cell.
                getValue().getD_naissanceProperty());
        ville1.setCellValueFactory(cell -> cell.
                getValue().getVilleProperty());
        datta.addAll(listdata.getUsers());
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
    void btndel(ActionEvent event) {

        Refugee ref = tablev.getSelectionModel().getSelectedItem();
        Refcrud udao = Refcrud.getInstance();
        udao.delete(ref);
    }

    @FXML
    void btnedit(ActionEvent event) throws IOException{
        
        Refugee E = tablev.getSelectionModel().getSelectedItem();
        //var_vv.setText(E.getNom());

        // System.out.println(E.getNom_r());
        //String s = var_vv.getText();
        AffichageController.nomrecup = E.getNomProperty();
        AffichageController.prenomrecup = E.getPrenomProperty();
        AffichageController.cinrecup = E.getCinProperty();
        AffichageController.sexerecup = E.getSexeProperty();
        AffichageController.num_telrecup = E.getNum_telProperty();
        AffichageController.d_naissancerecup = E.getD_naissanceProperty();
        AffichageController.villerecup = E.getVilleProperty();

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
      FilteredList <Refugee> filteredData = new FilteredList<>(datta, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		rech.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Refugee -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Refugee.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (Refugee.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (String.valueOf(Refugee.getCin()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
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
    
    
    
      

