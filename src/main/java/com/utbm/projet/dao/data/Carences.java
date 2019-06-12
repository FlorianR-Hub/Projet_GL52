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
@Table(name = "carences")
@NamedQueries({
    @NamedQuery(name = "Carences.findAll", query = "SELECT c FROM Carences c")})
public class Carences implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_CARENCE")
    private Integer numCarence;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOM_CARENCE")
    private String nomCarence;

    public Carences() {
    }

    public Carences(Integer numCarence) {
        this.numCarence = numCarence;
    }

    public Carences(Integer numCarence, String nomCarence) {
        this.numCarence = numCarence;
        this.nomCarence = nomCarence;
    }

    public Integer getNumCarence() {
        return numCarence;
    }

    public void setNumCarence(Integer numCarence) {
        this.numCarence = numCarence;
    }

    public String getNomCarence() {
        return nomCarence;
    }

    public void setNomCarence(String nomCarence) {
        this.nomCarence = nomCarence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCarence != null ? numCarence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carences)) {
            return false;
        }
        Carences other = (Carences) object;
        if ((this.numCarence == null && other.numCarence != null) || (this.numCarence != null && !this.numCarence.equals(other.numCarence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.Carences[ numCarence=" + numCarence + " ]";
    }

}
