/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;




import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author wadie
 */
public class appli extends Application{
   
    
     @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/livraison_fxml/FXML_mission_livraison.fxml"));
        
        
        
        
        
        
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("Accueil cactus");
        stage.setScene(scene);
        stage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
}
