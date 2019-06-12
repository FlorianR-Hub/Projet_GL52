/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.interf;

import com.utbm.projet.dao.data.Carences;
import java.util.List;

/**
 *
 */
public interface DeficiencyDao {

    public List<Carences> getAll();

    public Carences getByName(String name);

    public Carences getByNum(Integer num);

}
