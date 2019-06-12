/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.impl;

import com.utbm.projet.dao.data.Nutritionniste;
import com.utbm.projet.dao.interf.NutritionistDao;
import com.utbm.projet.dao.repo.NutritionistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class NutritionistDaoImpl implements NutritionistDao {

    @Autowired
    private NutritionistRepo nutritionistRepo;

    @Override
    public Nutritionniste getByNum(Long num) {
        return nutritionistRepo.getOne(num);
    }

    @Override
    public Nutritionniste getByUserAuthId(Long id) {
        Nutritionniste nutritionist = nutritionistRepo.getByUserAuthId(id);

        if (nutritionist == null) {
            nutritionist = new Nutritionniste();
        }

        return nutritionist;
    }

    @Override
    public void update(Nutritionniste nutritionist) {
        nutritionistRepo.save(nutritionist);
    }

}
