/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.dao.interf;

import com.utbm.projet.dao.data.Utilisateur;

/**
 *
 */
public interface UserDao {

    public Utilisateur getByNum(Long num);

    public Utilisateur getByUserAuthId(Long id);

    public Utilisateur update(Utilisateur user);

}
