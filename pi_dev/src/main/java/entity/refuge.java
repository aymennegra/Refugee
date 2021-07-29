/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.util.logging.Logger;

/**
 *
 * @author wadie
 */
public class refuge {
    private String nom_r ;
 private String prenom_r ;
 private String email_r ;
 private int tel_r ;
 private String pays_r ;
 //private Date date_n_ff ;
 private String login_r ;
 private String add_r ;
 private String mdp_r ;
 private String quest_r ;
private String role;
private String domaine_r;
private String image_r;

    public void setImage_r(String image_r) {
        this.image_r = image_r;
    }

    public String getImage_r() {
        return image_r;
    }
    public refuge() {
    }

    public void setNom_r(String nom_r) {
        this.nom_r = nom_r;
    }

    public void setPrenom_r(String prenom_r) {
        this.prenom_r = prenom_r;
    }

    public void setEmail_r(String email_r) {
        this.email_r = email_r;
    }

    public void setTel_r(int tel_r) {
        this.tel_r = tel_r;
    }

    public void setPays_r(String pays_r) {
        this.pays_r = pays_r;
    }

    public void setLogin_r(String login_r) {
        this.login_r = login_r;
    }

    public void setAdd_r(String add_r) {
        this.add_r = add_r;
    }

    public void setMdp_r(String mdp_r) {
        this.mdp_r = mdp_r;
    }

    public void setQuest_r(String quest_r) {
        this.quest_r = quest_r;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDomaine_r(String domaine_r) {
        this.domaine_r = domaine_r;
    }

    public String getNom_r() {
        return nom_r;
    }

    public String getPrenom_r() {
        return prenom_r;
    }

    public String getEmail_r() {
        return email_r;
    }

    public int getTel_r() {
        return tel_r;
    }

    public String getPays_r() {
        return pays_r;
    }

    public String getLogin_r() {
        return login_r;
    }

    public String getAdd_r() {
        return add_r;
    }

    public String getMdp_r() {
        return mdp_r;
    }

    public String getQuest_r() {
        return quest_r;
    }

    public String getRole() {
        return role;
    }

    public refuge(String nom_r, String prenom_r, String email_r, int tel_r, String pays_r, String login_r, String add_r, String mdp_r, String quest_r, String domaine_r, String role) {
        this.nom_r = nom_r;
        this.prenom_r = prenom_r;
        this.email_r = email_r;
        this.tel_r = tel_r;
        this.pays_r = pays_r;
        this.login_r = login_r;
        this.add_r = add_r;
        this.mdp_r = mdp_r;
        this.quest_r = quest_r;
        this.role = role;
        this.domaine_r = domaine_r;
    }

    public String getDomaine_r() {
        return domaine_r;
    }

}
