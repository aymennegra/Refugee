/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Connexion.Myconnection;
import entity.famille;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entity.assocaition;

/**
 *
 * @author wadie
 */
public class gest_assocation {
    
 
     Myconnection myc = Myconnection.getIstance();
    Connection cnx = myc.getConnection();
    
    
    
   
    
     public void ajouterAssociation(assocaition asso) {
         String requete = "INSERT INTO ajout_famille (nom_db,prenom_db,email_db,tel_db,pays_db,login_db,add_db,mdp_db,quest_db,domaine_db,role_db) VALUES (?,?,?,?  , ?,? ,?,?,?,   ?,?)";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
          
            
              pst.setString(1, asso.getNom_a());
            pst.setString(2, asso.getPrenom());
           
            pst.setString(3, asso.getEmail_a());
             pst.setInt(4, asso.getFax_a());
             pst.setString(5, asso.getPays_a());

            pst.setString(6, asso.getLogin_a());
            pst.setString(7, asso.getAdd_a());

            pst.setString(8, asso.getMdp_a());
            pst.setString(9, asso.getQuest());
            pst.setString(10, asso.getDomaine_a());
            pst.setString(11, asso.getRole_a());
            
            
            
            pst.executeUpdate();
            System.out.println("Ajout Complete");
        } catch (SQLException ex) {
            System.out.println("erreur d'insertion");
            System.out.println(ex.getMessage());

        }
     }}
