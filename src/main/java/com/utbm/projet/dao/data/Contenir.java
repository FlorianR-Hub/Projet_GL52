/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "contenir")
@NamedQueries({
    @NamedQuery(name = "Contenir.findAll", query = "SELECT c FROM Contenir c")})
public class Contenir implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContenirPK contenirPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITE")
    private int quantite;
    @Size(max = 5)
    @Column(name = "UNITE")
    private String unite;
    @JoinColumn(name = "NUM_INGREDIENT", referencedColumnName = "NUM_INGREDIENT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingredients ingredients;
    @JoinColumn(name = "NUM_RECETTE", referencedColumnName = "NUM_RECETTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Recette recette;

    public Contenir() {
    }

    public Contenir(ContenirPK contenirPK) {
        this.contenirPK = contenirPK;
    }

    public Contenir(ContenirPK contenirPK, int quantite) {
        this.contenirPK = contenirPK;
        this.quantite = quantite;
    }

    public Contenir(long numRecette, long numIngredient) {
        this.contenirPK = new ContenirPK(numRecette, numIngredient);
    }

    public ContenirPK getContenirPK() {
        return contenirPK;
    }

    public void setContenirPK(ContenirPK contenirPK) {
        this.contenirPK = contenirPK;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public Recette getRecette() {
        return recette;
    }

    public void setRecette(Recette recette) {
        this.recette = recette;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contenirPK != null ? contenirPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contenir)) {
            return false;
        }
        Contenir other = (Contenir) object;
        if ((this.contenirPK == null && other.contenirPK != null) || (this.contenirPK != null && !this.contenirPK.equals(other.contenirPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.Contenir[ contenirPK=" + contenirPK + " ]";
    }

}
