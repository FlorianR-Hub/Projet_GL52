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
 *
 * @author neid
 */
@ManagedBean
@Scope("session")
public class FavoritesModel {

    private List<Recette> recettesFavorites;

    public List<Recette> getRecettesFavorites() {
        return recettesFavorites;
    }

    public void setRecettesFavorites(List<Recette> recettesFavorites) {
        this.recettesFavorites = recettesFavorites;
    }

}
