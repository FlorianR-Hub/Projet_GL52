/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.interf;

import com.utbm.projet.dao.data.Nutritionniste;

/**
 *
 */
public interface NutritionistDao {

    public Nutritionniste getByNum(Long num);

    public Nutritionniste getByUserAuthId(Long id);

    public void update(Nutritionniste nutritionist);

}
