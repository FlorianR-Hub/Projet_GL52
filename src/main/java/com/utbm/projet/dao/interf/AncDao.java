/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.interf;

import com.utbm.projet.dao.data.Anc;
import java.util.List;

/**
 *
 */
public interface AncDao {

    public List<Anc> getAll();

    public Anc getByName(String name);

    public Anc getByNum(Integer num);

}
