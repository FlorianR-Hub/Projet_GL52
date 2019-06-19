/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.service.impl;

import com.utbm.projet.dao.data.*;
import com.utbm.projet.dao.interf.RecipeDao;
import com.utbm.projet.service.interf.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        List<Recette> recipesToRemove = new ArrayList<>();
        List<Carences> userDeficiencies = user.getCarencesList();
        List<Allergenes> userAllergies = user.getAllergenesList();

        List<String> userDeficienciesName = new ArrayList<>();

        if (userDeficiencies != null) {
            for (Carences deficiency : userDeficiencies) {
                userDeficienciesName.add(deficiency.getNomCarence());
            }
        }

        for (Recette recipe : dailyRecipes) {
            if (userAllergies != null) {
                for (Allergenes allergen : recipe.getAllergenesList()) {
                    if (user.getAllergenesList().contains(allergen)) {
                        recipesToRemove.add(recipe);
                        break;
                    }
                }
            }
        }
        dailyRecipes.removeAll(recipesToRemove);

        List<RecetteScore> recetteScores = new ArrayList<>();

        for (Recette r : dailyRecipes) {
            int score = 0;

            for (Anc anc : r.getAncList()) {
                if (userDeficienciesName.contains(anc.getNomAnc())) {
                    score += 1;
                }
            }
            recetteScores.add(new RecetteScore(r.getNumRecette(), score));
        }

        Comparator<Recette> compare = (Recette r1, Recette r2) -> {
            Integer score1 = 0;
            Integer score2 = 0;
            for (RecetteScore t : recetteScores) {
                if (t.recetteId == r1.getNumRecette()) {
                    score1 = t.score;
                    break;
                }
            }
            for (RecetteScore t : recetteScores) {
                if (t.recetteId == r2.getNumRecette()) {
                    score2 = t.score;
                    break;
                }
            }
            return score2.compareTo(score1);
        };

        dailyRecipes.sort(compare);
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

    private class RecetteScore {
        Long recetteId;
        int score;

        RecetteScore(Long id, int sc) {
            this.recetteId = id;
            this.score = sc;
        }

        @Override
        public String toString() {
            return "RecetteScore recetteId= [" + recetteId + " , score= " + score + "]";
        }
    }
}