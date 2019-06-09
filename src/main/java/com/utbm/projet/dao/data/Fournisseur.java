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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author flori
 */
@Entity
@Table(name = "fournisseur")
@NamedQueries({
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f")})
public class Fournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_FOURNISSEUR")
    private Long numFournisseur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOM_FOURNISSEUR")
    private String nomFournisseur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "ADRESSE_FOURNISSEUR")
    private String adresseFournisseur;
    @JoinTable(name = "fournir", joinColumns = {
        @JoinColumn(name = "NUM_FOURNISSEUR", referencedColumnName = "NUM_FOURNISSEUR")}, inverseJoinColumns = {
        @JoinColumn(name = "NUM_INGREDIENT", referencedColumnName = "NUM_INGREDIENT")})
    @ManyToMany
    private List<Ingredients> ingredientsList;

    public Fournisseur() {
    }

    public Fournisseur(Long numFournisseur) {
        this.numFournisseur = numFournisseur;
    }

    public Fournisseur(Long numFournisseur, String nomFournisseur, String adresseFournisseur) {
        this.numFournisseur = numFournisseur;
        this.nomFournisseur = nomFournisseur;
        this.adresseFournisseur = adresseFournisseur;
    }

    public Long getNumFournisseur() {
        return numFournisseur;
    }

    public void setNumFournisseur(Long numFournisseur) {
        this.numFournisseur = numFournisseur;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getAdresseFournisseur() {
        return adresseFournisseur;
    }

    public void setAdresseFournisseur(String adresseFournisseur) {
        this.adresseFournisseur = adresseFournisseur;
    }

    public List<Ingredients> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Ingredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numFournisseur != null ? numFournisseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.numFournisseur == null && other.numFournisseur != null) || (this.numFournisseur != null && !this.numFournisseur.equals(other.numFournisseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.Fournisseur[ numFournisseur=" + numFournisseur + " ]";
    }

}
