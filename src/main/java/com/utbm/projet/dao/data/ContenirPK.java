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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author flori
 */
@Embeddable
public class ContenirPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_RECETTE")
    private long numRecette;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_INGREDIENT")
    private long numIngredient;

    public ContenirPK() {
    }

    public ContenirPK(long numRecette, long numIngredient) {
        this.numRecette = numRecette;
        this.numIngredient = numIngredient;
    }

    public long getNumRecette() {
        return numRecette;
    }

    public void setNumRecette(long numRecette) {
        this.numRecette = numRecette;
    }

    public long getNumIngredient() {
        return numIngredient;
    }

    public void setNumIngredient(long numIngredient) {
        this.numIngredient = numIngredient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numRecette;
        hash += (int) numIngredient;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContenirPK)) {
            return false;
        }
        ContenirPK other = (ContenirPK) object;
        if (this.numRecette != other.numRecette) {
            return false;
        }
        if (this.numIngredient != other.numIngredient) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.ContenirPK[ numRecette=" + numRecette + ", numIngredient=" + numIngredient + " ]";
    }

}
