/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.interf;

import com.utbm.projet.dao.data.Allergenes;
import java.util.List;

/**
 *
 */
public interface AllergyDao {

    public List<Allergenes> getAll();

    public Allergenes getByName(String name);

    public Allergenes getByNum(Integer num);

}
