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
@Table(name = "etape")
@NamedQueries({
    @NamedQuery(name = "Etape.findAll", query = "SELECT e FROM Etape e")})
public class Etape implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected EtapePK etapePK;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "INSTRUCTION_ETAPE")
    private String instructionEtape;

    @JoinColumn(name = "NUM_RECETTE", referencedColumnName = "NUM_RECETTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Recette recette;

    public Etape() {
    }

    public Etape(EtapePK etapePK) {
        this.etapePK = etapePK;
    }

    public Etape(EtapePK etapePK, String instructionEtape) {
        this.etapePK = etapePK;
        this.instructionEtape = instructionEtape;
    }

    public Etape(int numEtape, long numRecette) {
        this.etapePK = new EtapePK(numEtape, numRecette);
    }

    public EtapePK getEtapePK() {
        return etapePK;
    }

    public void setEtapePK(EtapePK etapePK) {
        this.etapePK = etapePK;
    }

    public String getInstructionEtape() {
        return instructionEtape;
    }

    public void setInstructionEtape(String instructionEtape) {
        this.instructionEtape = instructionEtape;
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
        hash += (etapePK != null ? etapePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etape)) {
            return false;
        }
        Etape other = (Etape) object;
        if ((this.etapePK == null && other.etapePK != null) || (this.etapePK != null && !this.etapePK.equals(other.etapePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.Etape[ etapePK=" + etapePK + " ]";
    }

}
