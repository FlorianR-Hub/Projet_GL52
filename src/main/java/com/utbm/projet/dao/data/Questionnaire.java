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
@Table(name = "questionnaire")
@NamedQueries({
    @NamedQuery(name = "Questionnaire.findAll", query = "SELECT q FROM Questionnaire q")})
public class Questionnaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_QUESTION")
    private Integer numQuestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ENONCE_QUESTION")
    private String enonceQuestion;

    public Questionnaire() {
    }

    public Questionnaire(Integer numQuestion) {
        this.numQuestion = numQuestion;
    }

    public Questionnaire(Integer numQuestion, String enonceQuestion) {
        this.numQuestion = numQuestion;
        this.enonceQuestion = enonceQuestion;
    }

    public Integer getNumQuestion() {
        return numQuestion;
    }

    public void setNumQuestion(Integer numQuestion) {
        this.numQuestion = numQuestion;
    }

    public String getEnonceQuestion() {
        return enonceQuestion;
    }

    public void setEnonceQuestion(String enonceQuestion) {
        this.enonceQuestion = enonceQuestion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numQuestion != null ? numQuestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questionnaire)) {
            return false;
        }
        Questionnaire other = (Questionnaire) object;
        if ((this.numQuestion == null && other.numQuestion != null) || (this.numQuestion != null && !this.numQuestion.equals(other.numQuestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utbm.projet.dao.data.Questionnaire[ numQuestion=" + numQuestion + " ]";
    }

}
