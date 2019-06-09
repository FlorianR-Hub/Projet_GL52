/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.interf;

import com.utbm.projet.dao.data.UserAuth;

/**
 * DAO interface for USER_AUTH table.
 */
public interface UserAuthDao {

    public UserAuth login(String username, String password);

    public UserAuth register(String username, String password);

    public UserAuth getById(Long id);

}
