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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(name = "ingredients")
public class Ingredients implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_INGREDIENT")
    private Long numIngredient;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOM_INGREDIENT")
    private String nomIngredient;

    @ManyToMany(mappedBy = "ingredientsList")
    private List<Fournisseur> fournisseurList;

    @JoinTable(name = "contenir", joinColumns = {
        @JoinColumn(name = "NUM_INGREDIENT", referencedColumnName = "NUM_INGREDIENT")}, inverseJoinColumns = {
        @JoinColumn(name = "NUM_RECETTE", referencedColumnName = "NUM_RECETTE")})
    @ManyToMany
    private List<Recette> recetteList;

    public Ingredients() {
    }

    public Ingredients(Long numIngredient) {
        this.numIngredient = numIngredient;
    }

    public Ingredients(Long numIngredient, String nomIngredient) {
        this.numIngredient = numIngredient;
        this.nomIngredient = nomIngredient;
    }

    public Long getNumIngredient() {
        return numIngredient;
    }

    public void setNumIngredient(Long numIngredient) {
        this.numIngredient = numIngredient;
    }

    public String getNomIngredient() {
        return nomIngredient;
    }

    public void setNomIngredient(String nomIngredient) {
        this.nomIngredient = nomIngredient;
    }

    public List<Fournisseur> getFournisseurList() {
        return fournisseurList;
    }

    public void setFournisseurList(List<Fournisseur> fournisseurList) {
        this.fournisseurList = fournisseurList;
    }

    public List<Recette> getRecetteList() {
        return recetteList;
    }

    public void setRecetteList(List<Recette> recetteList) {
        this.recetteList = recetteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numIngredient != null ? numIngredient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredients)) {
            return false;
        }
        Ingredients other = (Ingredients) object;
        if ((this.numIngredient == null && other.numIngredient != null) || (this.numIngredient != null && !this.numIngredient.equals(other.numIngredient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.Ingredients[ numIngredient=" + numIngredient + " ]";
    }

}
