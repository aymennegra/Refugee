/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.util.Objects;


/**
 *
 * @author wadie
 */
public class livraison {
    
    
    private String nom_liv ;
    private String prenom_liv ;
 private String email_liv ;
 private int tel_liv ;
 private String pays_liv ;
 private String login_liv ;
 private String add_liv ;
 private String mdp_liv ;
 private String quest_liv ;
private String role;
private String domaine_liv;
private String image_liv;    


private Date date_dipo_debut;
private Date date_dispo_fin;

    public livraison( Date date_dipo_debut, Date date_dispo_fin,String nom_liv) {
        this.nom_liv = nom_liv;
        this.date_dipo_debut = date_dipo_debut;
        this.date_dispo_fin = date_dispo_fin;
    }

    public void setDate_dipo_debut(Date date_dipo_debut) {
        this.date_dipo_debut = date_dipo_debut;
    }

    public void setDate_dispo_fin(Date date_dispo_fin) {
        this.date_dispo_fin = date_dispo_fin;
    }

    public Date getDate_dipo_debut() {
        return date_dipo_debut;
    }

    public Date getDate_dispo_fin() {
        return date_dispo_fin;
    }


private String nom_mission;
private String description_mission;
private Date date_mission;

    public livraison( String nom_mission, String description_mission, Date date_mission,String nom_liv) {
        this.nom_liv = nom_liv;
        this.nom_mission = nom_mission;
        this.description_mission = description_mission;
        this.date_mission = date_mission;
    }

    public livraison() {
    }

    public void setNom_liv(String nom_liv) {
        this.nom_liv = nom_liv;
    }

    public void setNom_mission(String nom_mission) {
        this.nom_mission = nom_mission;
    }

    public void setDescription_mission(String description_mission) {
        this.description_mission = description_mission;
    }

    public void setDate_mission(Date date_mission) {
        this.date_mission = date_mission;
    }

    public String getNom_mission() {
        return nom_mission;
    }

    public String getDescription_mission() {
        return description_mission;
    }

    public Date getDate_mission() {
        return date_mission;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public livraison(String nom_liv, String prenom_liv, String email_liv, int tel_liv, String pays_liv, String login_liv, String add_liv, String mdp_liv, String quest_liv, String domaine_liv, String role) {
        this.nom_liv = nom_liv;
        this.prenom_liv = prenom_liv;
        this.email_liv = email_liv;
        this.tel_liv = tel_liv;
        this.pays_liv = pays_liv;
        this.login_liv = login_liv;
        this.add_liv = add_liv;
        this.mdp_liv = mdp_liv;
        this.quest_liv = quest_liv;
        this.role = role;
        this.domaine_liv = domaine_liv;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final livraison other = (livraison) obj;
        if (this.tel_liv != other.tel_liv) {
            return false;
        }
        if (!Objects.equals(this.nom_liv, other.nom_liv)) {
            return false;
        }
        if (!Objects.equals(this.prenom_liv, other.prenom_liv)) {
            return false;
        }
        if (!Objects.equals(this.email_liv, other.email_liv)) {
            return false;
        }
        if (!Objects.equals(this.pays_liv, other.pays_liv)) {
            return false;
        }
        if (!Objects.equals(this.login_liv, other.login_liv)) {
            return false;
        }
        if (!Objects.equals(this.add_liv, other.add_liv)) {
            return false;
        }
        if (!Objects.equals(this.mdp_liv, other.mdp_liv)) {
            return false;
        }
        if (!Objects.equals(this.quest_liv, other.quest_liv)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        if (!Objects.equals(this.domaine_liv, other.domaine_liv)) {
            return false;
        }
        if (!Objects.equals(this.image_liv, other.image_liv)) {
            return false;
        }
        return true;
    }

    public void setNon_liv(String non_liv) {
        this.nom_liv = non_liv;
    }

    public void setPrenom_liv(String prenom_liv) {
        this.prenom_liv = prenom_liv;
    }

    public void setEmail_liv(String email_liv) {
        this.email_liv = email_liv;
    }

    public void setTel_liv(int tel_liv) {
        this.tel_liv = tel_liv;
    }

    public void setPays_liv(String pays_liv) {
        this.pays_liv = pays_liv;
    }

    public void setLogin_liv(String login_liv) {
        this.login_liv = login_liv;
    }

    public void setAdd_liv(String add_liv) {
        this.add_liv = add_liv;
    }

    public void setMdp_liv(String mdp_liv) {
        this.mdp_liv = mdp_liv;
    }

    public void setQuest_liv(String quest_liv) {
        this.quest_liv = quest_liv;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDomaine_liv(String domaine_liv) {
        this.domaine_liv = domaine_liv;
    }

    public void setImage_liv(String image_liv) {
        this.image_liv = image_liv;
    }

    public String getNom_liv() {
        return nom_liv;
    }

    public String getPrenom_liv() {
        return prenom_liv;
    }

    public String getEmail_liv() {
        return email_liv;
    }

    public int getTel_liv() {
        return tel_liv;
    }

    public String getPays_liv() {
        return pays_liv;
    }

    public String getLogin_liv() {
        return login_liv;
    }

    public String getAdd_liv() {
        return add_liv;
    }

    public String getMdp_liv() {
        return mdp_liv;
    }

    public String getQuest_liv() {
        return quest_liv;
    }

    public String getRole() {
        return role;
    }

    public String getDomaine_liv() {
        return domaine_liv;
    }

    public String getImage_liv() {
        return image_liv;
    }



}



