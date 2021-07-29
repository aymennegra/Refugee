/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.refuge;

import entity.refuge;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
//import service.ajout;
import service.gest_refuge;
import entity.refuge;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;






/**
 * FXML Controller class
 *
 * @author wadie
 */
public class FXML_liste_refugeController implements Initializable {

    @FXML
    private Label nom_ref21;
    @FXML
    private TableView<refuge> view_ref;
    @FXML
    private TableColumn nom_ref;
    @FXML
    private TableColumn prenom_ref;
    @FXML
    private TableColumn email_ref;
    @FXML
    private TableColumn add_ref;
    @FXML
    private Label var ;
    private Button retour ;
public static String vv ="";
    /**
     * Initializes the controller class.
     */
   
    
    
       public void a() {
        view_ref.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
           @Override
           public void handle(javafx.scene.input.MouseEvent event) {
                refuge A = (refuge) view_ref.getItems().get(view_ref.getSelectionModel().getSelectedIndex());
               // id_bannir.setText(String.valueOf((A.getNom())));

            }
        });
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        gest_refuge ref = new gest_refuge();
        
       ArrayList<refuge> refu = (ArrayList<refuge>) ref.displayRefuge();
       ObservableList<refuge> obs = FXCollections.observableArrayList(refu);
       view_ref.setItems(obs);
       nom_ref.setCellValueFactory(new PropertyValueFactory<refuge, String>("nom_r"));
             prenom_ref.setCellValueFactory(new PropertyValueFactory<refuge, String>("prenom_r"));
       email_ref.setCellValueFactory(new PropertyValueFactory<refuge, String>("email_r"));
       add_ref.setCellValueFactory(new PropertyValueFactory<refuge, String>("add_r"));

        try {
            //a();
            contact();
        } catch (IOException ex) {
            Logger.getLogger(FXML_liste_refugeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void contact () throws IOException{
         view_ref.setOnMouseClicked(new EventHandler<MouseEvent>()
         {
             @Override
             public void handle(MouseEvent event){
                //refuge E=view_ref.getItems().get(view_ref.getSelectionModel().getSelectedIndex());
               refuge E=view_ref.getSelectionModel().getSelectedItem();
                       
        
        
                
                var.setText(E.getNom_r());
                
                // System.out.println(E.getNom_r());
                 String s = var.getText();
                       FXML_liste_refugeController.vv = s;


                //prenom_ref.setText(E.getPrenom_r());
              //  email_ref.setText(E.getEmail_r());
               // add_ref.setText(E.getAdd_r());
               
             }
             
                
              
         });
             
    }
                 
//    }
//             public void re(MouseEvent event)throws IOException{
//                Parent root=FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_acceuil1_famille.fxml"));
//        Scene scene = new Scene(root);
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                stage.hide();
//                stage.setScene(scene);
//                stage.show();}  
//            
                
   public void redir (ActionEvent event) throws IOException {
               contact();
                 Parent root=FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_profil_refuge.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();}  
   
    

 public void retour (ActionEvent event) throws IOException {
              
                 Parent root=FXMLLoader.load(getClass().getResource("/fxml/famille_fxml/FXML_acceuil1_famille.fxml"));
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show();}  
   
    
}