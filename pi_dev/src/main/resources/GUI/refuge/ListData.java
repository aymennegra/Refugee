/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refuge;

import refuge.entities.Refugee;
import crud.Refcrud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Houssem
 */
public class ListData {
    
     
    private ObservableList<Refugee> users=FXCollections.observableArrayList();

    public ListData() {
        
        Refcrud udao=Refcrud.getInstance();
        users= udao.displayAll();
        
    }
    
    public ObservableList<Refugee> getUsers(){
        return users;
    }
    
}
