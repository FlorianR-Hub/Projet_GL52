/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.interf;

import com.utbm.projet.dao.data.Administrateur;

/**
 *
 */
public interface AdminDao {

    public Administrateur getByNum(Integer num);

    public Administrateur getByUserAuthId(Long id);

    public void update(Administrateur admin);

}
