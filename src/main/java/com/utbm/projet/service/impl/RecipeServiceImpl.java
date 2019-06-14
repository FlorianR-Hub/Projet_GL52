/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.service.impl;

import com.utbm.projet.dao.data.Recette;
import com.utbm.projet.dao.data.Utilisateur;
import com.utbm.projet.dao.interf.RecipeDao;
import com.utbm.projet.service.interf.RecipeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeDao recipeDao;

    // TODO : choix des recettes journalières en fonction de l'utilisateur
    @Override
    public List<Recette> getDailyRecipes(Utilisateur user) {
        List<Recette> dailyRecipes = recipeDao.getAll();

        return dailyRecipes;
    }

    @Override
    public List<Recette> getAllRecipe() {
        return recipeDao.getAll();
    }

    @Override
    public Recette getRecipeByNum(Long num) {
        return recipeDao.getByNum(num);
    }

    @Override
    public Recette createRecipe(Recette recipe) {
        return recipeDao.insert(recipe);
    }

    @Override
    public Recette updateRecipe(Recette recipe) {
        return recipeDao.insert(recipe);
    }

}
