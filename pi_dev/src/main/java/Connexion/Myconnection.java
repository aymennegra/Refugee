/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wadie
 */
public class Myconnection {
    
    public String url="jdbc:mysql://localhost:3306/pi_dev";
    public String login="root";
    public String pwd="";
    public static Connection cnx;
    public static Myconnection myc;
    
    private Myconnection(){
        try {
            cnx=DriverManager.getConnection(url,login,pwd);
            System.out.println("connecton etablie"+url);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("connection non etablie");        
        }
    }
    ////design pattern singleton
     public static Connection getConnection(){
     return cnx;
     }
    
    
    public static Myconnection getIstance(){
    if (myc==null){
    myc=new Myconnection();
    }
    return myc;
    }
}
