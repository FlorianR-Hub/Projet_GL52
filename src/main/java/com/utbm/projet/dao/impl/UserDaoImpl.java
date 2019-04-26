/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.impl;

import com.utbm.projet.dao.data.User;
import com.utbm.projet.dao.interf.UserDao;
import com.utbm.projet.dao.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User login(String username, String password) {
        return userRepo.getByUsernameAndPassword(username, password);
    }

}
