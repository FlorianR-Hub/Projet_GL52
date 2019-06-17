/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.controller;

import com.utbm.projet.dao.data.Recette;
import com.utbm.projet.dao.data.Utilisateur;
import com.utbm.projet.dao.interf.UserDao;
import com.utbm.projet.ihm.model.FavoritesModel;
import com.utbm.projet.ihm.model.TemplateModel;
import com.utbm.projet.service.interf.RecipeService;
import com.utbm.projet.util.AccountTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author neid
 */
@ManagedBean
@Scope("session")
public class FavoritesController extends GenericController {

    @Autowired
    private FavoritesModel favoritesModel;

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

        this.favoritesModel.setRecettesFavorites(user.getRecetteList());
    }

    public String reduceText(String text) {
        return text.substring(0, 100) + "...";
    }

    public void removeFromFavorite(Long recipeId) {
        if (recipeId == null) {
            throw new NullPointerException("L'id de la recette ne peut être null");
        }

        if (templateModel.getUserAuth().getAccountType() != AccountTypes.UTILISATEUR.getId()) {
            return;
        }

        Long userAuthId = templateModel.getUserAuth().getId();
        Utilisateur user = userDao.getByUserAuthId(userAuthId);

        if (user.getRecetteList() == null) {
            user.setRecetteList(new ArrayList<>());
        }

        Recette recipe = null;
        for (Recette rec : favoritesModel.getRecettesFavorites()) {
            if (Objects.equals(rec.getNumRecette(), recipeId)) {
                recipe = rec;
                break;
            }
        }

        favoritesModel.getRecettesFavorites().remove(recipe);
        user.getRecetteList().remove(recipe);

        String message = "La recette a été retirée de vos favoris.";
        userDao.update(user);

        FacesContext.getCurrentInstance().addMessage("favoritesForm", new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
    }

}
