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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(name = "nutritionniste")
public class Nutritionniste implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_NUTRITIONNISTE")
    private Long numNutritionniste;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PRENOM_NUTRITIONNISTE")
    private String prenomNutritionniste;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM_NUTRITIONNISTE")
    private String nomNutritionniste;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COURRIEL_NUTRITIONNISTE")
    private String courrielNutritionniste;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MDP_NUTRITIONNISTE")
    private String mdpNutritionniste;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "DESCRIPTION_NUTRITIONNISTE")
    private String descriptionNutritionniste;

    @OneToMany(mappedBy = "nutritionniste")
    private List<Utilisateur> utilisateurList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nutritionniste")
    private List<Gerer> gererList;

    public Nutritionniste() {
    }

    public Nutritionniste(Long numNutritionniste) {
        this.numNutritionniste = numNutritionniste;
    }

    public Nutritionniste(Long numNutritionniste, String prenomNutritionniste, String nomNutritionniste, String courrielNutritionniste, String mdtpNutritionniste, String descriptionNutritionniste) {
        this.numNutritionniste = numNutritionniste;
        this.prenomNutritionniste = prenomNutritionniste;
        this.nomNutritionniste = nomNutritionniste;
        this.courrielNutritionniste = courrielNutritionniste;
        this.mdpNutritionniste = mdtpNutritionniste;
        this.descriptionNutritionniste = descriptionNutritionniste;
    }

    public Long getNumNutritionniste() {
        return numNutritionniste;
    }

    public void setNumNutritionniste(Long numNutritionniste) {
        this.numNutritionniste = numNutritionniste;
    }

    public String getPrenomNutritionniste() {
        return prenomNutritionniste;
    }

    public void setPrenomNutritionniste(String prenomNutritionniste) {
        this.prenomNutritionniste = prenomNutritionniste;
    }

    public String getNomNutritionniste() {
        return nomNutritionniste;
    }

    public void setNomNutritionniste(String nomNutritionniste) {
        this.nomNutritionniste = nomNutritionniste;
    }

    public String getCourrielNutritionniste() {
        return courrielNutritionniste;
    }

    public void setCourrielNutritionniste(String courrielNutritionniste) {
        this.courrielNutritionniste = courrielNutritionniste;
    }

    public String getMdpNutritionniste() {
        return mdpNutritionniste;
    }

    public void setMdpNutritionniste(String mdpNutritionniste) {
        this.mdpNutritionniste = mdpNutritionniste;
    }

    public String getDescriptionNutritionniste() {
        return descriptionNutritionniste;
    }

    public void setDescriptionNutritionniste(String descriptionNutritionniste) {
        this.descriptionNutritionniste = descriptionNutritionniste;
    }

    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }

    public List<Gerer> getGererList() {
        return gererList;
    }

    public void setGererList(List<Gerer> gererList) {
        this.gererList = gererList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numNutritionniste != null ? numNutritionniste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nutritionniste)) {
            return false;
        }
        Nutritionniste other = (Nutritionniste) object;
        if ((this.numNutritionniste == null && other.numNutritionniste != null) || (this.numNutritionniste != null && !this.numNutritionniste.equals(other.numNutritionniste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.Nutritionniste[ numNutritionniste=" + numNutritionniste + " ]";
    }

}
