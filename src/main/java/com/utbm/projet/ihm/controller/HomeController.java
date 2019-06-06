/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.controller;

import com.utbm.projet.ihm.model.HomeModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Controller class of the Home page.
 */
public class HomeController extends GenericController {

    @Autowired
    private HomeModel homeModel;

    @Override
    public void initModel() {

    }

}
