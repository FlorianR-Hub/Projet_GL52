/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.impl;

import com.utbm.projet.dao.data.UserAuth;
import com.utbm.projet.dao.interf.UserAuthDao;
import com.utbm.projet.dao.repo.UserAuthRepo;
import com.utbm.projet.util.AccountTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserAuthDaoImpl implements UserAuthDao {

    @Autowired
    private UserAuthRepo userAuthRepo;

    @Override
    public UserAuth login(String pseudo, String password) {
        return userAuthRepo.getByPseudoAndPassword(pseudo, password);
    }

    @Override
    public UserAuth register(String pseudo, String password) {
        UserAuth newUser = new UserAuth();
        newUser.setPseudo(pseudo);
        newUser.setMdp(password);
        newUser.setAccountType((short) AccountTypes.UTILISATEUR.getId());

        if (userAuthRepo.getByPseudo(pseudo) != null) {
            throw new IllegalArgumentException("Le pseudo " + pseudo + " est déjà utilisé");
        }

        return userAuthRepo.save(newUser);
    }

    @Override
    public UserAuth getById(Long id) {
        return userAuthRepo.getOne(id);
    }

}
