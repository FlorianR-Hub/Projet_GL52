/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.model;

import com.utbm.projet.dao.data.Recette;
import java.util.List;
import javax.annotation.ManagedBean;
import org.springframework.context.annotation.Scope;

/**
 * Model class of the Home page.
 */
@ManagedBean
@Scope("session")
public class HomeModel {

    final String heartClass = "heart";
    final String redHeartClass = "red-heart";

    List<Recette> recettes;

    public List<Recette> getRecettes() {
        return recettes;
    }

    public void setRecettes(List<Recette> recettes) {
        this.recettes = recettes;
    }

    public String getHeartClass() {
        return heartClass;
    }

    public String getRedHeartClass() {
        return redHeartClass;
    }

}
