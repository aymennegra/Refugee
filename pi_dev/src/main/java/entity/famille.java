/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author wadie
 */
public class famille {
    
 private String nom_ff ;
 private String prenom_ff ;
 private String email_ff ;
 private int tel_ff ;
 private String pays_ff ;
 private Date date_n_ff ;
 private String login_ff ;
 private String add_ff ;
 private String mdp_ff ;
 private String quest_ff ;
private String role;
private String domaine_ff;
private String image_ff;

    public String getImage_ff() {
        return image_ff;
    }

    public void setImage_ff(String image_ff) {
        this.image_ff = image_ff;
    }

    public famille(String nom_ff, String prenom_ff, String email_ff, int tel_ff, String pays_ff, String login_ff, String add_ff, String mdp_ff, String quest_ff, String domaine_ff, String role) {
        this.nom_ff = nom_ff;
        this.prenom_ff = prenom_ff;
        this.email_ff = email_ff;
        this.tel_ff = tel_ff;
        this.pays_ff = pays_ff;
        this.login_ff = login_ff;
        this.add_ff = add_ff;
        this.mdp_ff = mdp_ff;
        this.quest_ff = quest_ff;
        this.role = role;
        
        this.domaine_ff = domaine_ff;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDomaine_ff(String domaine_ff) {
        this.domaine_ff = domaine_ff;
    }

    public String getRole() {
        return role;
    }

    public String getDomaine_ff() {
        return domaine_ff;
    }
    public famille() {
    }

    public String getNom_ff() {
        return nom_ff;
    }

    public String getPrenom_ff() {
        return prenom_ff;
    }

    public String getEmail_ff() {
        return email_ff;
    }

    public int getTel_ff() {
        return tel_ff;
    }

    public String getPays_ff() {
        return pays_ff;
    }

    public Date getDate_n_ff() {
        return date_n_ff;
    }

    public String getLogin_ff() {
        return login_ff;
    }

    public String getAdd_ff() {
        return add_ff;
    }

    public String getMdp_ff() {
        return mdp_ff;
    }

    public String getQuest_ff() {
        return quest_ff;
    }

    public void setNom_ff(String nom_ff) {
        this.nom_ff = nom_ff;
    }

    public void setPrenom_ff(String prenom_ff) {
        this.prenom_ff = prenom_ff;
    }

    public void setEmail_ff(String email_ff) {
        this.email_ff = email_ff;
    }

    public void setTel_ff(int tel_ff) {
        this.tel_ff = tel_ff;
    }

    public void setPays_ff(String pays_ff) {
        this.pays_ff = pays_ff;
    }

    public void setDate_n_ff(Date date_n_ff) {
        this.date_n_ff = date_n_ff;
    }

    public void setLogin_ff(String login_ff) {
        this.login_ff = login_ff;
    }

    public void setAdd_ff(String add_ff) {
        this.add_ff = add_ff;
    }

    public void setMdp_ff(String mdp_ff) {
        this.mdp_ff = mdp_ff;
    }

    public void setQuest_ff(String quest_ff) {
        this.quest_ff = quest_ff;
    }

    public famille(String nom_ff, String prenom_ff, String email_ff, int tel_ff, String pays_ff, String login_ff, String add_ff, String mdp_ff, String quest_ff,String role) {
        this.nom_ff = nom_ff;
        this.prenom_ff = prenom_ff;
        this.email_ff = email_ff;
        this.tel_ff = tel_ff;
        this.pays_ff = pays_ff;
        this.login_ff = login_ff;
        this.add_ff = add_ff;
        this.mdp_ff = mdp_ff;
        this.quest_ff = quest_ff;
        this.role=role;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nom_ff);
        hash = 29 * hash + Objects.hashCode(this.prenom_ff);
        hash = 29 * hash + Objects.hashCode(this.email_ff);
        hash = 29 * hash + this.tel_ff;
        hash = 29 * hash + Objects.hashCode(this.pays_ff);
        hash = 29 * hash + Objects.hashCode(this.date_n_ff);
        hash = 29 * hash + Objects.hashCode(this.login_ff);
        hash = 29 * hash + Objects.hashCode(this.add_ff);
        hash = 29 * hash + Objects.hashCode(this.mdp_ff);
        hash = 29 * hash + Objects.hashCode(this.quest_ff);
        return hash;
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
        final famille other = (famille) obj;
        if (this.tel_ff != other.tel_ff) {
            return false;
        }
        if (!Objects.equals(this.nom_ff, other.nom_ff)) {
            return false;
        }
        if (!Objects.equals(this.prenom_ff, other.prenom_ff)) {
            return false;
        }
        if (!Objects.equals(this.email_ff, other.email_ff)) {
            return false;
        }
        if (!Objects.equals(this.pays_ff, other.pays_ff)) {
            return false;
        }
        if (!Objects.equals(this.login_ff, other.login_ff)) {
            return false;
        }
        if (!Objects.equals(this.add_ff, other.add_ff)) {
            return false;
        }
        if (!Objects.equals(this.mdp_ff, other.mdp_ff)) {
            return false;
        }
        if (!Objects.equals(this.quest_ff, other.quest_ff)) {
            return false;
        }
        if (!Objects.equals(this.date_n_ff, other.date_n_ff)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "famille{" + "nom_ff=" + nom_ff + ", prenom_ff=" + prenom_ff + ", email_ff=" + email_ff + ", tel_ff=" + tel_ff + ", pays_ff=" + pays_ff + ", date_n_ff=" + date_n_ff + ", login_ff=" + login_ff + ", add_ff=" + add_ff + ", mdp_ff=" + mdp_ff + ", quest_ff=" + quest_ff + '}';
    }

    public String getdomaine_ff() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
    
 
    
}
