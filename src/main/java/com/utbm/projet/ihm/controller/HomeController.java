package com.utbm.projet.ihm.controller;

/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
import com.utbm.projet.dao.interf.RecipeDao;
import com.utbm.projet.ihm.model.HomeModel;
import javax.annotation.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * Controller class of the Home page.
 */
@ManagedBean
@Scope("session")
public class HomeController extends GenericController {

    @Autowired
    private HomeModel homeModel;

    @Autowired
    private RecipeDao recipeDao;

    @Override
    public void initModel() {
        homeModel.setHeartClass("heart");
        homeModel.setRecettes(recipeDao.getAll());
    }

    public void addToFavorite() {
        System.out.println("com.utbm.projet.ihm.view.HomeView.addToFavorite()");
        if ("heart".equals(homeModel.getHeartClass())) {
            homeModel.setHeartClass("red-heart");
        } else {
            homeModel.setHeartClass("heart");
        }
    }

}
