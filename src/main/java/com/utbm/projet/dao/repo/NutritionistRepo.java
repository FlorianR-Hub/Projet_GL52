/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.repo;

import com.utbm.projet.dao.data.Nutritionniste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 */
public interface NutritionistRepo extends JpaRepository<Nutritionniste, Long> {

    @Query(value = "SELECT n FROM Nutritionniste n WHERE n.id.id = ?1")
    public Nutritionniste getByUserAuthId(Long id);

}
