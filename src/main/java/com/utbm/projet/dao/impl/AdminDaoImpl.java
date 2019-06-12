/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.impl;

import com.utbm.projet.dao.data.Administrateur;
import com.utbm.projet.dao.interf.AdminDao;
import com.utbm.projet.dao.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public Administrateur getByNum(Integer num) {
        return adminRepo.getOne(num);
    }

    @Override
    public Administrateur getByUserAuthId(Long id) {
        Administrateur admin = adminRepo.getByUserAuthId(id);

        if (admin == null) {
            return new Administrateur();
        }

        return admin;
    }

    @Override
    public void update(Administrateur admin) {
        adminRepo.save(admin);
    }

}
