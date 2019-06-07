/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.view;

import com.utbm.projet.dao.data.Contenir;
import com.utbm.projet.ihm.controller.RecipeController;
import com.utbm.projet.ihm.model.RecipeModel;
import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * View class of the Recipe page.
 */
@ManagedBean
@Scope("session")
public class RecipeView extends GenericView {

    @Autowired
    private RecipeController recipeController;

    @Autowired
    private RecipeModel recipeModel;

    @Override
    public void initView() {
        // The initView() method is called for each AJAX call.
        // We only want to call it when we load the page.
        if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
            return;
        }

        recipeController.initModel();
    }

    public String getIngredientStr(Contenir ingredientInfos) {
        String nomIngredient = ingredientInfos.getIngredients().getNomIngredient();

        if (ingredientInfos.getUnite().isEmpty()) {
            return ingredientInfos.getQuantite() + " " + Character.toLowerCase(nomIngredient.charAt(0)) + nomIngredient.substring(1);
        } else {
            return ingredientInfos.getQuantite() + ingredientInfos.getUnite() + " de " + Character.toLowerCase(nomIngredient.charAt(0)) + nomIngredient.substring(1);
        }
    }

}
