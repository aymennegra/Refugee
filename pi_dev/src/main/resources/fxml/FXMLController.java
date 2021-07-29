///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fxml;
//
//
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Date;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javax.swing.JOptionPane;
//import service.ajout;
//
///**
// * FXML Controller class
// *
// * @author wadie
// */
//public class FXMLController implements Initializable {
//
//    @FXML
//    private Button bu;
//     @FXML
//    private Button actu;
//    @FXML
//    private TextField tx;
//    
//    private Button sup;
//     private DatePicker date_n;
//    
//     @FXML
//   // private TableColumn<refuge, String> nom2;
//  
//   // @FXML
//    private TableView view;
//}
//    /**
//     * Initializes the controller class.
//     */
//     public void initialize(URL url, ResourceBundle rb) {}
//    
////       public void a() {
////        view.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
////           @Override
////           public void handle(javafx.scene.input.MouseEvent event) {
////                refugee A = (refugee) view.getItems().get(view.getSelectionModel().getSelectedIndex());
////               // id_bannir.setText(String.valueOf((A.getNom())));
////
////            }
////        });
////    }
////    
////    
//   // @Override
////    public void initialize(URL url, ResourceBundle rb) {
////        
////           ajout p = new ajout();
////       ArrayList<refuge> pers = (ArrayList<refuge>) p.displayPersonne();
////       ObservableList<refugee> obs = FXCollections.observableArrayList(pers);
////       view.setItems(obs);
////       nom2.setCellValueFactory(new PropertyValueFactory<refugee, String>("nom"));
////      
////        a();
////
////         TODO
////    }    
//    
////        @FXML
////     void ActualiserAction(ActionEvent event) {
////        ajout p = new ajout();
////        ArrayList<refugee> ref = (ArrayList<refugee>) p.displayPersonne();
////        ObservableList<refugee> obs = FXCollections.observableArrayList(ref);
////        view.getItems().clear();
////        view.setItems(obs);
////        nom2.setCellValueFactory(new PropertyValueFactory<refugee, String>("nom"));
////       
////    }
//    
//    
//   public void handleBu(ActionEvent event) throws IOException {
//
//       
//     
//        
//          LocalDate locald = date_n.getValue();
//     Date date1 = Date.valueOf(locald);
//      
//        String nom1 = tx.getText();
//       
//        ajout s = new ajout();
//
//        refugee r = new refugee(nom1,date1);
//
//        s.ajouterRefugee1(r);
//        
//        
////        ArrayList<refugee> ref = (ArrayList<refugee>) s.displayPersonne();
////        ObservableList<refugee> obs = FXCollections.observableArrayList(ref);
////        view.getItems().clear();
////        view.setItems(obs);
////        nom2.setCellValueFactory(new PropertyValueFactory<refugee, String>("nom"));
//        
//        JOptionPane.showMessageDialog(null, "succée"); 
//        
//        
//    
//     }
//   public void sup1(ActionEvent event) throws IOException {
//
//        String nom12 = tx.getText();
//       
//        ajout s = new ajout();
//
//        refugee r = new refugee(nom12);
//
//        s.sup(r.getNom());
//        
//        
//        ArrayList<refugee> ref = (ArrayList<refugee>) s.displayPersonne();
//        ObservableList<refugee> obs = FXCollections.observableArrayList(ref);
//        view.getItems().clear();
//        view.setItems(obs);
//        nom2.setCellValueFactory(new PropertyValueFactory<refugee, String>("nom"));
//        
//        
//        JOptionPane.showMessageDialog(null, "succée"); 
//    
//     }
//}
