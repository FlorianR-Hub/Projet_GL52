/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.interf;

import com.utbm.projet.dao.data.Recette;
import java.util.List;

/**
 *
 */
public interface RecipeDao {

    public List<Recette> getAll();

    public Recette getByNum(Long num);

    public Recette insert(Recette recipe);

}
