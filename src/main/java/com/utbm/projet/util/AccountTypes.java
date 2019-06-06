/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.util;

/**
 *
 */
public enum AccountTypes {

    UTILISATEUR(0),
    NUTRITIONNISTE(1),
    ADMINISTRATEUR(2);

    private int id;

    private AccountTypes(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
