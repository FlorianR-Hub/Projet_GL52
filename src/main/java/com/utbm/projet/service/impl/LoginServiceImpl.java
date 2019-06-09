/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.service.impl;

import com.utbm.projet.dao.data.UserAuth;
import com.utbm.projet.dao.interf.UserAuthDao;
import com.utbm.projet.service.interf.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserAuthDao userAuthDao;

    @Override
    public UserAuth login(String username, String password) {
        UserAuth user = userAuthDao.login(username, password);

        if (user == null) {
            throw new IllegalArgumentException("Informations de connexion invalides");
        }

        return user;
    }

    @Override
    public UserAuth register(String username, String password) {
        return userAuthDao.register(username, password);
    }

}
