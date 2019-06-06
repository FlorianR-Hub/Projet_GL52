/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.impl;

import com.utbm.projet.dao.data.UserAuth;
import com.utbm.projet.dao.interf.UserDao;
import com.utbm.projet.dao.repo.UserRepo;
import com.utbm.projet.util.AccountTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserAuth login(String username, String password) {
        return userRepo.getByUsernameAndPassword(username, password);
    }

    @Override
    public UserAuth register(String username, String password) {
        UserAuth newUser = new UserAuth();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setAccountType(AccountTypes.UTILISATEUR.getId());

        if (userRepo.getByUsername(username) != null) {
            throw new IllegalArgumentException("l'utilisateur " + username + " existe déjà");
        }

        return userRepo.save(newUser);
    }

}
