package com.utbm.projet.ihm.controller;

/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
import com.utbm.projet.dao.data.Utilisateur;
import com.utbm.projet.dao.interf.UserDao;
import com.utbm.projet.ihm.model.HomeModel;
import com.utbm.projet.ihm.model.TemplateModel;
import com.utbm.projet.service.interf.RecipeService;
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
    private TemplateModel templateModel;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RecipeService recipeService;

    @Override
    public void initModel() {
        Long userAuthId = templateModel.getUserAuth().getId();
        Utilisateur user = userDao.getByUserAuthId(userAuthId);

        homeModel.setRecettes(recipeService.getDailyRecipes(user));
        homeModel.setHeartClass("heart");
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
