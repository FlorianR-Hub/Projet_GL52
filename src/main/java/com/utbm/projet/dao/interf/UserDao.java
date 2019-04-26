/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.interf;

import com.utbm.projet.dao.data.User;

/**
 * DAO interface for USER_AUTH table.
 */
public interface UserDao {

    public User login(String username, String password);

}
