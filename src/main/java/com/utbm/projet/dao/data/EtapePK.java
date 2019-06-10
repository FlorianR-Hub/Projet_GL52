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
public class EtapePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_ETAPE")
    private int numEtape;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_RECETTE")
    private long numRecette;

    public EtapePK() {
    }

    public EtapePK(int numEtape, long numRecette) {
        this.numEtape = numEtape;
        this.numRecette = numRecette;
    }

    public int getNumEtape() {
        return numEtape;
    }

    public void setNumEtape(int numEtape) {
        this.numEtape = numEtape;
    }

    public long getNumRecette() {
        return numRecette;
    }

    public void setNumRecette(long numRecette) {
        this.numRecette = numRecette;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numEtape;
        hash += (int) numRecette;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtapePK)) {
            return false;
        }
        EtapePK other = (EtapePK) object;
        if (this.numEtape != other.numEtape) {
            return false;
        }
        if (this.numRecette != other.numRecette) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.EtapePK[ numEtape=" + numEtape + ", numRecette=" + numRecette + " ]";
    }

}
