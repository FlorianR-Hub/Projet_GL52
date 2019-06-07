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
import org.primefaces.model.StreamedContent;
import org.springframework.context.annotation.Scope;

/**
 * Model class of the Recipe page.
 */
@ManagedBean
@Scope("session")
public class RecipeModel {

    private Recette recipe;

    private StreamedContent recipeImage;

    public Recette getRecipe() {
        return recipe;
    }

    public void setRecipe(Recette recipe) {
        this.recipe = recipe;
    }

    public StreamedContent getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(StreamedContent recipeImage) {
        this.recipeImage = recipeImage;
    }

}
