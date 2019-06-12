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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "anc")
@NamedQueries({
    @NamedQuery(name = "Anc.findAll", query = "SELECT a FROM Anc a")})
public class Anc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_ANC")
    private Integer numAnc;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOM_ANC")
    private String nomAnc;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "TYPE_ANC")
    private String typeAnc;

    public Anc() {
    }

    public Anc(Integer numAnc) {
        this.numAnc = numAnc;
    }

    public Anc(Integer numAnc, String nomAnc, String typeAnc) {
        this.numAnc = numAnc;
        this.nomAnc = nomAnc;
        this.typeAnc = typeAnc;
    }

    public Integer getNumAnc() {
        return numAnc;
    }

    public void setNumAnc(Integer numAnc) {
        this.numAnc = numAnc;
    }

    public String getNomAnc() {
        return nomAnc;
    }

    public void setNomAnc(String nomAnc) {
        this.nomAnc = nomAnc;
    }

    public String getTypeAnc() {
        return typeAnc;
    }

    public void setTypeAnc(String typeAnc) {
        this.typeAnc = typeAnc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numAnc != null ? numAnc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anc)) {
            return false;
        }
        Anc other = (Anc) object;
        if ((this.numAnc == null && other.numAnc != null) || (this.numAnc != null && !this.numAnc.equals(other.numAnc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.Anc[ numAnc=" + numAnc + " ]";
    }

}
