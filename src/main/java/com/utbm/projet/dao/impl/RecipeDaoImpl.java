/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.impl;

import com.utbm.projet.dao.data.Recette;
import com.utbm.projet.dao.interf.RecipeDao;
import com.utbm.projet.dao.repo.RecipeRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class RecipeDaoImpl implements RecipeDao {

    @Autowired
    private RecipeRepo recipeRepo;

    @Override
    public List<Recette> getAll() {
        return recipeRepo.findAll();
    }

    @Override
    public Recette getByNum(Long num) {
        return recipeRepo.getOne(num);
    }

    @Override
    public Recette insert(Recette recipe) {
        return recipeRepo.save(recipe);
    }

}
