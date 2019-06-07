/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.controller;

import com.utbm.projet.dao.data.Recette;
import com.utbm.projet.dao.interf.RecipeDao;
import com.utbm.projet.ihm.model.RecipeModel;
import java.util.Map;
import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * Controller class of the Recipe page.
 */
@ManagedBean
@Scope("session")
public class RecipeController extends GenericController {

    @Autowired
    private RecipeModel recipeModel;

    @Autowired
    private RecipeDao recipeDao;

    @Override
    public void initModel() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        Recette recipe = recipeDao.getByNum(Long.parseLong(paramMap.get("num")));

        recipeModel.setRecipe(recipe);
    }

}
