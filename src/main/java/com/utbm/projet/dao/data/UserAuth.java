/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author flori
 */
@Entity
@Table(name = "user_auth")
@NamedQueries({
    @NamedQuery(name = "UserAuth.findAll", query = "SELECT u FROM UserAuth u")})
public class UserAuth implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PSEUDO")
    private String pseudo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MDP")
    private String mdp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOUNT_TYPE")
    private short accountType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<Administrateur> administrateurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<Utilisateur> utilisateurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<Nutritionniste> nutritionnisteList;

    public UserAuth() {
    }

    public UserAuth(Long id) {
        this.id = id;
    }

    public UserAuth(Long id, String pseudo, String mdp, short accountType) {
        this.id = id;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.accountType = accountType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public short getAccountType() {
        return accountType;
    }

    public void setAccountType(short accountType) {
        this.accountType = accountType;
    }

    public List<Administrateur> getAdministrateurList() {
        return administrateurList;
    }

    public void setAdministrateurList(List<Administrateur> administrateurList) {
        this.administrateurList = administrateurList;
    }

    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }

    public List<Nutritionniste> getNutritionnisteList() {
        return nutritionnisteList;
    }

    public void setNutritionnisteList(List<Nutritionniste> nutritionnisteList) {
        this.nutritionnisteList = nutritionnisteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAuth)) {
            return false;
        }
        UserAuth other = (UserAuth) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.UserAuth[ id=" + id + " ]";
    }

}
