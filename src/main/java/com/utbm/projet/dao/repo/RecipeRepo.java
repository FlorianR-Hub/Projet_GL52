/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.repo;

import com.utbm.projet.dao.data.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface RecipeRepo extends JpaRepository<Recette, Long> {

}
