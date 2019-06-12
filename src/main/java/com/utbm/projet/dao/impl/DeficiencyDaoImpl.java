/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.impl;

import com.utbm.projet.dao.data.Carences;
import com.utbm.projet.dao.interf.DeficiencyDao;
import com.utbm.projet.dao.repo.DeficiencyRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class DeficiencyDaoImpl implements DeficiencyDao {

    @Autowired
    private DeficiencyRepo deficiencyRepo;

    @Override
    public List<Carences> getAll() {
        return deficiencyRepo.findAll();
    }

    @Override
    public Carences getByName(String name) {
        return deficiencyRepo.getByName(name);
    }

    @Override
    public Carences getByNum(Integer num) {
        return deficiencyRepo.getOne(num);
    }

}
