/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author flori
 */
@Entity
@Table(name = "administrateur")
@NamedQueries({
    @NamedQuery(name = "Administrateur.findAll", query = "SELECT a FROM Administrateur a")})
public class Administrateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_ADMIN")
    private Integer numAdmin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PRENOM_ADMIN")
    private String prenomAdmin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM_ADMIN")
    private String nomAdmin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COURRIEL_ADMIN")
    private String courrielAdmin;
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UserAuth id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "administrateur")
    private List<Gerer> gererList;

    public Administrateur() {
    }

    public Administrateur(Integer numAdmin) {
        this.numAdmin = numAdmin;
    }

    public Administrateur(Integer numAdmin, String prenomAdmin, String nomAdmin, String courrielAdmin) {
        this.numAdmin = numAdmin;
        this.prenomAdmin = prenomAdmin;
        this.nomAdmin = nomAdmin;
        this.courrielAdmin = courrielAdmin;
    }

    public Integer getNumAdmin() {
        return numAdmin;
    }

    public void setNumAdmin(Integer numAdmin) {
        this.numAdmin = numAdmin;
    }

    public String getPrenomAdmin() {
        return prenomAdmin;
    }

    public void setPrenomAdmin(String prenomAdmin) {
        this.prenomAdmin = prenomAdmin;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getCourrielAdmin() {
        return courrielAdmin;
    }

    public void setCourrielAdmin(String courrielAdmin) {
        this.courrielAdmin = courrielAdmin;
    }

    public UserAuth getId() {
        return id;
    }

    public void setId(UserAuth id) {
        this.id = id;
    }

    public List<Gerer> getGererList() {
        return gererList;
    }

    public void setGererList(List<Gerer> gererList) {
        this.gererList = gererList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numAdmin != null ? numAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrateur)) {
            return false;
        }
        Administrateur other = (Administrateur) object;
        if ((this.numAdmin == null && other.numAdmin != null) || (this.numAdmin != null && !this.numAdmin.equals(other.numAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.Administrateur[ numAdmin=" + numAdmin + " ]";
    }

}
