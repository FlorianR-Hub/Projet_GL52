/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.repo;

import com.utbm.projet.dao.data.Allergenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 */
public interface AllergyRepo extends JpaRepository<Allergenes, Integer> {

    @Query(value = "SELECT a FROM Allergenes a WHERE a.nomAllergene = ?1")
    public Allergenes getByName(String name);
}
