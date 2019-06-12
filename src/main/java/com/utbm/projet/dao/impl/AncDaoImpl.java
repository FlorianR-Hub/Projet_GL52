/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.impl;

import com.utbm.projet.dao.data.Anc;
import com.utbm.projet.dao.interf.AncDao;
import com.utbm.projet.dao.repo.AncRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class AncDaoImpl implements AncDao {

    @Autowired
    private AncRepo ancRepo;

    @Override
    public List<Anc> getAll() {
        return ancRepo.findAll();
    }

    @Override
    public Anc getByName(String name) {
        return ancRepo.getByName(name);
    }

    @Override
    public Anc getByNum(Integer num) {
        return ancRepo.getOne(num);
    }

}
