/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.model;

import com.utbm.projet.dao.data.Administrateur;
import com.utbm.projet.dao.data.Nutritionniste;
import com.utbm.projet.dao.data.Utilisateur;
import java.util.List;
import javax.annotation.ManagedBean;
import org.springframework.context.annotation.Scope;

/**
 * Model class of the Profile page.
 */
@ManagedBean
@Scope("session")
public class ProfileModel {

    private Administrateur admin;

    private Nutritionniste nutritionist;

    private Utilisateur user;

    private List<String> allergiesName;

    private List<String> deficienciesName;

    private List<String> allergiesNameSelected;

    private List<String> deficienciesNameSelected;

    public Administrateur getAdmin() {
        return admin;
    }

    public void setAdmin(Administrateur admin) {
        this.admin = admin;
    }

    public Nutritionniste getNutritionist() {
        return nutritionist;
    }

    public void setNutritionist(Nutritionniste nutritionist) {
        this.nutritionist = nutritionist;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public List<String> getAllergiesName() {
        return allergiesName;
    }

    public void setAllergiesName(List<String> allergiesName) {
        this.allergiesName = allergiesName;
    }

    public List<String> getDeficienciesName() {
        return deficienciesName;
    }

    public void setDeficienciesName(List<String> deficienciesName) {
        this.deficienciesName = deficienciesName;
    }

    public List<String> getAllergiesNameSelected() {
        return allergiesNameSelected;
    }

    public void setAllergiesNameSelected(List<String> allergiesNameSelected) {
        this.allergiesNameSelected = allergiesNameSelected;
    }

    public List<String> getDeficienciesNameSelected() {
        return deficienciesNameSelected;
    }

    public void setDeficienciesNameSelected(List<String> deficienciesNameSelected) {
        this.deficienciesNameSelected = deficienciesNameSelected;
    }

}
