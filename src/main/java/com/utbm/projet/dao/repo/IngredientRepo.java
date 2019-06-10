/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.repo;

import com.utbm.projet.dao.data.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 */
public interface IngredientRepo extends JpaRepository<Ingredients, Long> {

    @Query(value = "SELECT i.numIngredient FROM Ingredients i WHERE i.nomIngredient = ?1")
    public Long getNumByName(String name);

}
