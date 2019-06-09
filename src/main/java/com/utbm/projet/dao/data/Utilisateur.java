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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "utilisateur")
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_UTILISATEUR")
    private Long numUtilisateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PRENOM_UTILISATEUR")
    private String prenomUtilisateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM_UTILISATEUR")
    private String nomUtilisateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COURRIEL_UTILISATEUR")
    private String courrielUtilisateur;
    @Basic(optional = false)
    @NotNull
    @Size(max = 150)
    @Column(name = "ADRESSE_UTILISATEUR")
    private String adresseUtilisateur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AGE")
    private int age;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POIDS")
    private int poids;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TAILLE")
    private int taille;
    @Size(max = 60)
    @Column(name = "ALLERGIES")
    private String allergies;
    @Size(max = 60)
    @Column(name = "CARENCES")
    private String carences;
    @ManyToMany(mappedBy = "utilisateurList")
    private List<Recette> recetteList;
    @JoinColumn(name = "NUM_NUTRITIONNISTE", referencedColumnName = "NUM_NUTRITIONNISTE")
    @ManyToOne
    private Nutritionniste numNutritionniste;
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UserAuth id;

    public Utilisateur() {
    }

    public Utilisateur(Long numUtilisateur) {
        this.numUtilisateur = numUtilisateur;
    }

    public Utilisateur(Long numUtilisateur, String prenomUtilisateur, String nomUtilisateur, String courrielUtilisateur, String adresseUtilisateur, int age, int poids, int taille) {
        this.numUtilisateur = numUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.courrielUtilisateur = courrielUtilisateur;
        this.adresseUtilisateur = adresseUtilisateur;
        this.age = age;
        this.poids = poids;
        this.taille = taille;
    }

    public Long getNumUtilisateur() {
        return numUtilisateur;
    }

    public void setNumUtilisateur(Long numUtilisateur) {
        this.numUtilisateur = numUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getCourrielUtilisateur() {
        return courrielUtilisateur;
    }

    public void setCourrielUtilisateur(String courrielUtilisateur) {
        this.courrielUtilisateur = courrielUtilisateur;
    }

    public String getAdresseUtilisateur() {
        return adresseUtilisateur;
    }

    public void setAdresseUtilisateur(String adresseUtilisateur) {
        this.adresseUtilisateur = adresseUtilisateur;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getCarences() {
        return carences;
    }

    public void setCarences(String carences) {
        this.carences = carences;
    }

    public List<Recette> getRecetteList() {
        return recetteList;
    }

    public void setRecetteList(List<Recette> recetteList) {
        this.recetteList = recetteList;
    }

    public Nutritionniste getNumNutritionniste() {
        return numNutritionniste;
    }

    public void setNumNutritionniste(Nutritionniste numNutritionniste) {
        this.numNutritionniste = numNutritionniste;
    }

    public UserAuth getId() {
        return id;
    }

    public void setId(UserAuth id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numUtilisateur != null ? numUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.numUtilisateur == null && other.numUtilisateur != null) || (this.numUtilisateur != null && !this.numUtilisateur.equals(other.numUtilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.Utilisateur[ numUtilisateur=" + numUtilisateur + " ]";
    }

}
