/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.repo;

import com.utbm.projet.dao.data.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 */
public interface UserRepo extends JpaRepository<Utilisateur, Long> {

    @Query(value = "SELECT u FROM Utilisateur u WHERE u.id.id = ?1")
    public Utilisateur getByUserAuthId(Long id);

}
