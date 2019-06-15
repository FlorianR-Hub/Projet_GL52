package com.utbm.projet.ihm.controller;

/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
import com.utbm.projet.dao.data.Recette;
import com.utbm.projet.dao.data.Utilisateur;
import com.utbm.projet.dao.interf.UserDao;
import com.utbm.projet.ihm.model.HomeModel;
import com.utbm.projet.ihm.model.TemplateModel;
import com.utbm.projet.service.interf.RecipeService;
import com.utbm.projet.util.AccountTypes;
import java.util.ArrayList;
import java.util.Objects;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
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
    }

    public String formatTempsDePreparation(int temps) {
        if (temps < 60) {
            return (temps < 10 ? "0" + temps : temps) + "min";
        }
        int hours = temps / 60;
        int minutes = temps % 60;
        return (hours < 10 ? "0" + hours : hours) + "h" + (minutes < 10 ? "0" + minutes : minutes);
    }

    public void setFavorite(String recipeId, String iconId) {
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
        for (Recette rec : homeModel.getRecettes()) {
            if (Objects.equals(rec.getNumRecette(), Long.valueOf(recipeId))) {
                recipe = rec;
                break;
            }
        }

        String classToAdd;
        String classToRemove;
        String message;

        if (estPreferee(recipeId)) {
            user.getRecetteList().remove(recipe);
            classToAdd = homeModel.getHeartClass();
            classToRemove = homeModel.getRedHeartClass();
            message = "La recette a été supprimée de vos favoris.";
        } else {
            user.getRecetteList().add(recipe);
            classToAdd = homeModel.getRedHeartClass();
            classToRemove = homeModel.getHeartClass();
            message = "La recette a été ajoutée à vos favoris.";
        }

        userDao.update(user);

        PrimeFaces.current().executeScript("setPreferer('" + iconId + "', '" + classToAdd + "', '" + classToRemove + "');");

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }

    /**
     * Vérifie si une recette appartient à la liste des recettes préférées de
     * l'utilisateur et renvoie la classe CSS correspondante.
     *
     * @param recipeId L'id de la recette
     * @return la classe CSS correspondante
     */
    public String heartClass(String recipeId) {
        if (estPreferee(recipeId)) {
            return homeModel.getRedHeartClass();
        }
        return homeModel.getHeartClass();
    }

    public boolean estPreferee(String recipeId) {
        if (recipeId == null) {
            throw new NullPointerException("L'id de la recette ne peut être null");
        }

        Long userAuthId = templateModel.getUserAuth().getId();
        Utilisateur user = userDao.getByUserAuthId(userAuthId);

        if (user.getRecetteList() == null) {
            return false;
        }

        for (Recette rec : user.getRecetteList()) {
            if (Objects.equals(rec.getNumRecette(), Long.valueOf(recipeId))) {
                return true;
            }
        }
        return false;
    }
}
