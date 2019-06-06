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

public interface UserRepo extends JpaRepository<UserAuth, Integer> {

    @Query(value = "SELECT u.accountType FROM UserAuth u WHERE u.username = ?1")
    public boolean getRole(String username);

    @Query(value = "SELECT u FROM UserAuth u WHERE u.username = ?1 AND u.password = ?2")
    public UserAuth getByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT u FROM UserAuth u WHERE u.username = ?1")
    public UserAuth getByUsername(String username);

}
