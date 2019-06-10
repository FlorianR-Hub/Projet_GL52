/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.impl;

import com.utbm.projet.dao.data.Ingredients;
import com.utbm.projet.dao.interf.IngredientDao;
import com.utbm.projet.dao.repo.IngredientRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class IngredrientDaoImpl implements IngredientDao {

    @Autowired
    private IngredientRepo ingredientRepo;

    @Override
    public List<Ingredients> getAll() {
        return ingredientRepo.findAll();
    }

    @Override
    public Long getNumByName(String name) {
        return ingredientRepo.getNumByName(name);
    }

    @Override
    public Ingredients insert(Ingredients ingredient) {
        return ingredientRepo.save(ingredient);
    }

}
