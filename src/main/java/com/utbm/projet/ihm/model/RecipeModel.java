/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.model;

import com.utbm.projet.dao.data.Recette;
import javax.annotation.ManagedBean;
import org.springframework.context.annotation.Scope;

/**
 * Model class of the Recipe page.
 */
@ManagedBean
@Scope("session")
public class RecipeModel {

    private Recette recipe;

    public Recette getRecipe() {
        return recipe;
    }

    public void setRecipe(Recette recipe) {
        this.recipe = recipe;
    }

}
