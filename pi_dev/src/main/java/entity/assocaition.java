/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author wadie
 */
public class assocaition {
    
    
    private int id_a ;
    private  String nom_a;
    private String prenom;
    private String domaine_a ;
    private String pays_a ;
    private int fax_a ;
    private String add_a ;
    private String email_a ;
    private String type_a ;
    private String mdp_a;
 private String login_a;
 private String role_a;
 private String quest;

    public void setRole_a(String role_a) {
        this.role_a = role_a;
    }

    public String getRole_a() {
        return role_a;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getQuest() {
        return quest;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public assocaition(String nom_a ,String prenom, String email_a, int fax_a, String pays_a , String login_a, String add_a, String mdp_a,String quest, String domaine_a, String role_a) {
        this.nom_a = nom_a;
        this.prenom=prenom;
        this.quest=quest;
        this.domaine_a = domaine_a;
        this.pays_a = pays_a;
        this.fax_a = fax_a;
        this.add_a = add_a;
        this.email_a = email_a;
        this.mdp_a = mdp_a;
        this.login_a = login_a;
        this.role_a = role_a;
    }
    public assocaition( String nom_a, String domaine_a, String pays_a, int fax_a, String add_a, String email_a,String login_a,String mdp_a) {
        this.nom_a = nom_a;
        this.domaine_a = domaine_a;
        this.pays_a = pays_a;
        this.fax_a = fax_a;
        this.add_a = add_a;
        this.email_a = email_a;
        this.login_a=login_a;
        this.mdp_a=mdp_a;
    }

    public void setMdp_a(String mdp_a) {
        this.mdp_a = mdp_a;
    }

    public void setLogin_a(String login_a) {
        this.login_a = login_a;
    }

    public String getMdp_a() {
        return mdp_a;
    }

    public String getLogin_a() {
        return login_a;
    }

    public int getId_a() {
        return id_a;
    }

    public String getNom_a() {
        return nom_a;
    }

    public String getDomaine_a() {
        return domaine_a;
    }

    public String getPays_a() {
        return pays_a;
    }

    public int getFax_a() {
        return fax_a;
    }

    public String getAdd_a() {
        return add_a;
    }

    public String getEmail_a() {
        return email_a;
    }

    public String getType_a() {
        return type_a;
    }

    public void setId_a(int id_a) {
        this.id_a = id_a;
    }

    public void setNom_a(String nom_a) {
        this.nom_a = nom_a;
    }

    public void setDomaine_a(String domaine_a) {
        this.domaine_a = domaine_a;
    }

    public void setPays_a(String pays_a) {
        this.pays_a = pays_a;
    }

    public void setFax_a(int fax_a) {
        this.fax_a = fax_a;
    }

    public void setAdd_a(String add_a) {
        this.add_a = add_a;
    }

    public void setEmail_a(String email_a) {
        this.email_a = email_a;
    }

    public void setType_a(String type_a) {
        this.type_a = type_a;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final assocaition other = (assocaition) obj;
        if (this.id_a != other.id_a) {
            return false;
        }
        if (this.fax_a != other.fax_a) {
            return false;
        }
        if (!Objects.equals(this.nom_a, other.nom_a)) {
            return false;
        }
        if (!Objects.equals(this.domaine_a, other.domaine_a)) {
            return false;
        }
        if (!Objects.equals(this.pays_a, other.pays_a)) {
            return false;
        }
        if (!Objects.equals(this.add_a, other.add_a)) {
            return false;
        }
        if (!Objects.equals(this.email_a, other.email_a)) {
            return false;
        }
        if (!Objects.equals(this.type_a, other.type_a)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
