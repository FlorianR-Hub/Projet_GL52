/*
 * Projet TW52 - Agri-More
 *
 * RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.repo;

import com.utbm.projet.dao.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u.admin FROM User u WHERE u.username = ?1")
    public boolean getRole(String username);

    @Query(value = "SELECT u FROM User u WHERE u.username = ?1 AND u.password = ?2")
    public User getByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT u FROM User u WHERE u.username = ?1")
    public User getByUsername(String username);

}
