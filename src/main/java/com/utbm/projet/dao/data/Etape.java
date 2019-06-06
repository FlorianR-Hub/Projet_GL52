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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(name = "etape")
public class Etape implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_ETAPE")
    private Integer numEtape;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "INSTRUCTION_ETAPE")
    private String instructionEtape;

    @JoinColumn(name = "NUM_RECETTE", referencedColumnName = "NUM_RECETTE")
    @ManyToOne(optional = false)
    private Recette recette;

    public Etape() {
    }

    public Etape(Integer numEtape) {
        this.numEtape = numEtape;
    }

    public Etape(Integer numEtape, String instructionEtape) {
        this.numEtape = numEtape;
        this.instructionEtape = instructionEtape;
    }

    public Integer getNumEtape() {
        return numEtape;
    }

    public void setNumEtape(Integer numEtape) {
        this.numEtape = numEtape;
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
        hash += (numEtape != null ? numEtape.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etape)) {
            return false;
        }
        Etape other = (Etape) object;
        if ((this.numEtape == null && other.numEtape != null) || (this.numEtape != null && !this.numEtape.equals(other.numEtape))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.Etape[ numEtape=" + numEtape + " ]";
    }

}
