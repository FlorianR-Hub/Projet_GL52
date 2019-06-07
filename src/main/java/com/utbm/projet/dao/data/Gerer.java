/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.data;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author flori
 */
@Entity
@Table(name = "gerer")
@NamedQueries({
    @NamedQuery(name = "Gerer.findAll", query = "SELECT g FROM Gerer g")})
public class Gerer implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GererPK gererPK;
    @JoinColumn(name = "NUM_ADMIN", referencedColumnName = "NUM_ADMIN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Administrateur administrateur;
    @JoinColumn(name = "NUM_NUTRITIONNISTE", referencedColumnName = "NUM_NUTRITIONNISTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Nutritionniste nutritionniste;
    @JoinColumn(name = "NUM_RECETTE", referencedColumnName = "NUM_RECETTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Recette recette;

    public Gerer() {
    }

    public Gerer(GererPK gererPK) {
        this.gererPK = gererPK;
    }

    public Gerer(int numAdmin, long numRecette, long numNutritionniste) {
        this.gererPK = new GererPK(numAdmin, numRecette, numNutritionniste);
    }

    public GererPK getGererPK() {
        return gererPK;
    }

    public void setGererPK(GererPK gererPK) {
        this.gererPK = gererPK;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public Nutritionniste getNutritionniste() {
        return nutritionniste;
    }

    public void setNutritionniste(Nutritionniste nutritionniste) {
        this.nutritionniste = nutritionniste;
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
        hash += (gererPK != null ? gererPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gerer)) {
            return false;
        }
        Gerer other = (Gerer) object;
        if ((this.gererPK == null && other.gererPK != null) || (this.gererPK != null && !this.gererPK.equals(other.gererPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.Gerer[ gererPK=" + gererPK + " ]";
    }

}
