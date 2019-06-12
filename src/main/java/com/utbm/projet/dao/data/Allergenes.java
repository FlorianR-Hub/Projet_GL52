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
@Table(name = "allergenes")
@NamedQueries({
    @NamedQuery(name = "Allergenes.findAll", query = "SELECT a FROM Allergenes a")})
public class Allergenes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_ALLERGENE")
    private Integer numAllergene;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOM_ALLERGENE")
    private String nomAllergene;

    public Allergenes() {
    }

    public Allergenes(Integer numAllergene) {
        this.numAllergene = numAllergene;
    }

    public Allergenes(Integer numAllergene, String nomAllergene) {
        this.numAllergene = numAllergene;
        this.nomAllergene = nomAllergene;
    }

    public Integer getNumAllergene() {
        return numAllergene;
    }

    public void setNumAllergene(Integer numAllergene) {
        this.numAllergene = numAllergene;
    }

    public String getNomAllergene() {
        return nomAllergene;
    }

    public void setNomAllergene(String nomAllergene) {
        this.nomAllergene = nomAllergene;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numAllergene != null ? numAllergene.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Allergenes)) {
            return false;
        }
        Allergenes other = (Allergenes) object;
        if ((this.numAllergene == null && other.numAllergene != null) || (this.numAllergene != null && !this.numAllergene.equals(other.numAllergene))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.Allergenes[ numAllergene=" + numAllergene + " ]";
    }

}
