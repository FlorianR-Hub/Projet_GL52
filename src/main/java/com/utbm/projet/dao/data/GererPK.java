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
 */
@Embeddable
public class GererPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_ADMIN")
    private int numAdmin;

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_RECETTE")
    private long numRecette;

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_NUTRITIONNISTE")
    private long numNutritionniste;

    public GererPK() {
    }

    public GererPK(int numAdmin, long numRecette, long numNutritionniste) {
        this.numAdmin = numAdmin;
        this.numRecette = numRecette;
        this.numNutritionniste = numNutritionniste;
    }

    public int getNumAdmin() {
        return numAdmin;
    }

    public void setNumAdmin(int numAdmin) {
        this.numAdmin = numAdmin;
    }

    public long getNumRecette() {
        return numRecette;
    }

    public void setNumRecette(long numRecette) {
        this.numRecette = numRecette;
    }

    public long getNumNutritionniste() {
        return numNutritionniste;
    }

    public void setNumNutritionniste(long numNutritionniste) {
        this.numNutritionniste = numNutritionniste;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numAdmin;
        hash += (int) numRecette;
        hash += (int) numNutritionniste;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GererPK)) {
            return false;
        }
        GererPK other = (GererPK) object;
        if (this.numAdmin != other.numAdmin) {
            return false;
        }
        if (this.numRecette != other.numRecette) {
            return false;
        }
        if (this.numNutritionniste != other.numNutritionniste) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.GererPK[ numAdmin=" + numAdmin + ", numRecette=" + numRecette + ", numNutritionniste=" + numNutritionniste + " ]";
    }

}
