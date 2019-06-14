/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.service.interf;

import com.utbm.projet.dao.data.Recette;
import com.utbm.projet.dao.data.Utilisateur;
import java.util.List;

/**
 *
 */
public interface RecipeService {

    public List<Recette> getDailyRecipes(Utilisateur user);

    public List<Recette> getAllRecipe();

    public Recette getRecipeByNum(Long num);

    public Recette createRecipe(Recette recipe);

    public Recette updateRecipe(Recette recipe);

}
