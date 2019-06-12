/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.repo;

import com.utbm.projet.dao.data.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 */
public interface AdminRepo extends JpaRepository<Administrateur, Integer> {

    @Query(value = "SELECT a FROM Administrateur a WHERE a.id.id = ?1")
    public Administrateur getByUserAuthId(Long id);

}
