/*
 * Projet TW52 - Agri-More
 *
 * RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.repo;

import com.utbm.projet.dao.data.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserAuthRepo extends JpaRepository<UserAuth, Long> {

    @Query(value = "SELECT u.accountType FROM UserAuth u WHERE u.pseudo = ?1")
    public int getRole(String pseudo);

    @Query(value = "SELECT u FROM UserAuth u WHERE u.pseudo = ?1 AND u.mdp = ?2")
    public UserAuth getByPseudoAndPassword(String pseudo, String password);

    @Query(value = "SELECT u FROM UserAuth u WHERE u.pseudo = ?1")
    public UserAuth getByPseudo(String pseudo);

}
