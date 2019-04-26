/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.model;

import com.utbm.projet.dao.data.User;
import javax.annotation.ManagedBean;
import org.springframework.context.annotation.Scope;

/**
 * Model class for the template of each pages.
 */
@ManagedBean
@Scope("session")
public class TemplateModel {

    private User user;

    private boolean logged = false;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

}
