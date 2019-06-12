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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "recette")
@NamedQueries({
    @NamedQuery(name = "Recette.findAll", query = "SELECT r FROM Recette r")})
public class Recette implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_RECETTE")
    private Long numRecette;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM_RECETTE")
    private String nomRecette;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TYPE_RECETTE")
    private String typeRecette;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "DIFFICULTE_RECETTE")
    private String difficulteRecette;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "DESC_RECETTE")
    private String descRecette;

    @Basic(optional = false)
    @NotNull
    @Column(name = "TEMPS_PREPARATION_RECETTE")
    private int tempsPreparationRecette;

    @Basic(optional = false)
    @NotNull
    @Column(name = "NB_PERSONNES_RECETTE")
    private int nbPersonnesRecette;

    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "IMAGE_RECETTE")
    private byte[] imageRecette;

    @Column(name = "ENERGIE")
    private Integer energie;

    @ManyToMany
    @JoinTable(name = "associer", joinColumns = {
        @JoinColumn(name = "NUM_RECETTE", referencedColumnName = "NUM_RECETTE")}, inverseJoinColumns = {
        @JoinColumn(name = "NUM_ALLERGENE", referencedColumnName = "NUM_ALLERGENE")})
    private List<Allergenes> allergenesList;

    @ManyToMany
    @JoinTable(name = "posseder", joinColumns = {
        @JoinColumn(name = "NUM_RECETTE", referencedColumnName = "NUM_RECETTE")}, inverseJoinColumns = {
        @JoinColumn(name = "NUM_ANC", referencedColumnName = "NUM_ANC")})
    private List<Anc> ancList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recette")
    private List<Etape> etapeList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recette")
    private List<Contenir> contenirList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recette")
    private List<Gerer> gererList;

    public Recette() {
    }

    public Recette(Long numRecette) {
        this.numRecette = numRecette;
    }

    public Recette(Long numRecette, String nomRecette, String typeRecette, String difficulteRecette, String descRecette, int tempsPreparationRecette, int nbPersonnesRecette, byte[] imageRecette) {
        this.numRecette = numRecette;
        this.nomRecette = nomRecette;
        this.typeRecette = typeRecette;
        this.difficulteRecette = difficulteRecette;
        this.descRecette = descRecette;
        this.tempsPreparationRecette = tempsPreparationRecette;
        this.nbPersonnesRecette = nbPersonnesRecette;
        this.imageRecette = imageRecette;
    }

    public Long getNumRecette() {
        return numRecette;
    }

    public void setNumRecette(Long numRecette) {
        this.numRecette = numRecette;
    }

    public String getNomRecette() {
        return nomRecette;
    }

    public void setNomRecette(String nomRecette) {
        this.nomRecette = nomRecette;
    }

    public String getTypeRecette() {
        return typeRecette;
    }

    public void setTypeRecette(String typeRecette) {
        this.typeRecette = typeRecette;
    }

    public String getDifficulteRecette() {
        return difficulteRecette;
    }

    public void setDifficulteRecette(String difficulteRecette) {
        this.difficulteRecette = difficulteRecette;
    }

    public String getDescRecette() {
        return descRecette;
    }

    public void setDescRecette(String descRecette) {
        this.descRecette = descRecette;
    }

    public int getTempsPreparationRecette() {
        return tempsPreparationRecette;
    }

    public void setTempsPreparationRecette(int tempsPreparationRecette) {
        this.tempsPreparationRecette = tempsPreparationRecette;
    }

    public int getNbPersonnesRecette() {
        return nbPersonnesRecette;
    }

    public void setNbPersonnesRecette(int nbPersonnesRecette) {
        this.nbPersonnesRecette = nbPersonnesRecette;
    }

    public byte[] getImageRecette() {
        return imageRecette;
    }

    public void setImageRecette(byte[] imageRecette) {
        this.imageRecette = imageRecette;
    }

    public Integer getEnergie() {
        return energie;
    }

    public void setEnergie(Integer energie) {
        this.energie = energie;
    }

    public List<Allergenes> getAllergenesList() {
        return allergenesList;
    }

    public void setAllergenesList(List<Allergenes> allergenesList) {
        this.allergenesList = allergenesList;
    }

    public List<Anc> getAncList() {
        return ancList;
    }

    public void setAncList(List<Anc> ancList) {
        this.ancList = ancList;
    }

    public List<Etape> getEtapeList() {
        return etapeList;
    }

    public void setEtapeList(List<Etape> etapeList) {
        this.etapeList = etapeList;
    }

    public List<Contenir> getContenirList() {
        return contenirList;
    }

    public void setContenirList(List<Contenir> contenirList) {
        this.contenirList = contenirList;
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
        hash += (numRecette != null ? numRecette.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recette)) {
            return false;
        }
        Recette other = (Recette) object;
        if ((this.numRecette == null && other.numRecette != null) || (this.numRecette != null && !this.numRecette.equals(other.numRecette))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.Recette[ numRecette=" + numRecette + " ]";
    }

}
