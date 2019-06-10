/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.interf;

import com.utbm.projet.dao.data.Ingredients;
import java.util.List;

/**
 *
 */
public interface IngredientDao {

    public List<Ingredients> getAll();

    public Long getNumByName(String name);

    public Ingredients insert(Ingredients ingredient);

}
