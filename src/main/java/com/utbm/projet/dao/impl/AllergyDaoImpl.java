/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.impl;

import com.utbm.projet.dao.data.Allergenes;
import com.utbm.projet.dao.interf.AllergyDao;
import com.utbm.projet.dao.repo.AllergyRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class AllergyDaoImpl implements AllergyDao {

    @Autowired
    private AllergyRepo allergyRepo;

    @Override
    public List<Allergenes> getAll() {
        return allergyRepo.findAll();
    }

    @Override
    public Allergenes getByName(String name) {
        return allergyRepo.getByName(name);
    }

    @Override
    public Allergenes getByNum(Integer num) {
        return allergyRepo.getOne(num);
    }

    @Override
    public void update(Allergenes allergy) {
        allergyRepo.save(allergy);
    }

}
