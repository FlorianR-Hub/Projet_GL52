/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.view.favorites;

import com.utbm.projet.ihm.controller.FavoritesController;
import com.utbm.projet.ihm.view.GenericView;
import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * @author neid
 */
/**
 * View class of the Home page.
 */
@ManagedBean
@Scope("session")
public class FavoritesView extends GenericView {

    @Autowired
    private FavoritesController favoritesController;

    @Override
    public void initView() {
        // The initView() method is called for each AJAX call.
        // We only want to call it when we load the page.
        if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
            return;
        }

        favoritesController.initModel();
    }

    public void removeFromFavorite(Long recipeId) {
        favoritesController.removeFromFavorite(recipeId);
    }

    public String reduceText(String text) {
        return text.substring(0, text.length() > 100 ? 100 : text.length()) + "...";
    }

}
