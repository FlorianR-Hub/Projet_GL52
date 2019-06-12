/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.repo;

import com.utbm.projet.dao.data.Anc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 */
public interface AncRepo extends JpaRepository<Anc, Integer> {

    @Query(value = "SELECT a FROM Anc a WHERE a.nomAnc = ?1")
    public Anc getByName(String name);

}
