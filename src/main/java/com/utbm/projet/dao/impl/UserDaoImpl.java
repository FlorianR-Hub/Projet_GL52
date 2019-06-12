/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.impl;

import com.utbm.projet.dao.data.Utilisateur;
import com.utbm.projet.dao.interf.UserDao;
import com.utbm.projet.dao.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepo userRepo;

    @Override
    public Utilisateur getByNum(Long num) {
        return userRepo.getOne(num);
    }

    @Override
    public Utilisateur getByUserAuthId(Long id) {
        Utilisateur user = userRepo.getByUserAuthId(id);

        if (user == null) {
            return new Utilisateur();
        }

        return user;
    }

    @Override
    public Utilisateur update(Utilisateur user) {
        return userRepo.save(user);
    }

}
