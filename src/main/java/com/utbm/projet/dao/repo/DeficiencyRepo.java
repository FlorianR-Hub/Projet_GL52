/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.repo;

import com.utbm.projet.dao.data.Carences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 */
public interface DeficiencyRepo extends JpaRepository<Carences, Integer> {

    @Query(value = "SELECT c FROM Carences c WHERE c.nomCarence = ?1")
    public Carences getByName(String name);

}
