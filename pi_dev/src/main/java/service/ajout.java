//package service;
//
//import Connexion.Myconnection;
////import static Connexion.Myconnection.cnx;
//import entity.refugee;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.scene.image.Image;
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author wadie
// */
//public class ajout {
//    
//       Myconnection myc = Myconnection.getIstance();
//    Connection cnx = myc.getConnection();
//    
//     public void ajouterRefugee(refugee ref) {
//         String requete = "INSERT INTO refugee (nom,prenom,sexe,email,d_naissance,login_p,password_p,num_tel) VALUES (?,?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement pst = cnx.prepareStatement(requete);
//            pst.setString(1, ref.getNom());
//            pst.setString(2, ref.getPrenom());
//           // pst.setInt(3, ref.getCin());
//            pst.setString(3, ref.getSexe());
//            pst.setString(4, ref.getEmail());
//            pst.setString(5, ref.getD_naissance());
//          //  pst.setString(6, ref.getVille());
//            pst.setString(6, ref.getLogin_p());
//            pst.setString(7, ref.getPassword_p());
//                         pst.setString(8, ref.getNum_tel());
//                         
//
//           
//
//            
//           // pst.setString(11, "user");
//          //  pst.setString(12, "valid");
//
//            pst.executeUpdate();
//            System.out.println("Bien");
//        } catch (SQLException ex) {
//            System.out.println("erreur");
//            System.out.println(ex.getMessage());
//
//        }
//    }
//     
//     
//      public void ajouterRefugee1(refugee ref1) {
//         String requete = "INSERT INTO refugee1 (nom , date) VALUES (?,?)";
//        try {
//            PreparedStatement pst = cnx.prepareStatement(requete);
//            pst.setString(1, ref1.getNom());
//          pst.setDate(2,(Date) ref1.getDate());
//
//            
//           // pst.setString(11, "user");
//          //  pst.setString(12, "valid");
//
//            pst.executeUpdate();
//            System.out.println("Ajout Complete");
//        } catch (SQLException ex) {
//            System.out.println("erreur d'insertion");
//            System.out.println(ex.getMessage());
//
//        }
//        
//    }
//      
//
//      
//       public void up(String nom) {
//         String requete = "UPDATE refugee1 SET nom=?";
//        try {
//            PreparedStatement pst = cnx.prepareStatement(requete);
//            pst.setString(1, nom);
//            pst.executeUpdate();
//            System.out.println("app Complete");
//        } catch (SQLException ex) {
//            System.out.println("erreur d'insertion");
//            System.out.println(ex.getMessage());
//
//        }
//    }
//      
//       
//       
//      
//      
//      
//            public void sup(String nom) {
//         String requete = "delete from refugee1  WHERE nom=?";
//        try {
//            PreparedStatement pst = cnx.prepareStatement(requete);
//            pst.setString(1, nom);
//            pst.executeUpdate();
//            System.out.println("supp Complete");
//        } catch (SQLException ex) {
//            System.out.println("erreur d'insertion");
//            System.out.println(ex.getMessage());
//
//        }
//    }
//            
//            
//       
//            
//            
//               public List<refugee> displayPersonne() {
//        List<refugee> myList = new ArrayList<>();
//
//        try {
//            String requete = "select * from refugee1";
//            Statement st = (Statement) cnx.createStatement();
//            ResultSet rs = st.executeQuery(requete);
//
//            while (rs.next()) {
//                refugee p = new refugee();
//               // p.setId_p(rs.getInt("id_p"));
//                p.setNom(rs.getString("nom"));
//               
//
//                myList.add(p);
//
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return myList;
//    }
//
//
//}
