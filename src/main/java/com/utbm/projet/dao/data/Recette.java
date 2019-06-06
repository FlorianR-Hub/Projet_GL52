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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(name = "recette")
public class Recette implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_RECETTE")
    private Long numRecette;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM_RECETTE")
    private String nomRecette;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TYPE_RECETTE")
    private String typeRecette;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DESC_RECETTE")
    private String descRecette;

    @ManyToMany(mappedBy = "recetteList")
    private List<Ingredients> ingredientsList;

    @JoinTable(name = "preferer", joinColumns = {
        @JoinColumn(name = "NUM_RECETTE", referencedColumnName = "NUM_RECETTE")}, inverseJoinColumns = {
        @JoinColumn(name = "NUM_UTILISATEUR", referencedColumnName = "NUM_UTILISATEUR")})
    @ManyToMany
    private List<Utilisateur> utilisateurList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recette")
    private List<Etape> etapeList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recette")
    private List<Gerer> gererList;

    public Recette() {
    }

    public Recette(Long numRecette) {
        this.numRecette = numRecette;
    }

    public Recette(Long numRecette, String nomRecette, String typeRecette, String descRecette) {
        this.numRecette = numRecette;
        this.nomRecette = nomRecette;
        this.typeRecette = typeRecette;
        this.descRecette = descRecette;
    }

    public Long getNumRecette() {
        return numRecette;
    }

    public void setNumRecette(Long numRecette) {
        this.numRecette = numRecette;
    }

    public String getNomRecette() {
        return nomRecette;
    }

    public void setNomRecette(String nomRecette) {
        this.nomRecette = nomRecette;
    }

    public String getTypeRecette() {
        return typeRecette;
    }

    public void setTypeRecette(String typeRecette) {
        this.typeRecette = typeRecette;
    }

    public String getDescRecette() {
        return descRecette;
    }

    public void setDescRecette(String descRecette) {
        this.descRecette = descRecette;
    }

    public List<Ingredients> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Ingredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }

    public List<Etape> getEtapeList() {
        return etapeList;
    }

    public void setEtapeList(List<Etape> etapeList) {
        this.etapeList = etapeList;
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
        hash += (numRecette != null ? numRecette.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recette)) {
            return false;
        }
        Recette other = (Recette) object;
        if ((this.numRecette == null && other.numRecette != null) || (this.numRecette != null && !this.numRecette.equals(other.numRecette))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.Recette[ numRecette=" + numRecette + " ]";
    }

}
